import cn.edu.hdu.domain.Account;
import cn.edu.hdu.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class SpringDbutilsTest {

    @Autowired
    @Qualifier("accoutServiceProxy")
    private IAccountService as;

    @Test
    public void testFindAll(){
        List<Account> accounts = as.findAll();

        for (Account account: accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void tesSaveAccount(){
        Account account = new Account();
        account.setId(4);
        account.setMoney(2000.0);
        account.setUid(46);

        as.saveAccount(account);
    }


    @Test
    public void testTransfer(){
        as.transfer(45,46,100.00);
    }

}
