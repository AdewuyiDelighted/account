import account.Account;
import account.BankingApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankingAppTest {
    BankingApp gtb;

    @BeforeEach
    public void setUpAccount() {
        gtb = new BankingApp();
    }

    @Test
    public void testThatAccountHaveAccountNumber() {
        Account account = gtb.createAccount("Me", "You", "Us");
        assertEquals(1, gtb.getNumberOfAccount());
        assertEquals("1", account.getAccountNumber());
    }

    @Test
    public void testThatAccountCanBeFoundWhenAnAccountIsCreated() {
        Account account = gtb.createAccount("Me", "You", "Us");
        Account account2 = gtb.createAccount("lola", "ade", "Password");
        assertEquals(account, gtb.findAccount("1"));
        assertEquals(account2, gtb.findAccount("2"));
    }

    @Test
    public void testThatBankCanDepositIntoUserAccount() {
        Account account = gtb.createAccount("Me", "You", "Us");
        gtb.deposit("1", 2500);
        assertEquals(2500, gtb.checkBalance("1", "Us"));
    }

    @Test
    public void testThatBankCanWithdrawWhenThereIsMoneyInTheAccount() {
        Account account = gtb.createAccount("Me", "You", "Us");
        gtb.deposit("1", 1500);
        gtb.withdraw("1", "Us", 1000);
        assertEquals(500, gtb.checkBalance("1", "Us"));
    }

    @Test
    public void testThatUserCanTransferFromOneToAnother() {
        Account account = gtb.createAccount("Me", "You", "Us");
        Account account2 = gtb.createAccount("lola", "ade", "Password");
        gtb.deposit("1",3000);
        gtb.transfer("1","2","Us",2000);
        assertEquals(1000,gtb.checkBalance("1","Us"));
        assertEquals(2000,gtb.checkBalance("2","Password"));
    }

}

