import com.lzc.mapper.CarMapper;
import com.lzc.mapper.LogMapper;
import com.lzc.pojo.Car;
import com.lzc.pojo.Log;
import com.lzc.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @title: CarMapperTest
 * @Author luozouchen
 * @Date: 2022/11/17 11:31
 */
public class CarMapperTest {

    @Test
    public void SelectByCarType() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectByCarType("燃油车");
        cars.forEach(car -> System.out.println(car));
    }

    @Test
    public void selectAllByAscOrDesc() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectAllByAscOrDesc("desc");
        cars.forEach(car -> System.out.println(car));
    }

    @Test
    public void selectAllByTable() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        List<Log> logs = logMapper.selectAllByTable("20220901");
        logs.forEach(log -> System.out.println(log));
    }

    @Test
    public void deleteBatch() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        int i = carMapper.deleteBatch("169,171,172");
        System.out.println(i);
        sqlSession.commit();
    }

    @Test
    public void selectByBrandLike() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectByBrandLike("丰田");
        cars.forEach(car -> System.out.println(car));

    }

    @Test
    public void insertCarUseGenerateKeys() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "9991", "凯美瑞", 30.0, "2020-11-11", "燃油车");
        int i = carMapper.insertCarUseGenerateKeys(car);
        System.out.println(i);
        System.out.println(car);

        sqlSession.commit();
        sqlSession.close();
    }
}
