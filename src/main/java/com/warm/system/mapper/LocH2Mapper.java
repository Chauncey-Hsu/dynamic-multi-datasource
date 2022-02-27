package com.warm.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.warm.system.entity.Loc;
import com.warm.system.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
public interface LocH2Mapper extends BaseMapper<Loc> {

    @Select("select * from LOC where \"LONGITUDE\" > #{minLon} and \"LONGITUDE\" < #{maxLon} and \"LATITUDE\" > #{minLat} " +
            "and \"LATITUDE\" < #{maxLat} and \"UTC\" > #{minTime} and \"UTC\" < #{maxTime}")
    List<Loc> list(@Param("minLon") double minLon, @Param("maxLon") double maxLon,
                   @Param("minLat") double minLat, @Param("maxLat") double maxLat,
                   @Param("minTime") LocalDateTime minTime, @Param("maxTime") LocalDateTime maxTime);


    @Delete("delete from LOC where \"LONGITUDE\" >= #{minLon} and \"LONGITUDE\" <= #{maxLon} and \"LATITUDE\" >= #{minLat} " +
            "and \"LATITUDE\" <= #{maxLat} and \"UTC\" >= #{minTime} and \"UTC\" <= #{maxTime}")
    void delete1(@Param("minLon") double minLon, @Param("maxLon") double maxLon,
                 @Param("minLat") double minLat, @Param("maxLat") double maxLat,
                 @Param("minTime") LocalDateTime minTime, @Param("maxTime") LocalDateTime maxTime);
}
