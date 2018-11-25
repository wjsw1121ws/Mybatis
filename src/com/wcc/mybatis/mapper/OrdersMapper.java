package com.wcc.mybatis.mapper;

import com.wcc.mybatis.pojo.Orders;

import java.util.List;

/**
 * @Description:
 * @ClassName: OrdersMapper
 * @Auther: changchun_wu
 * @Date: 2018/11/25 20:19
 * @Version: 1.0
 **/
public interface OrdersMapper {

    List<Orders> findAllOrders();
    List<Orders> findAllOrdersAndUsername();
}
