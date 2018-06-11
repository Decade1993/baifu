package com.baifu.erp.support;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import lombok.Getter;

import java.io.Serializable;

/**
 * 二次封装 com.google.common.collect.Range<br>
 * 搞出这个货来是为了在 mybatis mapper 中使用的，因为原本的类型中没有符合规范的 getter
 * @author ChenZenghui
 */
@SuppressWarnings("checkstyle:all")
public class DataRange<T extends Comparable> implements Serializable {
  private static final long serialVersionUID = 731424222868814961L;

  @Getter
  private final Range<T> range;

  private DataRange(Range<T> range) {
    this.range = range;
  }

  public static <T extends Comparable> DataRange<T> openClosed(T lower, T upper) {
    return new DataRange<>(Range.openClosed(lower, upper));
  }

  public static <T extends Comparable> DataRange<T> open(T lower, T upper) {
    return new DataRange<>(Range.open(lower, upper));
  }

  public static <T extends Comparable> DataRange<T> closed(T lower, T upper) {
    return new DataRange<>(Range.closed(lower, upper));
  }

  public static <T extends Comparable> DataRange<T> closedOpen(T lower, T upper) {
    return new DataRange<>(Range.closedOpen(lower, upper));
  }

  public static <T extends Comparable> DataRange<T> range(T lower, BoundType lowerType, T upper, BoundType upperType) {
    return new DataRange<>(Range.range(lower, lowerType, upper, upperType));
  }

  public static <T extends Comparable> DataRange<T> lessThan(T endpoint) {
    return new DataRange<>(Range.lessThan(endpoint));
  }

  public static <T extends Comparable> DataRange<T> atMost(T endpoint) {
    return new DataRange<>(Range.atMost(endpoint));
  }

  public static <T extends Comparable> DataRange<T> greaterThan(T endpoint) {
    return new DataRange<>(Range.greaterThan(endpoint));
  }

  public static <T extends Comparable> DataRange<T> atLeast(T endpoint) {
    return new DataRange<>(Range.atLeast(endpoint));
  }

  public boolean hasLowerBound() {
    return range.hasLowerBound();
  }

  public boolean hasUpperBound() {
    return range.hasUpperBound();
  }

  public T getLowerEndpoint() {
    return range.lowerEndpoint();
  }

  public T getUpperEndpoint() {
    return range.upperEndpoint();
  }

  public String getLowerBoundType() {
    return range.lowerBoundType().name();
  }

  public String getUpperBoundType() {
    return range.upperBoundType().name();
  }
}
