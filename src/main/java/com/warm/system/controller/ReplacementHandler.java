package com.warm.system.controller;

import com.warm.system.common.Dic;
import com.warm.system.entity.AccessSerial;
import com.warm.system.entity.AheatSerial;
import com.warm.system.entity.H2MetaLoc;
import com.warm.system.service.db1.AccessSerialService;
import com.warm.system.service.db1.AheatSerialService;
import com.warm.system.service.db1.LocPgService;
import com.warm.system.service.db2.H2MeatLocService;
import com.warm.system.service.db2.LocH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;


/**
 * @author xuchuanqi
 * @date 2022/2/25 20:35.
 */
@Controller
public class ReplacementHandler {

    @Autowired
    LocPgService locPgService;
    @Autowired
    LocH2Service locH2Service;
    @Autowired
    H2MeatLocService h2MeatLocService;
    @Autowired
    AccessSerialService accessSerialService;
    @Autowired
    AheatSerialService aheatSerialService;

    /**
     * 访问次序
     *
     * @param h2MetaLoc
     * @param o
     */
    public void accessHot(H2MetaLoc h2MetaLoc, Object o) {
        // 访问序列-新增一个节点，-更新热度序列
        AccessSerial accessSerial = new AccessSerial(null, h2MetaLoc.getId(), h2MetaLoc.getSum());
        accessSerialService.save(accessSerial);
        Integer headId = accessSerial.getId();
        updateHot(h2MetaLoc.getId(), h2MetaLoc.getSum());

        // 访问序列-删除一个节点。-更新热度序列
        int tailId = headId - Dic.lengthOfAccess;
        if (tailId > 0) {
            AccessSerial tail = accessSerialService.selectById1(tailId);
            accessSerialService.deleteById1(tailId);
            updateHot(tail.getCacheId(), tail.getSumm());
            //访问顺序没有了，不代表元数据没有了。
        }

        // 替换
        replace();
    }

    private void replace() {
        // 需要保证所有的元数据在 hot中都有对应。h2元数据和hot是一一对应的，同时存在，同时删除。
        Integer sum = aheatSerialService.sumSum();
        while (sum != null && sum >= Dic.lengthOfCache) {
            AheatSerial aheatSerial = aheatSerialService.getColdest();
            aheatSerialService.deleteById(aheatSerial.getId()); // 删1
            H2MetaLoc metaLoc = h2MeatLocService.selectById1(aheatSerial.getId());
            h2MeatLocService.deleteById1(aheatSerial.getId());// 删2 失败。
            locH2Service.delete1(metaLoc.getMinLon(), metaLoc.getMaxLon(), metaLoc.getMinLat(), metaLoc.getMaxLat(), metaLoc.getMinTime(), metaLoc.getMaxTime()); // 删3
            sum = aheatSerialService.sumSum();
        }
    }

    private void updateHot(Integer cacheId, Integer sum) {
        Integer f = accessSerialService.getF(cacheId);
        Double fff = f.equals(0) ? 0.1 : Double.valueOf(f);
        Double hot = fff / Double.valueOf(sum);

        AheatSerial aheatSerial = aheatSerialService.selectById1(cacheId);
        if (aheatSerial == null) {
            // 不具有写入权限。
        } else {
            aheatSerial.setHot(hot);
            aheatSerial.setUpdateTime(LocalDateTime.now());
            aheatSerialService.updateById1(aheatSerial);
        }
    }
}
