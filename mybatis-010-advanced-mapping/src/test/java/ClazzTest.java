import com.lzc.mapper.ClazzMapper;
import com.lzc.pojo.Clazz;
import com.lzc.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @title: ClazzTest
 * @Author luozouchen
 * @Date: 2022/11/21 10:44
 */
public class ClazzTest {
    @Test
    public void selectByCollection() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = clazzMapper.selectByCollection(1000);
        System.out.println(clazz);
    }

    @Test
    public void selectByStep1() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = clazzMapper.selectByStep1(1000);
        System.out.println(clazz.getCname());
    }
}
