package cn.wqy.eureka.provider.service;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {

    int deleteByPrimaryKey(T record);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String habitId);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> select(Map<String,Object> params);
}
