package homework;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.opencsv.CSVReader;
import org.bson.BsonDocument;
import org.bson.Document;
import java.io.FileReader;
import java.util.List;

public class Main
{
    private static final String pathStudentsCsv = "src/main/resources/mongo.csv";

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

        MongoDatabase database = mongoClient.getDatabase("local");

        MongoCollection<Document> books = database.getCollection("books");
        books.drop();

        Document firstBook = new Document()
                .append("Name", "The Lord of the Rings")
                .append("Author", "J. R. R. Tolkien")
                .append("Year", 1954);

        Document secondBook = new Document()
                .append("Name", "The Shadow over Innsmouth")
                .append("Author", "Howard Phillips Lovecraft")
                .append("Year", 1931);

        Document thirdBook = new Document()
                .append("Name", "Herbert West – Reanimator")
                .append("Author", "Howard Phillips Lovecraft")
                .append("Year", 1921);

        Document fourthBook = new Document()
                .append("Name", "Metamorphosis")
                .append("Author", "Franz Kafka")
                .append("Year", 1915);

        Document fifthBook = new Document()
                .append("Name", "Fight Club")
                .append("Author", "Chuck Palahniuk")
                .append("Year", 1996);

        books.insertOne(firstBook);
        books.insertOne(secondBook);
        books.insertOne(thirdBook);
        books.insertOne(fourthBook);
        books.insertOne(fifthBook);

        //Самая старая книга
        BsonDocument query = BsonDocument.parse("{Year: 1}");
        books.find().sort(query).limit(1).forEach((Block<? super Document>) book -> System.out.println(book.get("Name")));

        //Две книги одного автора
        query = BsonDocument.parse("{Author: \"Howard Phillips Lovecraft\"}");
        books.find(query).forEach((Block<? super Document>) book -> System.out.println(book.get("Name")));

        System.out.println("***********************************************************");

        MongoCollection<Document> studentsDB = database.getCollection("students");
        studentsDB.drop();

        try (CSVReader csvReader = new CSVReader(new FileReader(pathStudentsCsv))) {
            List<String[]> lines = csvReader.readAll();
            for (String[] line : lines) {
                Document student = new Document();
                student.append("Name", line[0]);
                student.append("Age", Integer.parseInt(line[1]));
                student.append("Courses", line[2]);
                studentsDB.insertOne(student);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        //Количество студентов
        System.out.println(studentsDB.countDocuments());

        //Количество студентов старше 40 лет
        query = BsonDocument.parse("{Age: {$gt: 40}}");
        System.out.println(studentsDB.countDocuments(query));

        //Имя самого молодого студента
        query = BsonDocument.parse("{Age: 1}");
        studentsDB.find().sort(query).limit(1).forEach((Block<? super Document>) document -> System.out.println(document.get("Name")));

        //Список курсов самого старого студента
        query = BsonDocument.parse("{Age: -1}");
        studentsDB.find().sort(query).limit(1).forEach((Block<? super Document>) document -> System.out.println(document.get("Courses")));



    }




}
