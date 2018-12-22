import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.net.UnknownHostException;

import static com.mongodb.client.model.Filters.eq;

/**
 * Getting Started with MongoDB and Java: Example retrieved from: https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-i
 * and https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-ii?_ga=2.191912748.705668828.1543921926-1268230906.1530109789
 * Run the example using: gradle run
 */
public class Demo {
    public static void main(String args[]) {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoDatabase database = mongoClient.getDatabase("restaurantsDB");
        MongoCollection<Document> collection = database.getCollection("restaurants");
        Bson filter = eq("borough", "Bronx");
        FindIterable<Document> cursor = collection.find(filter).limit(2);
        MongoCursor it = cursor.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
