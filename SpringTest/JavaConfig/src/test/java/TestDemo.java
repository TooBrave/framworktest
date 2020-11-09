import com.b1ub1u.config.B1ub1uConfg;
import com.b1ub1u.pojo.People;
import com.b1ub1u.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {


    @Test
    public void TestDemo2(){

        ApplicationContext context = new AnnotationConfigApplicationContext(B1ub1uConfg.class);
        User user = context.getBean("getUser", User.class);  //"getUser" 为Java配置文件中的方法名
        System.out.println(user.getName());

    }
}
