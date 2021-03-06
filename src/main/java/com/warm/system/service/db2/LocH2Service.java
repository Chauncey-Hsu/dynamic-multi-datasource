package com.warm.system.service.db2;

import com.baomidou.mybatisplus.service.IService;
import com.warm.system.entity.Loc;
import com.warm.system.entity.Order;

import java.math.BigDecimal;
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
public interface LocH2Service extends IService<Loc> {


    List<Loc> list(double minLon, double maxLon, double minLat, double maxLat, LocalDateTime minTime, LocalDateTime maxTime);

    void delete1(Double minLon, Double maxLon, Double minLat, Double maxLat, LocalDateTime minTime, LocalDateTime maxTime);

    void insertBatch1(List<Loc> resultList);
}
