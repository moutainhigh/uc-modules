package com.lhiot.uc.warehouse.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lhiot.uc.warehouse.model.IfSplitType;
import com.lhiot.uc.warehouse.model.OperationType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:仓库商品实体类
 *
 * @author yijun
 * @date 2018/09/07
 */
@Data
@ToString(callSuper = true)
@ApiModel
@NoArgsConstructor
public class WarehouseProduct {

    /**
     * 仓库商品ID
     */
    @JsonProperty("id")
    @ApiModelProperty(value = "仓库商品ID", dataType = "Long")
    private Long id;

    /**
     * 仓库id
     */
    @JsonProperty("warehouseId")
    @ApiModelProperty(value = "仓库id", dataType = "Long")
    private Long warehouseId;

    /**
     * 商品id
     */
    @JsonProperty("productId")
    @ApiModelProperty(value = "商品id", dataType = "Long")
    private Long productId;

    /**
     * 商品数量/重量
     */
    @JsonProperty("productCount")
    @ApiModelProperty(value = "商品数量/重量", dataType = "BigDecimal")
    private BigDecimal productCount;

    /**
     * 是否允许拆分
     */
    @JsonProperty("ifSplit")
    @ApiModelProperty(value = "是否允许拆分", dataType = "IfSplitType")
    private IfSplitType ifSplit;

    /**
     * 商品价格
     */
    @JsonProperty("price")
    @ApiModelProperty(value = "商品价值（整个productCount数量商品的价值）", dataType = "Integer")
    private Integer price;

    /**
     * 基础商品条码
     */
    @JsonProperty("barcode")
    @ApiModelProperty(value = "基础商品条码", dataType = "String")
    private String barcode;

    /**
     * 商品名称
     */
    @JsonProperty("productName")
    @ApiModelProperty(value = "商品名称", dataType = "String")
    private String productName;

    /**
     * 商品主图
     */
    @JsonProperty("image")
    @ApiModelProperty(value = "商品主图", dataType = "String")
    private String image;

    /**
     * 商品小图标
     */
    @JsonProperty("smallImage")
    @ApiModelProperty(value = "商品小图标", dataType = "String")
    private String smallImage;

    /**
     * 大图标
     */
    @JsonProperty("largeImage")
    @ApiModelProperty(value = "大图标", dataType = "String")
    private String largeImage;

    /**
     * 购买时间
     */
    @JsonProperty("buyAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "购买时间", dataType = "Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date buyAt;

    @ApiModelProperty(value = "基础单位", dataType = "String")
    private String baseUnit;

    /**
     * 扣减时操作类型
     */
    private OperationType operationType;
}
