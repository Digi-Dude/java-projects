package meetingsite;
import org.redisson.Redisson;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;
import static java.lang.System.out;
import java.util.Collection;
import java.util.Date;


public class meetingSiteStorage {

    private RedissonClient redisson;

    private RScoredSortedSet<String> onlineUsers;

    private final static String KEY = "REGISTERED_USERS";

    private static final int SLEEP = 10;


    private double getTs() {
        return new Date().getTime();
    }
 
    void init()
    {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        onlineUsers = redisson.getScoredSortedSet(KEY);
        clearList();
    }

    void addUsers(int user_id)
    {
        out.println(getTs());
        onlineUsers.add(getTs(), "User " + String.valueOf(user_id));
    }

    void showUsr()
    {
        Collection<String> newList= onlineUsers.valueRangeReversed(Integer.MIN_VALUE, Integer.MAX_VALUE);
        newList.forEach((usr) -> {
            out.println(usr);
            try {
                Thread.sleep(SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    void clearList() {
        onlineUsers.clear();
    }
}
