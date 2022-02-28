package com.warm.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.warm.system.entity.H2MetaLoc;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@Repository
public interface H2MetaLocMapper extends BaseMapper<H2MetaLoc> {

    @Select("select * from H2_META_LOC where ID = #{id}")
    H2MetaLoc selectById1(@Param("id") Integer id);

    /**
     * 查询在条件时空范围内的数据
     *
     * @param minLon
     * @param maxLon
     * @param minLat
     * @param maxLat
     * @param minTime
     * @param maxTime
     * @return
     */
    @Select("select * from H2_META_LOC where \"minLon\" <= #{minLon} and \"maxLon\" >= #{maxLon} and \"minLat\" <= #{minLat} " +
            "and \"maxLat\" >= #{maxLat} and \"minTime\" <= #{minTime} and \"maxTime\" >= #{maxTime}")
    List<H2MetaLoc> list(@Param("minLon") double minLon, @Param("maxLon") double maxLon,
                         @Param("minLat") double minLat, @Param("maxLat") double maxLat,
                         @Param("minTime") LocalDateTime minTime, @Param("maxTime") LocalDateTime maxTime);

    @Select("select * from H2_META_LOC")
    List<H2MetaLoc> all();
}
