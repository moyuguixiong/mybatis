/**
 * File：TestForScannerDao.java
 * Package：mybatis
 * Author：jin
 * Date：2017年5月10日 上午11:04:39
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package mybatis;

import java.util.List;

import org.jinlibrary.mybatis.daointerface.UserInfoDao;
import org.jinlibrary.mybatis.plugin.Page;
import org.jinlibrary.mybatis.plugin.PageHelper;
import org.jinlibrary.mybatis.po.UserInfo;
import org.jinlibrary.mybatis.service.UserInfoService;
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
  private UserInfoService userInfoService;

  @Autowired
  private UserInfoDao userInfoDao;

  @Test
  public void test() throws Exception {

    // MetaObject metaUserInfoDao = SystemMetaObject.forObject(userInfoDao);
    // if (metaUserInfoDao.hasGetter("h")) {
    // Object proxy = metaUserInfoDao.getValue("h");
    // System.out.println("代理的类型：" + proxy.getClass().getName());
    // }
    List<UserInfo> userInfos = userInfoService.findByPage(2, 2);
    if (userInfos != null && userInfos.size() > 0) {
      for (UserInfo userInfo : userInfos) {
        System.out.println(userInfo.getName());
      }
    }

    Page page = new Page();
    page.setCurrPage(1);
    page.setPageSize(2);
    PageHelper.setPage(page);
    List<UserInfo> findAll = userInfoDao.findAll();
    if (findAll != null) {
      for (UserInfo userInfo : findAll) {
        System.out.println(userInfo.getName());
      }
    }
  }
}
