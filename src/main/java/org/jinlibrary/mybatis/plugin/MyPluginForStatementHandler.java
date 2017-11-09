/**
 * File：MyPluginForStatementHandler.java
 * Package：org.jinlibrary.mybatis.plugin
 * Author：jin
 * Date：2017年5月4日 下午4:26:33
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package org.jinlibrary.mybatis.plugin;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * <p>
 * Description: MyPluginForStatementHandler
 * </p>
 *
 * @author jinshilei
 *         2017年5月4日
 * @version 1.0
 *
 */
@Intercepts(value = {@Signature(type = StatementHandler.class, method = "prepare", args = {
    Connection.class, Integer.class})})
public class MyPluginForStatementHandler implements Interceptor {

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    return invocation.proceed();
  }

  @Override
  public Object plugin(Object target) {
    if (target instanceof StatementHandler) {
      return Plugin.wrap(target, this);
    }
    return target;
  }

  @Override
  public void setProperties(Properties paramProperties) {

  }

}
