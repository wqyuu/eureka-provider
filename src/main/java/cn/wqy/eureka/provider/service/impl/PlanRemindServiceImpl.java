package cn.wqy.eureka.provider.service.impl;

import cn.wqy.eureka.provider.dao.PlanRemindMapper;
import cn.wqy.eureka.provider.entity.PlanRemind;
import cn.wqy.eureka.provider.service.PlanRemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlanRemindServiceImpl implements PlanRemindService {

    @Autowired
    private PlanRemindMapper remindMapper;

    @Override
    public int deleteByPrimaryKey(PlanRemind record) {
        return remindMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int insert(PlanRemind record) {
        return remindMapper.insert(record);
    }

    @Override
    public int insertSelective(PlanRemind record) {
        return remindMapper.insertSelective(record);
    }

    @Override
    public PlanRemind selectByPrimaryKey(String habitId) {
        return remindMapper.selectByPrimaryKey(habitId);
    }

    @Override
    public int updateByPrimaryKeySelective(PlanRemind record) {
        return remindMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PlanRemind record) {
        return remindMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PlanRemind> select(Map<String, Object> params) {
        return remindMapper.select(params);
    }
}
