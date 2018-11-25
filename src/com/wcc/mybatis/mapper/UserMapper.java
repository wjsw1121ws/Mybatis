package com.wcc.mybatis.mapper;

import com.wcc.mybatis.pojo.QueryVo;
import com.wcc.mybatis.pojo.User;

import java.util.List;

/**
 * @Description:
 * @ClassName: UserMapper
 * @Auther: changchun_wu
 * @Date: 2018/11/25 2:51
 * @Version: 1.0
 **/
public interface UserMapper {

/*
编写Mapper实体类遵循四个原则
1.  Mapper.xml中的namespace与Mapper的类路径相同
2.  Mapper接口方法名与Mapper.xml中的每个statement的id相同
3.  Mpper接口中的输入参数与Mapper.xml中定义的每个sql的parmeterType的类型相同
4.  Mpper接口中的输出参数与Mapper.xml中定义的每个sql的resultType的类型相同
*/

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 23:51
     * @Description: 查询用户以及和他关联的订单信息
     **/

    List<User> findAllUserAndOrder();
    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 3:11
     * @Description: 根据id查询用户
     **/
    User findUserById(Integer id);

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 3:12
     * @Description: 根据用户名模糊查询用户
     **/
    List<User> findUserByUsername(String username);

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 3:15
     * @Description: 保存用户
     **/
    void saveUser(User user);

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 3:19
     * @Description: 更新用户
     **/
    void updateUser(User user);

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 3:21
     * @Description: 删除用户
     **/
    void deleteUserById(Integer id);

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 20:08
     * @Description: 使用QueryVo模糊查询用户
     **/
    List<User> findUserByQueryVo(QueryVo vo);

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 20:09
     * @Description: 查询所有用户
     **/
    Integer findAllCount();

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 21:15
     * @Description: 根据性别和名字查询用户
     **/
    List<User> finBySexAndUsername(User user);

    /**
     * @Author: changchun_wu
     * @Date: 2018/11/25 21:53
     * @Description: 根据多个id查询多个用户
     **/
    List<User> findUserByIds(QueryVo vo);
    List<User> findUserByIds1(QueryVo vo);
    List<User> findUserByIds2(Integer[] array);
    List<User> findUserByIds3(List<Integer> ads);


}
