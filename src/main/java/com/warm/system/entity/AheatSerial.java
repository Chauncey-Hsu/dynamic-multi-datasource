package com.warm.system.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author xuchuanqi
 * @date 2022/2/27 19:23.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("aheat_serial")
public class AheatSerial {

    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    private Double hot;
    private Integer summ;
    private LocalDateTime updateTime;
}
