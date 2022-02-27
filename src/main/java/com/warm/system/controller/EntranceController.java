package com.warm.system.controller;

import com.warm.system.common.Dic;
import com.warm.system.entity.H2MetaLoc;
import com.warm.system.entity.Loc;
import com.warm.system.service.db1.LocPgService;
import com.warm.system.service.db2.H2MeatLocService;
import com.warm.system.service.db2.LocH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * 访问数据库的入口，缓存在这里被维护
 *
 * @author xuchuanqi
 * @date 2022/2/23 21:22.
 */
@RestController
public class EntranceController {

    @Autowired
    LocPgService locPgService;
    @Autowired
    LocH2Service locH2Service;
    @Autowired
    H2MeatLocService h2MeatLocService;
    @Autowired
    PrefetchHandler prefetchHandler;
    @Autowired
    ReplacementHandler replaceHandler;

    @GetMapping("access")
    public List<Loc> accessDB(double minLon, double maxLon,
                              double minLat, double maxLat,
                              @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date minDate,
                              @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date maxDate) {
        Dic.numAcc++;
        System.out.println("--------------");

        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = minDate.toInstant();
        LocalDateTime minTime = instant.atZone(zoneId).toLocalDateTime();
        Instant instant1 = maxDate.toInstant();
        LocalDateTime maxTime = instant1.atZone(zoneId).toLocalDateTime();

        // 先查看缓存中，是否命中
        List<H2MetaLoc> list = h2MeatLocService.list(minLon, maxLon, minLat, maxLat, minTime, maxTime);
        if (!list.isEmpty()) {
            List<Loc> list1 = locH2Service.list(minLon, maxLon, minLat, maxLat, minTime, maxTime);
            // 热度维护 TODO
//            heat(list1);
            return list1;
        }

        // 一期，跳过拆分查询，有点费劲。

        // 如果没有命中，直接查询数据库返回。
        List<Loc> resultList = locPgService.list(minLon, maxLon, minLat, maxLat, minTime, maxTime);
        // 查询数据库后，将数据缓存下来。
        Dic.pool.execute(() -> fangruhuancun(resultList, minLon, maxLon, minLat, maxLat, minTime, maxTime));
        return resultList;
    }

    /**
     * 主程序部分，用线程隔离开。
     *
     * @param resultList
     * @param minLon
     * @param maxLon
     * @param minLat
     * @param maxLat
     * @param minTime
     * @param maxTime
     */
    private void fangruhuancun(List<Loc> resultList, double minLon, double maxLon, double minLat, double maxLat, LocalDateTime minTime, LocalDateTime maxTime) {

        // 没有命中，是否分拆查询，只有符合拆分后，仍然容易查询的情况下，此时拆分具有提速效果。// 拆分比较难做，先跳过...。
        /**
         * 是否在临近区域内，或者相交。、
         */
        H2MetaLoc range = h2MeatLocService.near(minLon, maxLon, minLat, maxLat, minTime, maxTime);
        if (null == range) {
            // 没有临近时空缓存
            H2MetaLoc metaLoc = new H2MetaLoc(null, minLon, maxLon, minLat, maxLat, minTime, maxTime, resultList.size());
            h2MeatLocService.save(metaLoc);
            if (!resultList.isEmpty()) {
                locH2Service.insertBatch(resultList);
            }
        } else {
            // 有临近时空缓存，并获取最大查询范围，
            List<Loc> hhh = locPgService.list(range.getMinLon(), range.getMaxLon(), range.getMinLat(), range.getMaxLat(), range.getMinTime(), range.getMaxTime());
            range.setId(null);
            range.setSum(hhh.size());
            h2MeatLocService.save(range);
            if (!hhh.isEmpty())
                locH2Service.insertBatch(hhh);
//            heat(); TODO
            return;
        }

        // 这里没有拆分。
//        List<H2MetaLoc> list = h2MeatLocService.overlap(minLon, maxLon, minLat, maxLat, minTime, maxTime);
//        直接存入，
//
//        然后，判断预读取
//
//        然后替换算法执行。
    }
}
