package cn.wqy.eureka.provider.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class PlanNode {

    private String nodeId;

    private String createdUser;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private String habitId;

    private String nodeName;

    private String parentId;

    private String nodeStatus;

}