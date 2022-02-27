package com.warm.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.warm.system.entity.Loc;
import com.warm.system.mapper.LocPgMapper;
import com.warm.system.service.db1.LocPgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@Service
public class LocPgServiceImpl extends ServiceImpl<LocPgMapper, Loc> implements LocPgService {
    @Autowired
    LocPgMapper locPgMapper;

    @Override
    public List<Loc> list(double minLon, double maxLon, double minLat, double maxLat, LocalDateTime minTime, LocalDateTime maxTime) {
        return locPgMapper.list(minLon, maxLon, minLat, maxLat, minTime, maxTime);
    }
}
