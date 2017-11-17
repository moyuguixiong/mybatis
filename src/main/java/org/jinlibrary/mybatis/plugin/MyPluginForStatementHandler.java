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
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

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
    // 获取StatementHandler，默认是RoutingStatementHandler
    StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
    // 获取statementHandler包装类
    MetaObject MetaObjectHandler = SystemMetaObject.forObject(statementHandler);

    // 分离代理对象链
    while (MetaObjectHandler.hasGetter("h")) {
      Object obj = MetaObjectHandler.getValue("h");
      MetaObjectHandler = SystemMetaObject.forObject(obj);
    }

    while (MetaObjectHandler.hasGetter("target")) {
      Object obj = MetaObjectHandler.getValue("target");
      MetaObjectHandler = SystemMetaObject.forObject(obj);
    }

    // 获取连接对象
    // Connection connection = (Connection) invocation.getArgs()[0];

    // object.getValue("delegate"); 获取StatementHandler的实现类

    // 获取查询接口映射的相关信息
    // MappedStatement mappedStatement = (MappedStatement) MetaObjectHandler
    // .getValue("delegate.mappedStatement");
    // String mapId = mappedStatement.getId();

    // statementHandler.getBoundSql().getParameterObject();

    // 拦截以.ByPage结尾的请求，分页功能的统一实现
    Page page = PageHelper.getPage();
    if (page != null) {
      // 获取进行数据库操作时管理参数的handler
      // ParameterHandler parameterHandler = (ParameterHandler)
      // MetaObjectHandler.getValue("delegate.parameterHandler");
      // 获取请求时的参数
      // Map<String, Object> paraObject = (Map<String, Object>)
      // parameterHandler.getParameterObject();
      // 也可以这样获取
      // paraObject = (Map<String, Object>) statementHandler.getBoundSql().getParameterObject();

      String sql = (String) MetaObjectHandler.getValue("delegate.boundSql.sql");
      // 也可以通过statementHandler直接获取
      // sql = statementHandler.getBoundSql().getSql();

      // 构建分页功能的sql语句
      String limitSql;
      sql = sql.trim();
      limitSql = sql + " limit " + (page.getCurrPage() - 1) * page.getPageSize() + ","
          + page.getPageSize();
      PageHelper.removePage();

      // 将构建完成的分页sql语句赋值个体'delegate.boundSql.sql'，偷天换日
      MetaObjectHandler.setValue("delegate.boundSql.sql", limitSql);
    }
    // 调用原对象的方法，进入责任链的下一级
    return invocation.proceed();
  }

  // 获取代理对象
  @Override
  public Object plugin(Object o) {
    // 生成object对象的动态代理对象
    return Plugin.wrap(o, this);
  }

  // 设置代理对象的参数
  @Override
  public void setProperties(Properties properties) {
    // 如果项目中分页的pageSize是统一的，也可以在这里统一配置和获取，这样就不用每次请求都传递pageSize参数了。参数是在配置拦截器时配置的。
    // String limit1 = properties.getProperty("limit", "10");
    // this.pageSize = Integer.valueOf(limit1);
    // this.dbType = properties.getProperty("dbType", "mysql");
  }
}
