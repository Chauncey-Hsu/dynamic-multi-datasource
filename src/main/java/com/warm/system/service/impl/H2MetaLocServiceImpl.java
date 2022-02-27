package com.warm.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.warm.system.entity.H2MetaLoc;
import com.warm.system.mapper.H2MetaLocMapper;
import com.warm.system.mapper.LocH2Mapper;
import com.warm.system.service.db2.H2MeatLocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@Service
public class H2MetaLocServiceImpl extends ServiceImpl<H2MetaLocMapper, H2MetaLoc> implements H2MeatLocService {
    @Autowired
    H2MetaLocMapper h2MetaLocMapper;
    @Autowired
    LocH2Mapper locH2Mapper;

    @Override
    public List<H2MetaLoc> list(double minLon, double maxLon, double minLat, double maxLat, LocalDateTime minTime, LocalDateTime maxTime) {

        return h2MetaLocMapper.list(minLon, maxLon, minLat, maxLat, minTime, maxTime);
    }

    @Override
    public H2MetaLoc near(double minLon, double maxLon, double minLat, double maxLat, LocalDateTime minTime, LocalDateTime maxTime) {
        H2MetaLoc tempMeta = new H2MetaLoc(null, minLon, maxLon, minLat, maxLat, minTime, maxTime, 0);

        List<H2MetaLoc> resultList = new LinkedList<>();
        List<H2MetaLoc> list = h2MetaLocMapper.all();
        for (int i = 0; i < list.size(); i++) {
            H2MetaLoc meta = list.get(i);

            if (meta.equals(tempMeta)){
                continue;
            }
            double gapLon = Math.max(Math.abs(minLon-meta.getMinLon()), Math.abs(maxLon-meta.getMaxLon()));
            double gapLat = Math.max(Math.abs(minLat-meta.getMinLat()), Math.abs(maxLat-meta.getMaxLat()));
            double minutes = Math.max(Math.abs(Duration.between(minTime,meta.getMinTime()).toMinutes()), Math.abs(Duration.between(maxTime, meta.getMaxTime()).toMinutes()));

            /*LinkedList<LocalDateTime> timeList = new LinkedList<>();
            timeList.add(meta.getMinTime());
            timeList.add(meta.getMaxTime());
            timeList.add(minTime);
            timeList.add(maxTime);
            Collections.sort(timeList);
            Duration between = Duration.between(timeList.get(2), timeList.get(1));
            long minutes = between.toMinutes();*/
            double gapDays = minutes/60/24;
            double gap = Math.pow((Math.pow(gapLon, 2) + Math.pow(gapLat, 2) + Math.pow(gapDays, 2)), 0.5);
            // TODO gap定为多少呢？ 0.01度、 0.01度 、 0.01 天 距离为0.02。
            if (gap <= 0.02) {
                // 距离过小
                resultList.add(meta);
            }
        }


        if (!resultList.isEmpty()) {

            // 计算这个歌meta的最大时空范围
            List<Double> lons = new LinkedList<>();
            List<Double> lats = new LinkedList<>();
            List<LocalDateTime> ts = new LinkedList<>();
            for (int i = 0; i < resultList.size(); i++) {
                H2MetaLoc metaLoc = resultList.get(i);
                lons.add(metaLoc.getMinLon());
                lons.add(metaLoc.getMaxLon());
                lats.add(metaLoc.getMaxLat());
                lats.add(metaLoc.getMinLat());
                ts.add(metaLoc.getMaxTime());
                ts.add(metaLoc.getMinTime());
                locH2Mapper.delete1(metaLoc.getMinLon(), metaLoc.getMaxLon(), metaLoc.getMinLat(), metaLoc.getMaxLat(), metaLoc.getMinTime(), metaLoc.getMaxTime());
                h2MetaLocMapper.deleteById(metaLoc.getId());
//                heat();TODO
            }
            lons.add(tempMeta.getMinLon());
            lons.add(tempMeta.getMaxLon());
            lats.add(tempMeta.getMaxLat());
            lats.add(tempMeta.getMinLat());
            ts.add(  tempMeta.getMaxTime());
            ts.add(  tempMeta.getMinTime());
            Collections.sort(lons);
            Collections.sort(lats);
            Collections.sort(ts);
            return new H2MetaLoc(0, lons.get(0), lons.get(lons.size() - 1), lats.get(0), lats.get(lats.size() - 1),
                    ts.get(0), ts.get(ts.size() - 1), 0);
        }
        // 没有临近范围，
        return null;
    }

    @Override
    public void save(H2MetaLoc metaLoc) {
        h2MetaLocMapper.insert(metaLoc);
    }
}
