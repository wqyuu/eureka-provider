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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * Created by wqy on 2019/01/03
 */
@Controller
@RequestMapping("/user")
@Api(value = "eureka-provider", description = "学生查询接口")
public class UserConteroller {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserConteroller.class);

    @Autowired
    protected PlanUserService planUserService;

    /**
     * 新增用户
     *
     * @param modelMap
     * @return
     */
    @ResponseBody
    @GetMapping("/add")
    public String list(
            @ApiParam(value = "昵称") @RequestParam(value = "userName",required = false) String userName,
            @ApiParam(value = "账号") @RequestParam(value = "loginId",required = false) String loginId,
            @ApiParam(value = "密码") @RequestParam(value = "pwd",required = false) String pwd,
            @ApiParam(value = "个性签名") @RequestParam(value = "signature",required = false) String signature,
            PlanUser planUser,
            ModelMap modelMap) {
        String json = null;
        try {

            //PlanUser planUser=new PlanUser();
            planUser.setUserId(UUID.randomUUID().toString());
            //todo
            //planUser.se
            int rs=planUserService.addUser(planUser);
            if(rs>0){
                modelMap.put("ren_code", "0");
                modelMap.put("ren_msg", "添加成功");
                modelMap.put("username:", planUser.getUserName());
                json = JSON.toJSONString(modelMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("ren_code", "0");
            modelMap.put("ren_msg", "添加失败===>" + e);
            LOGGER.error("添加失败===>" + e);
            json = JSON.toJSONString(modelMap);
        }
        return json;
    }
}
