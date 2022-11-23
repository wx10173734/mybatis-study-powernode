import com.lzc.SqlSessionUtil;
import com.lzc.mapper.CarMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @title: test
 * @Author luozouchen
 * @Date: 2022/11/23 20:05
 */
public class test {
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.deleteByPrimaryKey(178L);
        sqlSession.commit();
        sqlSession.close();
    }
}
