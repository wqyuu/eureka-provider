package cn.wqy.eureka.provider.service;

import cn.wqy.eureka.provider.entity.PlanRemind;
import org.quartz.Job;
import org.quartz.SchedulerException;

import java.util.Date;
import java.util.Map;

/**
 * Created by yhn on 2017/9/29.
 */
public interface QuartzService {
    Map<String,Object> eventSetSuccess(Class<? extends Job> klass, Date date, PlanRemind noticeDTO) throws SchedulerException;
}
