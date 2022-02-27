package com.warm.system.service.db1;

import com.baomidou.mybatisplus.service.IService;
import com.warm.system.entity.Loc;
import com.warm.system.entity.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
public interface LocPgService extends IService<Loc> {

    List<Loc> list(double minLon, double maxLon, double minLat, double maxLat, LocalDateTime minTime, LocalDateTime maxTime);
}
