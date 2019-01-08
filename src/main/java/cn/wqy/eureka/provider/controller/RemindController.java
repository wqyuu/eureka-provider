package cn.wqy.eureka.provider.controller;

import cn.wqy.eureka.provider.entity.PlanRemind;
import cn.wqy.eureka.provider.service.PlanRemindService;
import cn.wqy.eureka.provider.util.DateUtiler;
import cn.wqy.eureka.provider.util.Stringer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/remind")
@Api(value = "eureka-provider-remind", description = "计划crud接口")
public class RemindController {

    @Autowired
    private PlanRemindService RemindService;

    /**
     * 新增提醒
     * @param
     * @return
     */
    @PostMapping(value = "/add")
    public int addRemind(
            @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId,
            @ApiParam(value = "节点ID") @RequestParam(value = "nodeId",required = false) String nodeId,
            @ApiParam(value = "提醒时间") @RequestParam(value = "remindTime",required = false) String remindTime,
            @ApiParam(value = "提醒次数") @RequestParam(value = "remindNum",required = false) Integer remindNum
            ){

        PlanRemind Remind=new PlanRemind();
        Remind.setRemindId(UUID.randomUUID().toString());
        if(!Stringer.isNullOrEmpty(habitId)){
            Remind.setHabitId(habitId);
        }
        if(!Stringer.isNullOrEmpty(nodeId)){
            Remind.setNodeId(nodeId);
        }
        if(!Stringer.isNullOrEmpty(remindTime)){
            Remind.setRemindTime(DateUtiler.format(remindTime));
        }
        if(!Stringer.isNullOrEmpty(remindNum)){
            Remind.setRemindNum(remindNum);
        }
        return RemindService.insertSelective(Remind);
    }

    @PostMapping(value = "/update")
    public int updateRemind(
            @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId,
            @ApiParam(value = "节点ID") @RequestParam(value = "nodeId",required = false) String nodeId,
            @ApiParam(value = "提醒ID") @RequestParam(value = "remindId",required = false) String remindId,
            @ApiParam(value = "提醒时间") @RequestParam(value = "remindTime",required = false) String remindTime,
            @ApiParam(value = "提醒次数") @RequestParam(value = "remindNum",required = false) Integer remindNum){

        PlanRemind Remind=new PlanRemind();
        Remind.setRemindId(remindId);
        if(!Stringer.isNullOrEmpty(habitId)){
            Remind.setHabitId(habitId);
        }
        if(!Stringer.isNullOrEmpty(nodeId)){
            Remind.setNodeId(nodeId);
        }
        if(!Stringer.isNullOrEmpty(remindTime)){
            Remind.setRemindTime(DateUtiler.format(remindTime));
        }
        if(!Stringer.isNullOrEmpty(remindNum)){
            Remind.setRemindNum(remindNum);
        }
        return RemindService.updateByPrimaryKeySelective(Remind);
    }

    @GetMapping(value = "/delete")
    public int deleteRemind(
            @ApiParam(value = "提醒ID") @RequestParam(value = "remindId",required = false) String remindId){
        PlanRemind Remind=new PlanRemind();
        Remind.setRemindId(remindId);
        return RemindService.deleteByPrimaryKey(Remind);
    }

    @GetMapping(value = "/query")
    public List<PlanRemind> queryRemind(
            @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId,
            @ApiParam(value = "节点ID") @RequestParam(value = "nodeId",required = false) String nodeId,
            Map<String,Object> params){

        if(!Stringer.isNullOrEmpty(habitId)){
            params.put("habitId",habitId);
        }
        if(!Stringer.isNullOrEmpty(nodeId)){
            params.put("nodeId",nodeId);
        }

        return RemindService.select(params);
    }
}
