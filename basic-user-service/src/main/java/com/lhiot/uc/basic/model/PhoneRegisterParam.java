package com.lhiot.uc.basic.model;

import com.lhiot.dc.dictionary.HasEntries;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@ApiModel
public class PhoneRegisterParam {
    @ApiModelProperty(notes = "电话号码", dataType = "String", required = true)
    @NotNull
    @Pattern(regexp = "1\\d{10}", message = "请输入正确的电话号码")
    private String phone;


    @ApiModelProperty(notes = "验证码", dataType = "String", required = false)
    @Pattern(regexp = "\\w{6}", message = "请输入正确的验证码")
    private String verifyCode;

    @ApiModelProperty(notes = "密码", dataType = "String", required = false)
    private String password;

    @HasEntries(from = "applications")
    @ApiModelProperty(notes = "应用类型", dataType = "String")
    private String applicationType;
}
