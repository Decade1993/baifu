package com.baifu.erp.entity;

import com.baifu.erp.support.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author generator
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Project extends BaseEntity {
  private static final long serialVersionUID = 1L;



  /**
   * 工程编号
   */
  @ApiModelProperty(value = "工程编号")
  private Integer number;

  /**
   * 接单日期
   */
  @ApiModelProperty(value = "接单日期")
  private LocalDate orderDate;

  /**
   * 年份
   */
  @ApiModelProperty(value = "年份")
  private Integer year;

  /**
   * 月份
   */
  @ApiModelProperty(value = "月份")
  private Integer month;

  /**
   * 省份
   */
  @ApiModelProperty(value = "省份")
  private String province;

  /**
   * 城市
   */
  @ApiModelProperty(value = "城市")
  private String city;

  /**
   * 区/县
   */
  @ApiModelProperty(value = "区/县")
  private String region;

  /**
   * 乡/镇
   */
  @ApiModelProperty(value = "乡/镇")
  private String town;

  /**
   * 门牌号码
   */
  @ApiModelProperty(value = "门牌号码")
  private String houseNumber;

  /**
   * 商场名称
   */
  @ApiModelProperty(value = "商场名称")
  private String storeName;

  /**
   * 品牌名称
   */
  @ApiModelProperty(value = "品牌名称")
  private String brand;

  /**
   * 工程属性
   */
  @ApiModelProperty(value = "工程属性")
  private String projectAttribute;

  /**
   * 店铺属性
   */
  @ApiModelProperty(value = "店铺属性")
  private String storeAttribute;

  /**
   * 客户名称
   */
  @ApiModelProperty(value = "客户名称")
  private String clientName;

  /**
   * 客户属性
   */
  @ApiModelProperty(value = "客户属性")
  private String clientAttribute;

  /**
   * 客户电话
   */
  @ApiModelProperty(value = "客户电话")
  private String clientPhone;

  /**
   * 客户qq
   */
  @ApiModelProperty(value = "客户qq")
  private String clientQq;

  /**
   * 客户微信
   */
  @ApiModelProperty(value = "客户微信")
  private String clientWechat;

  /**
   * 甲方经理
   */
  @ApiModelProperty(value = "甲方经理")
  private String firstPartyManager;

  /**
   * 甲方经理电话
   */
  @ApiModelProperty(value = "甲方经理电话")
  private String firstPartyManagerPhone;

  /**
   * 商场经理
   */
  @ApiModelProperty(value = "商场经理")
  private String storeManager;

  /**
   * 商场经理电话
   */
  @ApiModelProperty(value = "商场经理电话")
  private String storeManagerPhone;

  /**
   * 定金
   */
  @ApiModelProperty(value = "定金")
  private BigDecimal deposit;

  /**
   * 业务负责
   */
  @ApiModelProperty(value = "业务负责")
  private String responsePerson;

  /**
   * 业务负责人电话
   */
  @ApiModelProperty(value = "业务负责人电话")
  private String responsePersonPhone;

  /**
   * 测量日期
   */
  @ApiModelProperty(value = "测量日期")
  private LocalDate measureDate;

  /**
   * 测量人员
   */
  @ApiModelProperty(value = "测量人员")
  private String measureStaff;

  /**
   * 测量人员电话
   */
  @ApiModelProperty(value = "测量人员电话")
  private String measureStaffPhone;

  /**
   * 设计部门
   */
  @ApiModelProperty(value = "设计部门")
  private String designDepartment;

  /**
   * 设计部门主管
   */
  @ApiModelProperty(value = "设计部门主管")
  private String designDepartmentManager;

  /**
   * 设计部门主管电话
   */
  @ApiModelProperty(value = "设计部门主管电话")
  private String designDepartmentManagerPhone;

  /**
   * 预开日期
   */
  @ApiModelProperty(value = "预开日期")
  private LocalDate advanceOpenDate;

  /**
   * 营业面积
   */
  @ApiModelProperty(value = "营业面积")
  private BigDecimal businessArea;

  /**
   * 柜台总长
   */
  @ApiModelProperty(value = "柜台总长")
  private BigDecimal cupboardLength;

  /**
   * 背柜面积
   */
  @ApiModelProperty(value = "背柜面积")
  private BigDecimal backCupboardArea;

  /**
   * 金属工艺
   */
  @ApiModelProperty(value = "金属工艺")
  private String metalCrafts;

  /**
   * 基装责任
   */
  @ApiModelProperty(value = "基装责任")
  private String basicEquipResponse;

  /**
   * 派单级别
   */
  @ApiModelProperty(value = "派单级别")
  private String orderUrgent;

  /**
   * 场地准确性
   */
  @ApiModelProperty(value = "场地准确性")
  private String siteAccuracy;
}
