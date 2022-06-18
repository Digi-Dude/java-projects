import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AverageValue {
    private Connection connection;
    private static final List<String> coursesName = new ArrayList<>();

    public AverageValue(String url, String user, String pass) {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses");
            while (resultSet.next()) {
                coursesName.add(resultSet.getString("name"));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String averagePurchasesPerMonth () {
        StringBuilder table = new StringBuilder();
        int stringLength = 50;
        table.append(String.format("%1$" + stringLength + "s", "name_course")).append("|").append(String.format("%1$" + stringLength + "s", "average_value")).append("|").append("\n");
        table.append("-".repeat(stringLength * 2)).append("\n");
        for (String courseName :coursesName) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("(SELECT course_name, (count(*) / max(month(subscription_date))) as average_value from purchaselist where course_name = \"" + courseName + "\")");
                while (resultSet.next()) {
                    if (resultSet.getString("course_name") == null) {
                        break;
                    }
                    table.append(String.format("%1$" + stringLength + "s", resultSet.getString("course_name"))).append("|").append(String.format("%1$" + stringLength + "s", resultSet.getString("average_value") + "|" + "\n"));
                }
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return table.toString();
    }
}
