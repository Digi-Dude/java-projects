package shop.controller;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.BsonField;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Manager
{
    private MongoCollection<Document> shops;
    private MongoCollection<Document> items;

    public void mongoInit()
    {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("Market");
        shops = database.getCollection("Shops");
        //shops.drop();
        items = database.getCollection("Items");
        //items.drop();
    }
    public void addShop(String name)
    {
        shops.insertOne(createShop(name));

    }

    public void addItem(String name, int price)
    {
        items.insertOne(createItem(name, price));
    }

    public void insertItem(String itemName, String shopName)
    {
        String queryString ="{Name: \"" + shopName + "\"}";
        BsonDocument query = BsonDocument.parse(queryString);

        queryString ="{Name: \"" + itemName + "\"}";
        BsonDocument itemQuery = BsonDocument.parse(queryString);

        queryString = "{$set: {items: " + items.find(itemQuery).first().toJson()  + "}}";
        BsonDocument queryForUpdate = BsonDocument.parse(queryString);

        shops.updateOne(query, queryForUpdate);

    }

    public String report() {
        String message = "";
        message += "Общее количество наименований товаров: " + items.countDocuments() + "\n";

        AggregateIterable<org.bson.Document> aggregate = items.aggregate(Arrays.asList(Aggregates.group("_id", new BsonField(
                "averagePrice", new BsonDocument(
                        "$avg", new BsonString("$Price"))))));
        Document result = aggregate.first();
        message += "Средняя цена товаров: " + result.get("averagePrice") + "\n";

        aggregate = items.aggregate(Arrays.asList(Aggregates.group("_id", new BsonField(
                "maxPrice", new BsonDocument(
                "$max", new BsonString("$Price"))))));
        result = aggregate.first();
        message += "Самый дорогой товар: " + result.get("maxPrice") + "\n";

        aggregate = items.aggregate(Arrays.asList(Aggregates.group("_id", new BsonField(
                "minPrice", new BsonDocument(
                "$min", new BsonString("$Price"))))));
        result = aggregate.first();
        message += "Самый дешевый товар: " + result.get("minPrice") + "\n";

        BsonDocument query = BsonDocument.parse("{Price :{$lt: 100}}");
        message += "Количество товаров меньше 100 рублей: " + items.countDocuments(query) + "\n";

        return message;
    }

    private Document createShop(String name) {
        return new Document()
                .append("Name", name)
                .append("Items", "");
    }

    private Document createItem(String name, int price) {
        return new Document()
                .append("Name", name)
                .append("Price", price);
    }

}
