import com.lzc.mapper.StudentMapper;
import com.lzc.pojo.Student;
import com.lzc.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @title: StudentTest
 * @Author luozouchen
 * @Date: 2022/11/21 10:44
 */
public class StudentTest {
    @Test
    public void selectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectById(1);
        System.out.println(student);
    }

    @Test
    public void selectByAssociation() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectByAssociation(1);
        System.out.println(student);
    }

    @Test
    public void selectByStep1() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectByStep1(2);
        System.out.println(student.getSname() );
        System.out.println(student.getClazz() );

    }
}
