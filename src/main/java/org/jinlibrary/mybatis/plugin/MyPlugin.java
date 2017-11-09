/**
 * File：MyPlugin.java
 * Package：org.jinlibrary.mybatis.plugin
 * Author：jin
 * Date：2017年4月26日 上午9:24:39
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
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * <p>
 * Description: MyPlugin
 * </p>
 *
 * @author jinshilei
 *         2017年4月26日
 * @version 1.0
 *
 */
@Intercepts(value = {@Signature(type = StatementHandler.class, method = "prepare", args = {
    Connection.class, Integer.class})})
public class MyPlugin implements Interceptor {

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    System.out.println("被拦截了");
    if (invocation != null && invocation.getTarget() instanceof StatementHandler) {
      StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
      MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
      while (metaStatementHandler.hasGetter("h")) {
        Object object = metaStatementHandler.getValue("h");
        System.out.println("statementHandler类型：" + statementHandler.getClass().getName());
        System.out.println("h类型：" + object.getClass().getName());
        metaStatementHandler = SystemMetaObject.forObject(object);
      }
      if (metaStatementHandler.hasGetter("target")) {
        System.out.println("有target");
        Object object = metaStatementHandler.getValue("target");
        metaStatementHandler = SystemMetaObject.forObject(object);
      }
      StatementHandler actualStatementHandler = (StatementHandler) metaStatementHandler
          .getValue("delegate");
      System.out.println("actualStatementHandler:" + actualStatementHandler.getClass().getName());
      Connection connection = (Connection) invocation.getArgs()[0];
      System.out.println("隔离级别:" + connection.getTransactionIsolation());
      System.out.println("是否自动提交:" + connection.getAutoCommit());
    }
    return invocation.proceed();
  }

  @Override
  public Object plugin(Object target) {
    // 当获取Executor、StatementHandler、ParameterHandler、ResultSetHandler四种对象时，会调用该方法生成代理对象。
    // 为了避免对不需要拦截的对象生成代理对象，在这里最好判断下target的类型，只对要拦截的对象生成代理对象。
    if (target != null && target instanceof StatementHandler) {
      Object proxyTarget = Plugin.wrap(target, this);
      System.out.println("拦截器：" + proxyTarget);
      return proxyTarget;
    }
    return target;
  }

  @Override
  public void setProperties(Properties properties) {

  }

}
