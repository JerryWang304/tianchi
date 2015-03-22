import dal.Neo4jBuilder;
import etl.loader.impl.SimpleLoader;
import framework.Context;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yangtao.lyt on 2015/03/21 15:43
 */
public class Test {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        /**
         * neo4j数据库构建器，使用一次后，可以注释掉
         */
        Neo4jBuilder neo4jBuilder = (Neo4jBuilder) springContext.getBean("neo4jBuilder");






        SimpleLoader simpleLoader = (SimpleLoader)springContext.getBean("simpleLoader");
        Context context = simpleLoader.load();




    }

}
