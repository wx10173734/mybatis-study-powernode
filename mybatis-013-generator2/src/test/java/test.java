import com.lzc.SqlSessionUtil;
import com.lzc.mapper.CarMapper;
import com.lzc.pojo.Car;
import com.lzc.pojo.CarExample;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @title: test
 * @Author luozouchen
 * @Date: 2022/11/23 20:33
 */
public class test {
    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //查询一个
        Car car = mapper.selectByPrimaryKey(177L);
        System.out.println(car);
        //查询所有
        List<Car> carList = mapper.selectByExample(null);
        carList.forEach(car1 -> System.out.println(car1));
        //按照条件查询
        //封装条件，通过carexample来封装条件
        CarExample carExample = new CarExample();
        //carExample.createCriteria() 来创建查询条件
        carExample.createCriteria().andBrandLike("兰博基尼").andGuidePriceGreaterThan(new BigDecimal(150));
        //添加or
        carExample.or().andCarTypeEqualTo("燃油车");
        List<Car> carList1 = mapper.selectByExample(carExample);
        carList1.forEach(car1 -> System.out.println(car1));

    }
}
