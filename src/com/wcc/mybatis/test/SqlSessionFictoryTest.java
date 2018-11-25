package com.wcc.mybatis.test;

import com.wcc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @ClassName: SqlSessionFictoryTest
 * @Auther: changchun_wu
 * @Date: 2018/11/25 2:15
 * @Version: 1.0
 **/
public class SqlSessionFictoryTest {
    @Test
    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 2:48
     * @Description: 通过id查询用户
     **/
    public void findUserById() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("com.wcc.mybatis.pojo.User.findUserById",10);
        System.out.println(user);
    }
    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 2:48
     * @Description: 通过用户名模糊查询用户
     **/
    @Test
    public void findUserByUsername() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("com.wcc.mybatis.pojo.User.findUserByUsername", "五");
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
        User user = new User();
        user.setUsername("李如花");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("北京");
        sqlSession.insert("com.wcc.mybatis.pojo.User.saveUser",user);
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
        User user = new User();
        user.setId(31);
        user.setUsername("和菊花");
        user.setBirthday(new Date());
        user.setSex("妖");
        user.setAddress("河北");
        sqlSession.update("com.wcc.mybatis.pojo.User.updateUser",user);
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
        sqlSession.delete("com.wcc.mybatis.pojo.User.deleteUserById",30);
        sqlSession.commit();
    }

}
