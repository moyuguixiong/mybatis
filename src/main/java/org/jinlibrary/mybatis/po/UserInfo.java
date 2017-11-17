/**
 * File：UserInfo.java
 * Package：org.jinlibrary.mybatis.po
 * Author：jin
 * Date：2017年4月24日 下午5:16:35
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package org.jinlibrary.mybatis.po;

import java.util.Date;

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

  private Integer id;

  private String name;

  private Integer age;

  private Date birthday;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

}
