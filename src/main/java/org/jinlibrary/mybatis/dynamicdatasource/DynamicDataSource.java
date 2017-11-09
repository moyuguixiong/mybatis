/**
 * File：MyRoutingDataSource.java
 * Package：org.jinlibrary.mybatis.routingdatasource
 * Author：jin
 * Date：2017年5月8日 下午3:04:06
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package org.jinlibrary.mybatis.dynamicdatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p>
 * Description: MyRoutingDataSource
 * </p>
 *
 * @author jinshilei
 *         2017年5月8日
 * @version 1.0
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

  @Override
  protected Object determineCurrentLookupKey() {
    return DynamicDataSourceHolder.getDataSource();
  }
}
