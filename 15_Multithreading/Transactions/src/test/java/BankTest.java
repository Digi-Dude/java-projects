import junit.framework.TestCase;

public class BankTest extends TestCase {
    Bank bank = new Bank();
    long expected;

    @Override
    protected void setUp() throws Exception {

        for (int i = 0; i < 1000; i++) {
            bank.addAcc(String.format("%05d", i), (long)(Math.random() * 500000 + 500000));
        }
        expected = bank.getSumAllAccounts();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {bank.transfer(String.format("%05d", (int)(Math.random()* 1000)), String.format("%05d", (int)(Math.random()* 1000)), (long)(Math.random()*100000));}).start();
        }

        super.setUp();

    }

    public void testTransfer() {
        long actual = bank.getSumAllAccounts();
        assertEquals(actual, expected);
    }

}
