package com.warm.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 缓存项的 元数据。
 * //@TableName(value = "paper1.beidou_ship_location_history_3")
 *
 * @author xuchuanqi
 * @date 2022/2/25 20:48.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class H2MetaLoc {


    @TableField("id")
    private Integer id;

    @TableField("minLon")
    private Double minLon;
    @TableField("maxLon")
    private Double maxLon;
    @TableField("minLat")
    private Double minLat;
    @TableField("maxLat")
    private Double maxLat;
    @TableField("minTime")
    private LocalDateTime minTime;
    @TableField("maxTime")
    private LocalDateTime maxTime;
    @TableField("SUM")
    private int sum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        H2MetaLoc metaLoc = (H2MetaLoc) o;
        return Objects.equals(minLon, metaLoc.minLon) && Objects.equals(maxLon, metaLoc.maxLon) && Objects.equals(minLat, metaLoc.minLat) && Objects.equals(maxLat, metaLoc.maxLat) && Objects.equals(minTime, metaLoc.minTime) && Objects.equals(maxTime, metaLoc.maxTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minLon, maxLon, minLat, maxLat, minTime, maxTime);
    }
}
