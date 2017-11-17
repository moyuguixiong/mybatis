/**
 * File：Page.java
 * Author：jin
 * Date：2017年11月17日 下午1:08:58
 */
package org.jinlibrary.mybatis.plugin;

/**
 * <p>
 * Description: Page
 * </p>
 *
 * @author jinshilei
 *         2017年11月17日
 * @version 1.0
 *
 */
public class Page {

  // 每页显示的条目数
  private int pageSize;

  // 当前现实的页数
  private int currPage;

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getCurrPage() {
    return currPage;
  }

  public void setCurrPage(int currPage) {
    this.currPage = currPage;
  }
}
