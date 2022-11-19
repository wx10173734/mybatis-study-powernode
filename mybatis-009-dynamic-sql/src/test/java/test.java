import com.lzc.mapper.CarMapper;
import com.lzc.pojo.Car;
import com.lzc.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @title: test
 * @Author luozouchen
 * @Date: 2022/11/19 10:40
 */
public class test {
    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
//        List<Car> carList = mapper.selectByMultiCondition("丰田",2.00,"燃油车");
        List<Car> carList1 = mapper.selectByMultiCondition("", null, "");
        for (Car car : carList1) {
            System.out.println(car);
        }
    }

    @Test
    public void test1() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> carList = mapper.selectByMultiConditionWithWhere("丰田", 2.00, "燃油车");
//        List<Car> carList1 = mapper.selectByMultiConditionWithWhere("",null,"");
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    @Test
    public void test2() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> carList = mapper.selectByMultiConditionWithTrim("丰田", 2.00, "燃油车");
//        List<Car> carList1 = mapper.selectByMultiConditionWithWhere("",null,"");
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    @Test
    public void test3() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(165L, null, null, null, null, "1");
        int i = mapper.updateById(car);
        sqlSession.commit();

    }

    @Test
    public void test4() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(166L, null, null, null, null, "3");
        int i = mapper.updateBySet(car);
        sqlSession.commit();

    }

    @Test
    public void testSelectWithChoose() {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        //List<Car> cars = mapper.selectWithChoose("丰田霸道", 20.0, "2000-10-10");
        //List<Car> cars = mapper.selectWithChoose("", 20.0, "2000-10-10");
        //List<Car> cars = mapper.selectWithChoose("", null, "2000-10-10");
        List<Car> cars = mapper.selectWithChoose("", null, "");
        System.out.println(cars);
    }

    @Test
    public void testDeleteBatchByForeach() {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        int count = mapper.deleteByIds(new Long[]{165L, 166L, 167L});
        System.out.println("删除了几条记录：" + count);
        SqlSessionUtil.openSession().commit();
    }

    @Test
    public void testInsertBatchByForeach() {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Car car1 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        Car car2 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        Car car3 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        List<Car> cars = Arrays.asList(car1, car2, car3);
        int count = mapper.insertBatchByForeach(cars);
        System.out.println("插入了几条记录" + count);
        SqlSessionUtil.openSession().commit();
    }
}
