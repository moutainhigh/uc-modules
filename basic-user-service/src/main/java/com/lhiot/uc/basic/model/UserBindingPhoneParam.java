package com.lhiot.uc.basic.model;

import com.lhiot.dc.dictionary.HasEntries;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhangfeng created in 2018/9/7 17:12
 **/
@Data
@ApiModel
public class UserBindingPhoneParam {
    @ApiModelProperty(notes = "手机号", dataType = "String")
    private String phone;
    @HasEntries(from = "applications")
    @ApiModelProperty(notes = "应用类型", dataType = "Apply")
    private String applicationType;
}
