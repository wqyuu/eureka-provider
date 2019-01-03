package cn.wqy.eureka.provider.dao;

import cn.wqy.eureka.provider.entity.PlanUser;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(PlanUser record);

    int insertSelective(PlanUser record);

    PlanUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(PlanUser record);

    int updateByPrimaryKey(PlanUser record);
}