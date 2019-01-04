package cn.wqy.eureka.provider.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
public class PlanHabit {
    private String habitId;

    private String createdUser;

    private Date createdTime;

    private Date updatedTime;

    private String habitDesc;

    private String habitImportance;

    private String habitTerm;

    private String habitName;

    private String habitStaus;
}