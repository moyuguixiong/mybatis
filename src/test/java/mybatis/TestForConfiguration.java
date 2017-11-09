/**
 * File：TestForConfiguration.java
 * Package：mybatis
 * Author：jin
 * Date：2017年3月31日 上午9:04:26
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jinlibrary.mybatis.po.UserInfo;
import org.junit.Test;

/**
 * <p>
 * Description: TestForConfiguration
 * </p>
 *
 * @author jinshilei
 *         2017年3月31日
 * @version 1.0
 *
 */
public class TestForConfiguration {

  @Test
  public void Test() {
    SimpleExecutor executor = new SimpleExecutor(null, null);
    System.out.println(executor.getClass());
    System.out.println(Executor.class);
    System.out.println(executor.getClass().equals(Executor.class));
    System.out.println(executor instanceof Executor);
    System.out.println("Integer最大值：" + Integer.MAX_VALUE);

    PropertyTokenizer tokenizer = new PropertyTokenizer("org.jinlibrary.mybatis.po.UserInfo.userId");
    System.out.println(tokenizer.getIndexedName());
    while (tokenizer.hasNext()) {
      tokenizer = tokenizer.next();
      System.out.println(tokenizer.getIndexedName());
    }
    // String last = tokenizer.getChildren();
    // System.out.println(tokenizer.getIndexedName());
    // System.out.println("last:" + last);
  }

  @Test
  public void testForSqlSession() throws IOException {

    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sessionFactory = builder.build(inputStream, "develope");
    System.out.println(sessionFactory.getClass().getName());
    SqlSession sqlSession = sessionFactory.openSession(true);

    System.out.println(sqlSession.getClass().getName());
    List<UserInfo> list = sqlSession.selectList(
        "org.jinlibrary.mybatis.daointerface.UserInfoDao.findByUserId", 1);
    if (list != null) {
      if (list.size() > 0) {
        UserInfo userInfo = list.get(0);
        System.out.println(userInfo.getUserId());
        System.out.println(userInfo.getUserName());
        System.out.println(userInfo.getPassword());
      }
    }
    System.out.println(UserInfo.class.getClassLoader());
    System.out.println(ClassLoader.getSystemClassLoader());
  }

  @Test
  public void testForJdbc() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection(
        "jdbc:mysql://124.251.50.124:3305/imgroupmanage_test", "imgmanage_test_admin", "etxc74Av");
    connection.setAutoCommit(false);
    PreparedStatement statement = connection.prepareStatement("select count(*) from UserInfo");
    ResultSet resultSet = statement.executeQuery();
    if (resultSet != null && resultSet.next()) {
      System.out.println(resultSet.getInt(1));
    }
    connection.commit();
    connection.close();
  }
}
