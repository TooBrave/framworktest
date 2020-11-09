import com.b1ub1u.config.SpringConfiguration;
import com.b1ub1u.domain.Account;
import com.b1ub1u.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    IAccountService accountService;


    @Test
    public void findAllTest(){
        List<Account> accounts = accountService.findAllAccount();
        for(Account ac : accounts)
            System.out.println(ac);

    }
    @Test
    public void findByIdTest(){
        Account account = accountService.findAccountById(2);

    }
    @Test
    public void saveTest(){
        Account account = new Account();
        account.setMoney(20000.0f);
        account.setName("STY");
        accountService.saveAccount(account);
        findAllTest();
    }
    @Test
    public void updateTest(){
        Account account = new Account();
        account.setId(3);
        account.setName("Linlin");
        account.setMoney(232323f);
        accountService.updateAccount(account);
        findAllTest();
    }
    @Test
    public void deleteTest(){
        accountService.deleteAccount(6);
        findAllTest();
    }

}
