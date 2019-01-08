package cn.wqy.eureka.provider.controller;

import cn.wqy.eureka.provider.entity.PlanHabit;
import cn.wqy.eureka.provider.service.PlanHabitService;
import cn.wqy.eureka.provider.util.Stringer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/habit")
@Api(value = "eureka-provider-habit", description = "计划crud接口")
public class HabitController {

    @Autowired
    private PlanHabitService habitService;

    /**
     * 新增计划
     * @param habitName
     * @return
     */
    @PostMapping(value = "/add")
    public int addHabit(
            @ApiParam(value = "计划名称") @RequestParam(value = "habitName",required = false) String habitName,
            @ApiParam(value = "描述") @RequestParam(value = "habitDesc",required = false) String habitDesc,
            @ApiParam(value = "重要程度") @RequestParam(value = "habitImportance",required = false) String habitImportance,
            @ApiParam(value = "期限") @RequestParam(value = "habitTerm",required = false) String habitTerm
            ){

        PlanHabit habit=new PlanHabit();
        habit.setHabitId(UUID.randomUUID().toString());
        if(!Stringer.isNullOrEmpty(habitName)){
            habit.setHabitName(habitName);
        }
        if(!Stringer.isNullOrEmpty(habitDesc)){
            habit.setHabitDesc(habitDesc);
        }
        if(!Stringer.isNullOrEmpty(habitImportance)){
            habit.setHabitImportance(habitImportance);
        }
        if(!Stringer.isNullOrEmpty(habitTerm)){
            habit.setHabitTerm(habitTerm);
        }
        return habitService.insertSelective(habit);
    }

    @PostMapping(value = "/update")
    public int updateHabit(
            @ApiParam(value = "计划名称") @RequestParam(value = "habitName",required = false) String habitName,
            @ApiParam(value = "描述") @RequestParam(value = "habitDesc",required = false) String habitDesc,
            @ApiParam(value = "重要程度") @RequestParam(value = "habitImportance",required = false) String habitImportance,
            @ApiParam(value = "期限") @RequestParam(value = "habitTerm",required = false) String habitTerm,
            @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId){

        PlanHabit habit=new PlanHabit();
        habit.setHabitId(habitId);
        if(!Stringer.isNullOrEmpty(habitName)){
            habit.setHabitName(habitName);
        }
        if(!Stringer.isNullOrEmpty(habitDesc)){
            habit.setHabitDesc(habitDesc);
        }
        if(!Stringer.isNullOrEmpty(habitImportance)){
            habit.setHabitImportance(habitImportance);
        }
        if(!Stringer.isNullOrEmpty(habitTerm)){
            habit.setHabitTerm(habitTerm);
        }
        return habitService.updateByPrimaryKeySelective(habit);
    }

    @GetMapping(value = "/delete")
    public int deleteHabit(
            @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId){
        PlanHabit habit=new PlanHabit();
        habit.setHabitId(habitId);
        return habitService.deleteByPrimaryKey(habit);
    }

    @GetMapping(value = "/query")
    public List<PlanHabit> queryHabit(
            @ApiParam(value = "计划名称") @RequestParam(value = "habitName",required = false) String habitName,
            @ApiParam(value = "描述") @RequestParam(value = "habitDesc",required = false) String habitDesc,
            @ApiParam(value = "重要程度") @RequestParam(value = "habitImportance",required = false) String habitImportance,
            @ApiParam(value = "期限") @RequestParam(value = "habitTerm",required = false) String habitTerm,
            Map<String,Object> params){

        if(!Stringer.isNullOrEmpty(habitName)){
            params.put("habitName",habitName);
        }
        if(!Stringer.isNullOrEmpty(habitDesc)){
            params.put("habitDesc",habitDesc);
        }
        if(!Stringer.isNullOrEmpty(habitImportance)){
            params.put("habitImportance",habitImportance);
        }
        if(!Stringer.isNullOrEmpty(habitTerm)){
            params.put("habitTerm",habitTerm);
        }

        return habitService.select(params);
    }
}
