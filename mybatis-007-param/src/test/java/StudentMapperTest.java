//import com.lzc.mapper.StudentMapper;
//import com.lzc.pojo.Student;
//import com.lzc.utils.SqlSessionUtil;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
///**
// * @title: StudentMapperTest
// * @Author luozouchen
// * @Date: 2022/11/17 18:23
// */
//public class StudentMapperTest {
//    @Test
//    public void testSelectById() {
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//        List<Student> students = studentMapper.selectById(1L);
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        sqlSession.close();
//    }
//
//    @Test
//    public void testSelectByBirth() throws ParseException {
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date birth = sdf.parse("1980-10-11");
//        List<Student> students = studentMapper.selectByBirth(birth);
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        sqlSession.close();
//    }
//
//    @Test
//    public void testSelectBySex() throws ParseException {
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//
//        List<Student> students = studentMapper.selectBySex('女');
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        sqlSession.close();
//    }
//
//    @Test
//    public void testSelectByMap() throws ParseException {
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//        Map<String, Object> map = new HashMap<>();
//        map.put("姓名", "赵六");
//        map.put("年龄", 20);
//        map.put("身高", 1.81);
//        map.put("性别", '男');
//        map.put("生日", new Date());
//
//        studentMapper.insertStudentByMap(map);
//        sqlSession.commit();
//
//        sqlSession.close();
//    }
//
//    @Test
//    public void selectByNameAndSex() {
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//
//
//        List<Student> students = studentMapper.selectByNameAndSex("赵六", '男');
//        for (Student student : students) {
//            System.out.println(student);
//        }
//
//
//        sqlSession.close();
//    }
//
//    @Test
//    public void selectByNameAndSex2() {
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        //mapper实际上指向了代理对象
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        //mapper是代理对象
//        //selectByNameAndSex2是代理方法
//        List<Student> students = mapper.selectByNameAndSex2("赵六", '男');
//        for (Student student : students) {
//            System.out.println(student);
//        }
//
//
//        sqlSession.close();
//    }
//}
