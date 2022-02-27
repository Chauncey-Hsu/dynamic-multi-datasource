package com.warm.system.service.db2;

import com.baomidou.mybatisplus.service.IService;
import com.warm.system.entity.H2MetaLoc;
import com.warm.system.entity.Loc;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
public interface H2MeatLocService extends IService<H2MetaLoc> {


    List<H2MetaLoc> list(double minLon, double maxLon, double minLat, double maxLat, LocalDateTime minTime, LocalDateTime maxTime);

    H2MetaLoc near(double minLon, double maxLon, double minLat, double maxLat, LocalDateTime minTime, LocalDateTime maxTime);

    void save(H2MetaLoc metaLoc);

}
