package com.baifu.erp.support;

import lombok.Getter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 对分页查询的结果进行封装
 * @author ChenZenghui
 * @param <T> 被分页的对象的类型
 */
public class Paging<T> implements Serializable {
  private static final long serialVersionUID = -4247871861724587343L;

  @Getter
  private final Long total;
  @Getter
  private final List<T> data;

  public Paging() {
    this(0L, Collections.emptyList());
  }

  public Paging(Long total, List<T> data) {
    this.data = data;
    this.total = total;
  }

  public Boolean isEmpty() {
    return total == null || total <= 0 || data == null || data.isEmpty();
  }

  /**
   * 获得一个空的分页结果
   * @param <T> 被分页的对象的类型
   * @return Paging
   */
  public static <T> Paging<T> empty() {
    return new Paging<>();
  }

}
