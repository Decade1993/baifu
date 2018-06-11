package com.baifu.erp.support;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * entity 的条件查询对象的父类
 * @author ChenZenghui
 */
@Data
public class EntityCriteria implements Serializable {
  private static final long serialVersionUID = 2728497923074882088L;
  private static final int DEFAULT_PAGE_SIZE = 20;

  private Date updatedAt;
  private Date createdAt;
  private DataRange<Date> updatedAtRange;
  private DataRange<Date> createdAtRange;

  /**
   * order by 字句，将直接拼接到 sql 后面<br>
   * 赋值样例： user_name, login_time desc, update_at asc <br>
   * 注意：字段名称使用库表的列（column）的名称
   */
  private String orderBy;

  /**
   * offset 是分页查询用的
   */
  @Setter(AccessLevel.NONE)
  @Getter
  private Integer offset;
  /**
   * limit 是分页查询用的
   */
  @Setter(AccessLevel.NONE)
  @Getter
  private Integer limit;

  /**
   * offset 和 limit 是分页查询用的
   * @param pageNo 第几页
   * @param pageSize 每页大小
   */
  void buildOffsetLimit(Integer pageNo, Integer pageSize) {
    pageNo = pageNo == null ? 1 : pageNo;
    pageSize = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
    limit = pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    int newOffset = (pageNo - 1) * pageSize;
    this.offset = newOffset > 0 ? newOffset : 0;
  }

}
