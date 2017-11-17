/**
 * File：PageHelper.java
 * Author：jin
 * Date：2017年11月17日 下午12:53:49
 */
package org.jinlibrary.mybatis.plugin;

/**
 * <p>
 * Description: PageHelper
 * </p>
 *
 * @author jinshilei
 *         2017年11月17日
 * @version 1.0
 *
 */
public class PageHelper {

  public static final ThreadLocal<Page> PAGEINFO = new ThreadLocal<Page>();

  public static void setPage(Page page) {
    PAGEINFO.set(page);
  }

  public static Page getPage() {
    return PAGEINFO.get();
  }

  public static void removePage() {
    PAGEINFO.remove();
  }
}
