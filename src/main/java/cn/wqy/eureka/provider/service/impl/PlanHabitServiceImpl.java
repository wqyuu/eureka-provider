package cn.wqy.eureka.provider.service.impl;

import cn.wqy.eureka.provider.dao.PlanHabitMapper;
import cn.wqy.eureka.provider.entity.PlanHabit;
import cn.wqy.eureka.provider.service.PlanHabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlanHabitServiceImpl implements PlanHabitService {

   @Autowired
   private PlanHabitMapper habitMapper;


    @Override
    public int deleteByPrimaryKey(PlanHabit record) {
        return habitMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int insert(PlanHabit record) {
        return habitMapper.insert(record);
    }

    @Override
    public int insertSelective(PlanHabit record) {
        return habitMapper.insertSelective(record);
    }

    @Override
    public PlanHabit selectByPrimaryKey(String habitId) {
        return habitMapper.selectByPrimaryKey(habitId);
    }

    @Override
    public int updateByPrimaryKeySelective(PlanHabit record) {
        return habitMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PlanHabit record) {
        return habitMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PlanHabit> select(Map<String,Object> params) {
        return habitMapper.select(params);
    }
}
