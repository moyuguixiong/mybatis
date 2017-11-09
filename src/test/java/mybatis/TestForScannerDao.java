/**
 * File：TestForScannerDao.java
 * Package：mybatis
 * Author：jin
 * Date：2017年5月10日 上午11:04:39
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package mybatis;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.jinlibrary.mybatis.daointerface.UserInfoDao;
import org.jinlibrary.mybatis.po.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Description: TestForScannerDao
 * </p>
 *
 * @author jinshilei
 *         2017年5月10日
 * @version 1.0
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-root.xml")
public class TestForScannerDao {

  @Autowired
  @Qualifier("userInfoDao")
  private UserInfoDao userInfoDao;

  @Test
  public void test() throws Exception {

    MetaObject metaUserInfoDao = SystemMetaObject.forObject(userInfoDao);
    if (metaUserInfoDao.hasGetter("h")) {
      Object proxy = metaUserInfoDao.getValue("h");
      System.out.println("代理的类型：" + proxy.getClass().getName());
    }
    UserInfo userInfo = userInfoDao.findByUserId(1);
    if (userInfo != null) {
      System.out.println(userInfo.getUserName());
    }
  }
}
