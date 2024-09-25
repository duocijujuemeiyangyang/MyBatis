package mybatis.test;



import com.atguigu.mybatis.mapper.User2Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


public class MyBatisTest {

    @Test
    public void testinsert() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象(会话)
        SqlSession sqlSession = build.openSession(true);//设置为自动提交事务，默认是不提交事务
        User2Mapper mapper = sqlSession.getMapper(User2Mapper.class);
        int result = mapper.insertUser();
        System.out.println("result+"+result);
    }



    @Test
    public void testupdate() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象(会话)
        SqlSession sqlSession = build.openSession(true);//设置为自动提交事务，默认是不提交事务
        User2Mapper mapper = sqlSession.getMapper(User2Mapper.class);
        User user = new User();
        user.setAge(23);
        mapper.updataUser2(user);
    }


    @Test
    public void testselect() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象(会话)
        SqlSession sqlSession = build.openSession(true);//设置为自动提交事务，默认是不提交事务
        User2Mapper mapper = sqlSession.getMapper(User2Mapper.class);
        List<User> selectlist = mapper.selectlist();
        System.out.println(selectlist);
    }

    @Test
    public void testselectmap() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象(会话)
        SqlSession sqlSession = build.openSession(true);//设置为自动提交事务，默认是不提交事务
        User2Mapper mapper = sqlSession.getMapper(User2Mapper.class);
        Map<String, Object> stringObjectMap = mapper.selectMap();
        System.out.println(stringObjectMap);
    }



    @Test
    public void testselectmapall() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象(会话)
        SqlSession sqlSession = build.openSession(true);//设置为自动提交事务，默认是不提交事务
        User2Mapper mapper = sqlSession.getMapper(User2Mapper.class);
        List<Map<String, Object>> maps = mapper.selectMapList();
        System.out.println(maps);
    }


    @Test
    public void testselectmapall2() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象(会话)
        SqlSession sqlSession = build.openSession(true);//设置为自动提交事务，默认是不提交事务
        User2Mapper mapper = sqlSession.getMapper(User2Mapper.class);
        List<Map<String, Object>> maps = mapper.selectMapallList();
        System.out.println(maps);
    }



    @Test
    public void testdelect() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象(会话)
        SqlSession sqlSession = build.openSession(true);//设置为自动提交事务，默认是不提交事务
        User2Mapper mapper = sqlSession.getMapper(User2Mapper.class);

        mapper.delectUserlist("3,4,5");
    }




    @Test
    public void testselectusertable() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象(会话)
        SqlSession sqlSession = build.openSession(true);//设置为自动提交事务，默认是不提交事务
        User2Mapper mapper = sqlSession.getMapper(User2Mapper.class);

        List<User> users = mapper.selectuserbytable("user");
        System.out.println(users);
    }

    @Test
    public void testinsert2() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象(会话)
        SqlSession sqlSession = build.openSession(true);//设置为自动提交事务，默认是不提交事务
        User2Mapper mapper = sqlSession.getMapper(User2Mapper.class);

        User user = new User(null, "老王", "123456", 18, "12345678910");
        PageHelper.startPage(1, 2);
        List<User> selectlist = mapper.selectlist();
        PageInfo<User> page= new PageInfo<User>(selectlist,5);
        System.out.println(page);
    }


}
