import Screen.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Config/applicationContext.xml");
        mainScreen ms = (mainScreen) applicationContext.getBean("ms");
        ms.run();
    }
}
