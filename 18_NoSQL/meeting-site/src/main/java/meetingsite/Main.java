package meetingsite;

public class Main {

    private static int count = 0;

    public static void main(String[] args)
    {
        meetingSiteStorage redis = new meetingSiteStorage();
        redis.init();

        for (int i = 20; i >= 1; i--)
        {
            redis.addUsers(i);
        }

        while (true)
        {
            if(count == 10)
            {
                count = 0;
                int randomAcc = (int) ( Math.random() * 21 );
                redis.addUsers(randomAcc);
                System.out.println("Пользователь " + randomAcc + " оплатил платную услугу");
                redis.showUsr();
                continue;
            }
            count++;
            redis.showUsr();
        }

    }
}
