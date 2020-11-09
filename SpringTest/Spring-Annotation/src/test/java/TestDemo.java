import com.b1ub1u.pojo.People;
import com.b1ub1u.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    @Test
    public void TestDemo1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = context.getBean("people", People.class);
        people.getCat().meow();
        people.getDog().bark();
    }

    //使用@Component @Value
    @Test
    public void TestDemo2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.getName());
    }
    /**
     * @Component(Class) @Repository(Dao) @Service(Service) @Controller(Controller)四个注解功能一样
     * 区别在于区分不同的层
     *
     *
     */
}
