package com.warm.system.service.db1;

import com.baomidou.mybatisplus.service.IService;
import com.warm.system.entity.AheatSerial;
import com.warm.system.entity.Loc;

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
public interface AheatSerialService extends IService<AheatSerial> {

    Integer insert1(AheatSerial aheatSerial);

    Integer sumSum();

    AheatSerial getColdest();

    void deleteById1(Integer id);

    AheatSerial selectById1(Integer cacheId);

    void updateById1(AheatSerial aheatSerial);
}
