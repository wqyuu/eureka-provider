package cn.wqy.eureka.provider.service.impl;

import cn.wqy.eureka.provider.config.QuartzConfigration;
import cn.wqy.eureka.provider.entity.PlanRemind;
import cn.wqy.eureka.provider.service.QuartzService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wqy on 2019/1/10.
 */
@Service
public class QuartzServiceImpl implements QuartzService {
    @Autowired
    private QuartzConfigration schedulerFactoryConfig;
    @Override
    public Map<String, Object> eventSetSuccess(Class <? extends Job> klass, Date date,PlanRemind noticeDTO) throws SchedulerException {
        Map<String, Object> map = new HashMap<String, Object>();
        String group = UUID.randomUUID().toString();
        JobDetail jobDetail = JobBuilder
                .newJob(klass)
                .withIdentity("myJob", group)
                .build();
        //创建一个指定时间运行
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = new Date();
        long time = date.getTime()-startDate.getTime();
        if(time<0){   //设置时间不是当前时间之后
            map.put("result",false);
            map.put("msg","时间不可设置当前时间之前!");
            return map;
        }
        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity("myTrigger",group)
                .usingJobData("openid",noticeDTO.getRemindId())
                .usingJobData("createTime",format.format(noticeDTO.getCreatedTime()))
                .usingJobData("endTime",format.format(noticeDTO.getRemindTime()))
                .usingJobData("eventContent",noticeDTO.getRemindMessage())
                .usingJobData("remindMessage",noticeDTO.getRemindMessage())
                .usingJobData("habitId",noticeDTO.getHabitId())
                .startAt(date)
                .build();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerFactoryConfig.schedulerFactoryBean().getScheduler();
        }catch(IOException e){
            e.printStackTrace();
        }
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
        map.put("result",true);
        map.put("msg","任务调用成功");
        return map;
    }
}
