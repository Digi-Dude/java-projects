

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();
    private long bankAssets = 0;

    private synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        long actualBalance = bankAssets;
        if (accounts.get(fromAccountNum).isBlocked() || accounts.get(toAccountNum).isBlocked()) {
            System.out.println("Ваш счет заблокирован, обратитесь в отделение банка");
        }
        if (amount > 50000) {
            new Thread(() -> {
                try {
                    if (isFraud(fromAccountNum, toAccountNum, amount)) {
                        accounts.get(fromAccountNum).accBlocked();
                        accounts.get(toAccountNum).accBlocked();
                        System.out.println("Счета " + fromAccountNum + " и " + toAccountNum + " заблокированы");
                    }
                    else {
                        accounts.get(fromAccountNum).takeMoney(amount);
                        accounts.get(toAccountNum).putMoney(amount);
                        System.out.println("Транзакция прошла успешно");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
        accounts.get(fromAccountNum).takeMoney(amount);
        accounts.get(toAccountNum).putMoney(amount);
        System.out.println("Транзакция прошла успешно");

        if (actualBalance != bankAssets) {
            throw new IllegalArgumentException ("Сумма активов банка изменилась");
        }
    }

    public void addAcc(String numAcc, long sum) {
        accounts.put(numAcc, new Account(sum, numAcc));
        increaseBankAssets(sum);
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        long balance = accounts.get(accountNum).getMoney();
        return balance;
    }

    public long getSumAllAccounts() {return bankAssets;}

    private void increaseBankAssets(long sum) {
        this.bankAssets += sum;
    }
}
