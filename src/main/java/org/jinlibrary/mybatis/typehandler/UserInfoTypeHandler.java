/**
 * File：UserInfoTypeHandler.java
 * Package：org.jinlibrary.mybatis.typehandler
 * Author：jin
 * Date：2017年4月24日 下午6:21:11
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package org.jinlibrary.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.jinlibrary.mybatis.po.UserInfo;

/**
 * <p>
 * Description: UserInfoTypeHandler
 * </p>
 *
 * @author jinshilei
 *         2017年4月24日
 * @version 1.0
 *
 */
public class UserInfoTypeHandler extends BaseTypeHandler<UserInfo> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, UserInfo paraUserInfo,
                                  JdbcType jdbcType) throws SQLException {
    ps.setString(i, paraUserInfo.getName());
  }

  @Override
  public UserInfo getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return null;
  }

  @Override
  public UserInfo getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return null;
  }

  @Override
  public UserInfo getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return null;
  }

}
