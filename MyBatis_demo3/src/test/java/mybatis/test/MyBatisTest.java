package mybatis.test;


import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Dept;
import pojo.Emp;
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
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //int result = mapper.insertUser();
        Emp emp = mapper.selectEmpById(1);
        System.out.println("emp+"+emp);
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
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        //int result = mapper.insertUser();
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println("dept+"+dept);
    }
}
