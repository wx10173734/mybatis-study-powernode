import com.lzc.pojo.Car;
import com.lzc.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Luozouchen
 * @classname CarMapperTest
 * @create 2022/11/13 15:40
 */
public class CarMapperTest {
    @Test
    public void testInsertCar() {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        Map<String, Object> map = new HashMap<>();
        map.put("carNum", "1111");
        map.put("brand", "比亚迪汉2");
        map.put("guidePrice", 10.0);
        map.put("produceTime", "2020-11-11");
        map.put("carType", "电车");
        //执行sql语句
        int insert = sqlSession.insert("insertCar", map);
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarByPojo() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(null, "3333", "比亚迪秦", 30.0, "2020-11-11", "新能源");
        sqlSession.insert("insertCar", car);
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int deleteById = sqlSession.delete("deleteById", 179);
        System.out.println(deleteById);
    }

    @Test
    public void testUpdateCarByPOJO() {
        // 准备数据
        Car car = new Car();
        car.setId(178L);
        car.setCarNum("102");
        car.setBrand("比亚迪汉");
        car.setGuidePrice(30.23);
        car.setProduceTime("2018-09-10");
        car.setCarType("电车");
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句
        int count = sqlSession.update("updateById", car);
        System.out.println("更新了几条记录：" + count);
    }

    @Test
    public void testSelectCarById() {
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句
        Object car = sqlSession.selectOne("selectCarById", 178);
        System.out.println(car);
    }

    @Test
    public void testSelectCarAll() {
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句
        List<Object> cars = sqlSession.selectList("selectCarAll");
        // 输出结果
        cars.forEach(car -> System.out.println(car));
    }
}
