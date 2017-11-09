/**
 * File：DynamicDataSourceHolder.java
 * Package：org.jinlibrary.mybatis.dynamicdatasource
 * Author：jin
 * Date：2017年5月8日 下午4:57:41
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package org.jinlibrary.mybatis.dynamicdatasource;

/**
 * <p>
 * Description: DynamicDataSourceHolder
 * </p>
 *
 * @author jinshilei
 *         2017年5月8日
 * @version 1.0
 *
 */
public class DynamicDataSourceHolder {

  /**
   * 当前线程保存数据源
   */
  private static final ThreadLocal<String> CURRENT_DATA_SOURCE = new ThreadLocal<String>();

  /**
   *
   * getDataSource
   *
   * @return 返回字符串
   */
  public static String getDataSource() {
    return CURRENT_DATA_SOURCE.get();
  }

  /**
   *
   * SetDataSource
   *
   * @param dataSource
   *        数据源id
   */
  public static void SetDataSource(String dataSource) {
    CURRENT_DATA_SOURCE.set(dataSource);
  }

  /**
   *
   * clearDataSource
   */
  public static void clearDataSource() {
    CURRENT_DATA_SOURCE.remove();
  }
}
