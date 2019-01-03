package cn.wqy.eureka.provider.service.impl;

import cn.wqy.eureka.provider.dao.PlanUserMapper;
import cn.wqy.eureka.provider.entity.PlanUser;
import cn.wqy.eureka.provider.service.PlanUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanUserServiceImpl implements PlanUserService {

    @Autowired
    PlanUserMapper userMapper;

    @Override
    public int addUser(PlanUser planUser) {
        return  userMapper.insertSelective(planUser);
    }
}
