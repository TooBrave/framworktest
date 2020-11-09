import com.b1ub1u.pojo.Student;
import com.b1ub1u.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //无参构造器

        Student student = (Student) context.getBean("student");
        System.out.println(student);


    }
    @Test
    public void pTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //这种形式不用强转
        User user = context.getBean("puser",User.class);
        System.out.println(user);
    }
    @Test
    public void cTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //这种形式不用强转
        User user = context.getBean("cuser",User.class);
        System.out.println(user);
    }
}
