/**
 * File：UserInfoDao.java
 * Package：org.jinlibrary.mybatis.daomapper
 * Author：jin
 * Date：2017年4月24日 下午5:53:36
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package org.jinlibrary.mybatis.daointerface;

import java.util.List;

import org.jinlibrary.mybatis.po.UserInfo;

/**
 * <p>
 * Description: UserInfoDao
 * </p>
 *
 * @author jinshilei
 *         2017年4月24日
 * @version 1.0
 *
 */
public interface UserInfoDao {

  List<UserInfo> findByUserId(Integer id) throws Exception;

  List<UserInfo> findAll() throws Exception;
}
