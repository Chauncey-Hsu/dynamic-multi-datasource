package com.warm.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

/**
 * @author xuchuanqi
 * @date 2022/2/23 16:49.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("LOC")
public class Loc {
    private static final long serialVersionUID = 1L;

    @TableField("TERMINAL_CODE")
    private String terminalCode;
    @TableField("COMM_TYPE")
    private Integer commType;
    @TableField("POS_TYPE")
    private Integer posType;
    @TableField("UTC")
    private Date utc;
    @TableField("LONGITUDE")
    private double longitude;
    @TableField("LATITUDE")
    private double latitude;
    @TableField("COURSE")
    private Integer course;
    @TableField("TRUEHEADING")
    private Integer trueheading;
    @TableField("SPEED")
    private Double speed;
    @TableField("STATUS")
    private Integer status;
    @TableField("STORAGE_TIME")
    private Date storageTime;
    @TableField("ID")
    private Integer id;
    @TableField("VDESC")
    private String vdesc;
    @TableField("SHIPID")
    private String shipid;
    @TableField("MMSI")
    private String mmsi;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loc loc = (Loc) o;
        return Double.compare(loc.longitude, longitude) == 0 && Double.compare(loc.latitude, latitude) == 0 && Objects.equals(terminalCode, loc.terminalCode) && Objects.equals(commType, loc.commType) && Objects.equals(utc, loc.utc) && Objects.equals(course, loc.course) && Objects.equals(speed, loc.speed) && Objects.equals(vdesc, loc.vdesc) && Objects.equals(shipid, loc.shipid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(terminalCode, commType, utc, longitude, latitude, course, speed, vdesc, shipid);
    }
}
