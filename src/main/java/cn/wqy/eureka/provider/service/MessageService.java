package cn.wqy.eureka.provider.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 习惯 服务类
 * </p>
 * Created by wqy on 2019/01/08
 */
//@FeignClient(value = "eureka-consumer", fallback = MessageRemoteHystrix.class)
public interface MessageService {

    /**
     * 创建计划
     *
     * @return
     */
    @RequestMapping(value = "/habit/add", method = RequestMethod.GET)
    int addHabit(@RequestParam(value = "habitName", required = false) String habitName,
                 @RequestParam(value = "habitDesc", required = false) String habitDesc,
                 @RequestParam(value = "habitImportance", required = false) String habitImportance,
                 @RequestParam(value = "habitTerm", required = false) String habitTerm);

    @RequestMapping(value = "/habit/update", method = RequestMethod.POST)
    int updateHabit(
            @RequestParam(value = "habitName", required = false) String habitName,
            @RequestParam(value = "habitDesc", required = false) String habitDesc,
            @RequestParam(value = "habitImportance", required = false) String habitImportance,
            @RequestParam(value = "habitTerm", required = false) String habitTerm,
            @RequestParam(value = "habitId", required = false) String habitId);


    @RequestMapping(value = "/habit/delete",method = RequestMethod.GET)
    int deleteHabit(@RequestParam(value = "habitId", required = false) String habitId);

    @RequestMapping(value = "/habit/query",method = RequestMethod.GET)
    List queryHabit(
            @RequestParam(value = "habitName", required = false) String habitName,
            @RequestParam(value = "habitDesc", required = false) String habitDesc,
            @RequestParam(value = "habitImportance", required = false) String habitImportance,
            @RequestParam(value = "habitTerm", required = false) String habitTerm);


    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);

}
