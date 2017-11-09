/**
 * File：UserInfo.java
 * Package：org.jinlibrary.mybatis.po
 * Author：jin
 * Date：2017年4月24日 下午5:16:35
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package org.jinlibrary.mybatis.po;

import org.apache.ibatis.type.Alias;

/**
 * <p>
 * Description: UserInfo
 * </p>
 *
 * @author jinshilei
 *         2017年4月24日
 * @version 1.0
 *
 */
@Alias("userInfo")
public class UserInfo {

  private Integer userId;

  private String userName;

  private String password;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
