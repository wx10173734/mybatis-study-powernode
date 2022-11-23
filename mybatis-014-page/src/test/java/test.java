import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzc.SqlSessionUtil;
import com.lzc.mapper.CarMapper;
import com.lzc.pojo.Car;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @title: test
 * @Author luozouchen
 * @Date: 2022/11/23 21:04
 */
public class test {
    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int pageSize = 3;
        //显示第几页，页码
        int pageNum = 1;
        int startSize = (pageNum - 1) * pageSize;
        List<Car> cars = mapper.selectByPage(startSize, pageSize);
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void test1() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //执行分页语句之前，开启分页功能
        int pageNum = 2;
        int pageSize = 3;

        PageHelper.startPage(pageNum, pageSize);
        List<Car> cars = mapper.selectAll();
//        cars.forEach(car -> System.out.println(car));
        //封装分页信息对象 newPageInfo()
        //PageInfo对象是PageHelper插件提供的，用来封装分页相关的信息的对象。
        PageInfo<Car> carPageInfo = new PageInfo<>(cars, 3);
        /*
        PageInfo{
      pageNum=2, pageSize=2, size=2, startRow=3, endRow=4, total=6, pages=3,
      list=Page{count=true, pageNum=2, pageSize=2, startRow=2, endRow=4, total=6, pages=3, reasonable=false, pageSizeZero=false}
      [Car{id=86, carNum='1234', brand='丰田霸道', guidePrice=50.5, produceTime='2020-10-11', carType='燃油车'},
      Car{id=87, carNum='1234', brand='丰田霸道', guidePrice=50.5, produceTime='2020-10-11', carType='燃油车'}],
      prePage=1, nextPage=3, isFirstPage=false, isLastPage=false, hasPreviousPage=true, hasNextPage=true,
      navigatePages=5, navigateFirstPage=1, navigateLastPage=3, navigatepageNums=[1, 2, 3]
}
         */
        System.out.println(carPageInfo);
        sqlSession.close();
    }
}
