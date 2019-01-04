package cn.wqy.eureka.provider.controller;

import cn.wqy.eureka.provider.entity.PlanUser;
import cn.wqy.eureka.provider.service.PlanUserService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by wqy on 2019/01/03
 */
@RestController
@RequestMapping("/hello")
@Api(value = "eureka-provider-hello", description = "查询接口")
public class HelloConteroller {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloConteroller.class);



    @ResponseBody
    @GetMapping("/wind")
    public String list() {

        return "wind ~~~ ";
    }
}
