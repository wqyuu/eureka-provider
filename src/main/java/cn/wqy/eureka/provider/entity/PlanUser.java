package cn.wqy.eureka.provider.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
public class PlanUser {
    private String userId;

    private String userName;

    private Date createdTime;

    private Date updatedTime;

    private String loginId;

    private String pwd;

    private String wallet;

    private String signature;

    private Integer level;

    private String openId;

    private String wxId;


}