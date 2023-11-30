import account.Account;
import account.IncorrectPasswordException;
import account.InvalidAmountException;
import account.InvalidWithdrawalAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    Account account;

    @BeforeEach
    void setUp() {
        account = new Account("MyAccount","1","MyPassword");
    }

    @Test
    public void testThatAccountCanDepositMoneyToAccount() {
        account.deposit(1_000);
        assertEquals(1_000, account.checkBalance("MyPassword"));
    }

    @Test
    public void testThatAccountCantTakeDepositLesserThanZero() {
        assertThrows(InvalidAmountException.class, () -> account.deposit(-2));
    }

    @Test
    public void testThatAccountCanDeposit_and_withdraw() {
        account.deposit(2_300);
        assertThrows(IncorrectPasswordException.class,() ->account.withdraw(1_000,"MyInCorrectPassword"));
    }
    @Test
    public void testThatAccountICantWithdrawMoreThanCurrentBalance() {
        account.deposit(2_300);
        assertThrows(InvalidWithdrawalAmountException.class, () ->account.withdraw(2_500,"MyPassword"));
    }
    @Test public void testThatWithdrawalWontWorkIfPasswordIsNotCorrect(){
        account.deposit(4_500);

    }
    @Test public void testThatAccountWhenIDeposit5K_and_i_withdraw_3500_balanceWouldBe1500(){
        account.deposit(2_000);
        account.deposit(2_500);
        account.deposit(5_00);
        account.withdraw(3_500,"MyPassword");
       assertEquals(1_500,account.checkBalance("MyPassword"));

    }




}
