import com.mongodb.*;

/**
 * Getting Started with MongoDB and Java: Example retrieved from: https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-i
 * and https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-ii?_ga=2.191912748.705668828.1543921926-1268230906.1530109789
 * Run the example using: gradle run
 */
public class Demo {
    public static void main(String args[]) throws java.net.UnknownHostException {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        DB database = mongoClient.getDB("restaurantsDB");
        DBCollection collection = database.getCollection("restaurants");
        DBObject query = new BasicDBObject("borough", "Bronx");
        DBCursor cursor = collection.find(query);
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
}
