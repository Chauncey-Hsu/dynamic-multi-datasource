package com.warm.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.warm.system.entity.AccessSerial;
import com.warm.system.entity.AheatSerial;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@Repository
public interface AheatSerialMapper extends BaseMapper<AheatSerial> {

    @Select("select sum(summ) from aheat_serial")
    Integer sumSum();

    @Select("select * from aheat_serial order by hot asc limit 1")
    List<AheatSerial> getColdest();
}
