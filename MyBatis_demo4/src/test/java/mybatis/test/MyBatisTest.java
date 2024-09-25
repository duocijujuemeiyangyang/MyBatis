package mybatis.test;


import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;


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
        //访问第一页，每页四条数据
        //PageHelper.startPage(1,4);
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);
    }




}
