package mybatis.test;


import com.atguigu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;


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
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //int result = mapper.insertUser();
        User user = mapper.selectUserById();
        System.out.println("User+"+user);
    }

}
