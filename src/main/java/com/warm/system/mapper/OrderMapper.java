package com.warm.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.warm.system.entity.Order;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
public interface OrderMapper extends BaseMapper<Order> {

    @Select("SELECT price from t_order where user_id =#{userId}")
    BigDecimal getPriceByUserId(Integer userId);

    @Select("SELECT id AS \"id\",order_no AS \"orderNo\",user_id AS \"userId\",price,paid_time AS \"paidTime\",create_time AS \"createTime\",modify_time AS \"modifyTime\" FROM t_order")
    List<Order> getAll();
}
