package cn.wqy.eureka.provider.service.impl;

import cn.wqy.eureka.provider.dao.PlanNodeMapper;
import cn.wqy.eureka.provider.entity.PlanNode;
import cn.wqy.eureka.provider.service.PlanNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlanNodeServiceImpl implements PlanNodeService {

    @Autowired
    private PlanNodeMapper nodeMapper;

    @Override
    public int deleteByPrimaryKey(PlanNode record) {
        return nodeMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int insert(PlanNode record) {
        return nodeMapper.insert(record);
    }

    @Override
    public int insertSelective(PlanNode record) {
        return nodeMapper.insertSelective(record);
    }

    @Override
    public PlanNode selectByPrimaryKey(String habitId) {
        return nodeMapper.selectByPrimaryKey(habitId);
    }

    @Override
    public int updateByPrimaryKeySelective(PlanNode record) {
        return nodeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PlanNode record) {
        return nodeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PlanNode> select(Map<String, Object> params) {
        return nodeMapper.select(params);
    }
}
