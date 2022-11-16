import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @title: ParseXMLByDom4jTest
 * @Author luozouchen
 * @Date: 2022/11/15 21:44
 */
public class ParseXMLByDom4jTest {
    @Test
    public void testParseMyBatisConfigXML() throws Exception {
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //获取输入流
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        //读xml文件 返回document对象。document对象是文档对象，代表了整个XML文件。
        Document document = reader.read(is);
        System.out.println(document);
        //获取文档中的根标签
//        Element rootElement = document.getRootElement();
//        System.out.println("根节点名字"+rootElement.getName());
        //获取default默认的环境Id
        //一下的xpath代表了从根下开始找configuration ，然后找configuration下的environments
        String xpath = "/configuration/environments";//xpath是做标签路径匹配的。能够让我们快速定位XML文件中的元系。
        Element environments = (Element) document.selectSingleNode(xpath);//element是Node类的子类，方法更多，使用更编辑
        //获取属性的值
        String defaultEnvironmentId = environments.attributeValue("default");
        System.out.println("默认环境的id" + defaultEnvironmentId);
        //获取具体的环境environment
        xpath = "/configuration/environments/environment[@id='" + defaultEnvironmentId + "']";
//        System.out.println(xpath);
        Element environment = (Element) document.selectSingleNode(xpath);
        //获取environment节点下的transactionManager节点(element的element方法用来获取孩子节点)
        Element transactionManager = environment.element("transactionManager");
        String transactionType = transactionManager.attributeValue("type");
        System.out.println("事务管理器类型" + transactionType);
        //获取datasource节点
        Element dataSource = environment.element("dataSource");
        String dataSourceType = dataSource.attributeValue("type");
        System.out.println("数据源的类型" + dataSourceType);
        //获取datasource节点下的所有子节点
        List<Element> propertyElts = dataSource.elements();
        //遍历
        propertyElts.forEach(propertyElt -> {
            String name = propertyElt.attributeValue("name");
            String value = propertyElt.attributeValue("value");
            System.out.println("name:" + name + " value:" + value);
        });
        //获取所有的Mapper标签
        xpath = "//mapper";//不想从根下开始获取，你想从任意位置开始，获取所有的某个标签，xpath该这样写
        List<Node> mappers = document.selectNodes(xpath);
        //遍历
        mappers.forEach(mapper -> {
            Element mapperElt = (Element) mapper;
            String resource = mapperElt.attributeValue("resource");
            System.out.println(resource);
        });
    }

    @Test
    public void testParseSQLMapper() throws DocumentException {
        SAXReader reader = new SAXReader();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("CarMapper.xml");
        Document document = reader.read(is);
        String xpath = "/mapper";
        Element mapper = (Element) document.selectSingleNode(xpath);
        //获取namespace
        String namespace = mapper.attributeValue("namespace");
        System.out.println(namespace);
        //获取mapper节点下的所有子节点
        List<Element> elements = mapper.elements();
        elements.forEach(element -> {
            //获取sqlid
            String id = element.attributeValue("id");
            System.out.println(id);
            //获取resultType
            String resultType = element.attributeValue("resultType");//没有这个属性的话，返回null字符串
            System.out.println(resultType);
            //获取标签中的sql语句   (表示获取标签中的文本内容，而且去除全部空白)
            String sql = element.getTextTrim();
            System.out.println(sql);
            //insert into t_car values (null, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType})
            //insert into t_car values (null, ?,?,?,?,?)
            //mybatis封装了jdbc,早晚要执行带有？的sql语句
            String s = sql.replaceAll("#\\{[0-9A-Za-z_$]*}", "?");
            System.out.println(s);


        });


    }
}
