public class Account {

    private long money;
    private String accNumber;
    private volatile boolean isAccountBlocked;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
        this.isAccountBlocked = false;
    }

    public long getMoney() {
        return money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public synchronized void putMoney(long sum) {money += sum;}

    public synchronized void takeMoney(long sum) {money -= sum;}

    public void accBlocked () {isAccountBlocked = true;}

    public void accUnlocked() {isAccountBlocked = false;}

    public boolean isBlocked() {return isAccountBlocked;}
}
