package com.wcc.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @ClassName: QueryVo
 * @Auther: changchun_wu
 * @Date: 2018/11/25 18:34
 * @Version: 1.0
 **/
public class QueryVo implements Serializable {
    private User user;
    private List<Integer> list;
    private Integer[] array;

    public void setIds(Integer[] array) {
        this.array = array;
    }

    public void setListIds(List<Integer> list) {
        this.list = list;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
