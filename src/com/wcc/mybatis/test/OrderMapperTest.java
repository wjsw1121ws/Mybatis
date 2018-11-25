package com.wcc.mybatis.test;

import com.wcc.mybatis.mapper.OrdersMapper;
import com.wcc.mybatis.pojo.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description:
 * @ClassName: OrderMapperTest
 * @Auther: changchun_wu
 * @Date: 2018/11/25 20:26
 * @Version: 1.0
 **/
public class OrderMapperTest {

    @Test
    public void findAllOrders() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> orders = mapper.findAllOrders();
        for (Orders order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void findAllOrdersAndUsername() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> list = mapper.findAllOrdersAndUsername();
        for (Orders orders : list) {
            System.out.println(orders);
        }
    }

}
