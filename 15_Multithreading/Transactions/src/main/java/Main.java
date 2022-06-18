public class Main {
    public static Bank bank = new Bank();

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            bank.addAcc(String.format("%05d", i), (long)(Math.random() * 500000 + 500000));
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {bank.transfer(String.format("%05d", (int)(Math.random()* 1000)), String.format("%05d", (int)(Math.random()* 1000)), (long)(Math.random()*100000));}).start();
        }
    }

}
