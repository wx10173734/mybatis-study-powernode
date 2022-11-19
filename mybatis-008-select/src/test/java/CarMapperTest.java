import com.lzc.mapper.CarMapper;
import com.lzc.pojo.Car;
import com.lzc.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @title: CarMapperTest
 * @Author luozouchen
 * @Date: 2022/11/18 21:54
 */
public class CarMapperTest {
    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(165L);
        System.out.println(car);
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> car = mapper.selectAll();
        for (Car car1 : car) {
            System.out.println(car1);
        }
    }

    @Test
    public void testSelectBrandByLike() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByBrandLike("丰田");
        System.out.println(car);
    }

    @Test
    public void selectByIdRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Object> carMap = mapper.selectByIdRetMap(165L);
        System.out.println(carMap);
    }

    @Test
    public void selectAllRetListMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String, Object>> carMaps = mapper.selectAllRetListMap();
        carMaps.forEach(carmap -> System.out.println(carmap));
    }

    @Test
    public void selectAllRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long, Map<String, Object>> carMaps = mapper.selectAllRetMap();
        System.out.println(carMaps);
    }

    @Test
    public void selectAllByResultMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByResultMap();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void selectBymapUnderscoreToCamelCase() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectBymapUnderscoreToCamelCase();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void selectTotal() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long count = mapper.selectTotal();
        System.out.println(count);
    }

}
