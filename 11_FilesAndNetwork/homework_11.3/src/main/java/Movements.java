import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Movements {
    private static final String separator = ",";
    private double expenseSum;
    private double incomeSum;
    private static List<Expense> expensesList = new ArrayList<>();
    private static String pathToFile;
    public static ArrayList<HashMap<String, String>> data = new ArrayList<>();


    public Movements(String pathMovementsCsv) {
        pathToFile = pathMovementsCsv;
        readFileWithSeparators();
    }






    //**************************************************************************

    private static void readFileWithSeparators() {

        try {
            Files.lines(Paths.get(pathToFile))
                    .forEach(line -> {
                        //разбиваем строку на аттрибуты с указанным разделителем с помощью регулярного выражения
                        String[] attributes = line.split(separator + "(?=(?:[^\"]*\"[^\"]*\")*(?![^\"]*\"))");
                        HashMap<String, String> params = new HashMap<>();
                        if (data.size() == 0){ //задаем заголовки
                            for (int i = 0; i < attributes.length; params.put(i + "", attributes[i]), i++) {}
                        } else {
                            if (attributes.length == data.get(0).size()) { //защита по количеству атрибутов
                                //добавляем все аттрибуты в HashMap
                                for (int i = 0; i < attributes.length; params.put(data.get(0).get(i + ""), attributes[i]), i++) {}
                            }
                        }
                        data.add(params);
                    });
            recordingExpense();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }


//    Значение можно получать вот так



    /**
     * @param value - числовое значение в строке
     * @return - возвращаем double числовое значение, полученное из строки
     */
    private static double getValue(String value)
    {
        return Double.parseDouble(value.replaceAll("[^0-9,]", "").replaceAll(",", "."));
    }

    //**************************************************************************




    public Double getExpenseSum() {
        data.forEach(line -> {
            if (line.containsKey("Расход"))
            expenseSum += getValue(line.get("Расход"));
        });

        return expenseSum;
    }

    public Double getIncomeSum() {
        data.forEach(line -> {
            if (line.containsKey("Расход")) {
                incomeSum += getValue(line.get("Приход"));
            }
        });
        return incomeSum;
    }


    private static void recordingExpense() {
        data.forEach(line -> {
            if (line.containsKey("Расход")){
                if (!line.get("Расход").equals("0")) {
                    expensesList.add(new Expense(line.get("Описание операции"), line.get("Расход")));
                }
            }
        });
    }

    public void printAllExpense() {
        for(Expense expense: expensesList) {
            System.out.println(expense);
        }
    }


}
