import javax.xml.crypto.Data;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Locale;
import java.time.LocalDate;
import java.util.zip.DataFormatException;

public class Main {

    public static void main(String[] args) {

        int day = 30;                     //30
        int month = 3;                   //12
        int year = 1990;                  //1990

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        final String PRINT_DATE_FORMAT = "dd.MM.yyyy - EEE";
        final Locale LOCALE = new Locale("en");
        StringBuilder birthdays = new StringBuilder("");
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);
        int count = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PRINT_DATE_FORMAT, LOCALE);

        while (birthday.isBefore(today) || birthday.isEqual(today)) {
           birthdays.append(count + " - " + birthday.format(formatter) + "\n");
           birthday = birthday.plusYears(1);
           count++;

        }

        return String.valueOf(birthdays);
    }
}
