import etl.loader.impl.SimpleLoader;
import framework.Context;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yangtao.lyt on 2015/03/21 15:43
 */
public class Test {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimpleLoader simpleLoader = (SimpleLoader)springContext.getBean("simpleLoader");
        Context context = simpleLoader.load();

        System.out.println(context.toString());


    }

}
