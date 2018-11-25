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
import java.util.List;

/**
 * @Description:
 * @ClassName: TestQueryVo
 * @Auther: changchun_wu
 * @Date: 2018/11/25 20:06
 * @Version: 1.0
 **/
public class TestQueryVo {
    @Test
    public void findUserByQueryVo() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("五");
        vo.setUser(user);
        List<User> users = mapper.findUserByQueryVo(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
}
