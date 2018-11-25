package com.wcc.mybatis.test;

import com.wcc.mybatis.mapper.UserMapper;
import com.wcc.mybatis.pojo.QueryVo;
import com.wcc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @ClassName: MapperTest
 * @Auther: changchun_wu
 * @Date: 2018/11/25 2:53
 * @Version: 1.0
 **/


public class UserMapperTest {

    @Test
    public void findAllUserAndOrder() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findAllUserAndOrder();
        for (User user : list) {
            System.out.println(user);
        }
    }



    @Test
    public void findUserById() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(10);
        System.out.println(user);
    }

    @Test
    public void findUserByUsername() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findUserByUsername("五");
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 2:49
     * @Description: 保存用户
     **/
    @Test
    public void saveUser() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("刘思思");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("北京");
        mapper.saveUser(user);
        sqlSession.commit();
        System.out.println(user.getId());
    }

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 2:49
     * @Description: 更新用户
     **/
    @Test
    public void updateUser() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(33);
        user.setUsername("和菊花");
        user.setBirthday(new Date());
        user.setSex("妖");
        user.setAddress("河北");
        mapper.updateUser(user);
        sqlSession.commit();
    }

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 2:49
     * @Description: 根据id删除用户
     **/
    @Test
    public void deleteUserById() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUserById(33);
        sqlSession.commit();
    }

    @Test
    public void finAllCount() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer integer = mapper.findAllCount();
        System.out.println(integer);

    }

    @Test
    public void finBySexAndUsername() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        /*user.setSex("1");*/
        user.setUsername("张");
        List<User> users = mapper.finBySexAndUsername(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void findUserByIds() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(22);
        list.add(25);
        vo.setListIds(list);
        List<User> users = mapper.findUserByIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserByIds1() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer[] array = {10, 22, 26};
        QueryVo vo = new QueryVo();
        vo.setIds(array);
        List<User> list = mapper.findUserByIds1(vo);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserByIds2() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer[] array = {1, 26, 32};
        List<User> user = mapper.findUserByIds2(array);
        for (User user1 : user) {
            System.out.println(user1);
        }

    }

    @Test
    public void findUserByIds3() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(26);
        list.add(32);
        List<User> users = mapper.findUserByIds3(list);
        for (User user : users) {
            System.out.println(user);
        }

    }
}
