package com.warm.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.warm.system.entity.AccessSerial;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@Repository
public interface AccessSerialMapper extends BaseMapper<AccessSerial> {


    @Select("select count(*) from access_serial where cache_id = #{cacheId}")
    Integer getF(@Param("cacheId") Integer cacheId);
}
