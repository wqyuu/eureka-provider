package cn.wqy.eureka.provider.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class PlanRemind {
    private String remindId;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private String remindStatus;

    private Date remindTime;

    private Integer remindNum;

    private String nodeId;

    private String habitId;

    private String remindMessage;


}