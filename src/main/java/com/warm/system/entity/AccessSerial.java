package com.warm.system.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xuchuanqi
 * @date 2022/2/27 19:21.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("access_serial")
public class AccessSerial {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    private Integer cacheId;
    /**
     * 年龄
     */
    private Integer summ;
//    /**
//     * 创建时间
//     */
//    @TableField(value = "create_time",fill = FieldFill.INSERT)
//    private Date createTime;
//    /**
//     * 修改时间
//     */
//    @TableField(value = "modify_time",fill = FieldFill.INSERT_UPDATE)
//    private Date modifyTime;

}
