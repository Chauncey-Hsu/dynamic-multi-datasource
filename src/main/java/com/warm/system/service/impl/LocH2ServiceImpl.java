package com.warm.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.warm.system.entity.Loc;
import com.warm.system.mapper.LocH2Mapper;
import com.warm.system.service.db2.LocH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@Service
public class LocH2ServiceImpl extends ServiceImpl<LocH2Mapper, Loc> implements LocH2Service {
    @Autowired
    LocH2Mapper locH2Mapper;

    @Override
    public List<Loc> list(double minLon, double maxLon, double minLat, double maxLat, LocalDateTime minTime, LocalDateTime maxTime) {
        return locH2Mapper.list(minLon, maxLon, minLat, maxLat, minTime, maxTime);
    }

    @Override
    public void delete1(Double minLon, Double maxLon, Double minLat, Double maxLat, LocalDateTime minTime, LocalDateTime maxTime) {
        locH2Mapper.delete1(minLon, maxLon, minLat, maxLat, minTime, maxTime);
    }

    @Override
    public void insertBatch1(List<Loc> resultList) {
        insertBatch(resultList);
    }
//    @Autowired
//    private OrderMapper orderMapper;
//
//    @Override
//    public List<User> getUserList() {
//        return selectList(null);
//    }
//
//    @DataSourceSwitch(DBTypeEnum.db2)
//    @Override
//    public BigDecimal getOrderPriceByUserId(Integer userId) {
//        return orderMapper.getPriceByUserId(userId);
//    }
}
