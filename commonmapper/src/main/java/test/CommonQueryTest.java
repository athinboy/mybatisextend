package test;

import java.io.InputStream;
import java.util.List;

import cn.athinbly.mybatisextend.commonmapper.mapper.CommonMapper;
import org.apache.ibatis.io.Resources;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.Student;
import test.StudentMapper;


/**
 * Created by fenggqc on 2016/12/16.
 */
public class CommonQueryTest {


    public static void main(String[] args) throws Exception {


        //org.apache.ibatis.logging.LogFactory.useLog4J2Logging();

        CommonQueryTest CommonQueryTest = new CommonQueryTest();

        CommonQueryTest.Test();


    }


    private void Test() throws Exception {
        {


            Logger logger = LoggerFactory.getLogger(CommonQueryTest.class);

            logger.error("111111111111111111111111111111111111111111111111111111");




            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory sqlSessionFactory = null;
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            is.close();


            List<?> result;
            SqlSession sqlSession = null;
            sqlSession = sqlSessionFactory.openSession();

           // ui = sqlSession.selectOne("selectbutton", "buttonAdd");

             StudentMapper ui2Mapper = sqlSession.getMapper(StudentMapper.class);
            Student student;
            //student = ui2Mapper.SelectOne(1);


            student=new Student();
            CommonMapper<Student> commonMapper = sqlSession.getMapper(CommonMapper.class);

            student.setId(1);
            student.setName("name");
            student.setMale(false);
            commonMapper.Insert(student);


            student.setMale(null);
            commonMapper.Insert(student);





            //Object o = commonMapper.SelectByPrimaryKey(student);


            sqlSession.commit();
            sqlSession.close();


//            ///////////----------------------------------------------------------------------
//
//
//
//            org.apache.commons.dbcp.BasicDataSource dataSource = new BasicDataSource();
//            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//            dataSource.setUrl("jdbc:mysql://10.0.2.120:3306/test_db");
//            dataSource.setUsername("root");
//            dataSource.setPassword("itstest$");
//            Connection connection;
//
//            org.apache.commons.dbcp.DataSourceConnectionFactory dataSourceConnectionFactory = null;
//
//
//            dataSourceConnectionFactory = new DataSourceConnectionFactory(dataSource);
//            connection = dataSourceConnectionFactory.createConnection();
//
//
//
//                PreparedStatement s = connection.prepareStatement("select e.page_id as 'button_id',e.page_name as 'text_value'\n" +
//                        "  from ui_page e " +
//                        " WHERE e.page_id=?");
//
//                s.setString(1, "buttonAdd" + 1);
//                ResultSet rs = s.executeQuery();
//
//
//                while (rs.next()) {
//
//                    ui = new fgq.test.UI();
//                    ui.setButton_id(rs.getString("button_id"));
//                    ui.setText_value(rs.getString("text_value"));
//
//                }
//
//
//
//            connection.close();
//            ///////////----------------------------------------------------------------------


        }
    }
}