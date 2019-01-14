package cn.wqy.eureka.provider.controller;

import cn.wqy.eureka.provider.entity.PlanRemind;
import cn.wqy.eureka.provider.quartzEvent.QuartEventDemo;
import cn.wqy.eureka.provider.service.PlanRemindService;
import cn.wqy.eureka.provider.service.QuartzService;
import cn.wqy.eureka.provider.util.DateUtiler;
import cn.wqy.eureka.provider.util.Stringer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/remind")
@Api(value = "eureka-provider-remind", description = "计划crud接口")
public class RemindController {

    @Autowired
    private PlanRemindService RemindService;
    @Autowired
    private QuartzService quartzService;

    //@Autowired
    //private PushMessageService pushMessageService;


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
            ) throws ParseException, SchedulerException {

        Map<String, Object> result = new HashMap<String, Object>();

        PlanRemind Remind=new PlanRemind();

        //创建event_time字段
        String eventTime = remindTime.replace("T"," ")+":00";
        System.out.println("查看时间格式："+eventTime);
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Date endTime = sdf.parse(eventTime);

        Remind.setRemindId(UUID.randomUUID().toString());
        if(!Stringer.isNullOrEmpty(habitId)){
            Remind.setHabitId(habitId);
        }
        if(!Stringer.isNullOrEmpty(nodeId)){
            Remind.setNodeId(nodeId);
        }
        if(!Stringer.isNullOrEmpty(remindTime)){


            Remind.setRemindTime(endTime);//DateUtiler.format(remindTime)
        }
        if(!Stringer.isNullOrEmpty(remindNum)){
            Remind.setRemindNum(remindNum);
        }
        //设置时间成功
        result=quartzService.eventSetSuccess(QuartEventDemo.class, endTime, Remind);

        if(result.get("result").equals(false)){   //设置失败
            return 0;
        }

        //TODO 实时通知
        //pushMessageService.successSetEvent(noticeDTO);
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
