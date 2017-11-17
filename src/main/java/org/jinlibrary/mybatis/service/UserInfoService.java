/**
 * File：UserInfoService.java
 * Author：jin
 * Date：2017年11月17日 下午1:12:58
 */
package org.jinlibrary.mybatis.service;

import java.util.List;

import org.jinlibrary.mybatis.daointerface.UserInfoDao;
import org.jinlibrary.mybatis.plugin.Page;
import org.jinlibrary.mybatis.plugin.PageHelper;
import org.jinlibrary.mybatis.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Description: UserInfoService
 * </p>
 *
 * @author jinshilei
 *         2017年11月17日
 * @version 1.0
 *
 */
@Service
public class UserInfoService {

  @Autowired
  private UserInfoDao userInfoDao;

  public List<UserInfo> findByPage(int currPage, int pageSize) throws Exception {
    Page page = new Page();
    page.setCurrPage(currPage);
    page.setPageSize(pageSize);
    PageHelper.setPage(page);
    return userInfoDao.findAll();
  }
}
