import com.sun.source.tree.UsesTree;
import org.apache.commons.collections.list.TreeList;

import java.util.*;

public class EmailList {

    //private Collection<String> dd = Collections.emptyList();
    private Collection<String> emailList =  new TreeSet<>();
    public void add(String email) {
        // TODO: валидный формат email добавляется
        if (email.matches("^\\w+@\\w+\\.\\w+")) {
            emailList.add(email.toLowerCase().trim());
        }
        else {
            System.out.println(Main.WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        List<String> list = new ArrayList<>();
        for(String email: emailList) {
            list.add(email);
        }
        return list;
    }

}
