package com.lhiot.uc.basic.entity;

import lombok.Data;

import java.time.Instant;
import java.util.Date;

/**
 * @author zhangfeng created in 2018/9/12 12:05
 **/
@Data
public class BalanceLog {
    private Long id;
    private Long baseUserId;
    private Long money;
    private OperationStatus operation;
    private String applicationType;
    private String memo;
    private String sourceId;
    private Date createAt = Date.from(Instant.now());
}
