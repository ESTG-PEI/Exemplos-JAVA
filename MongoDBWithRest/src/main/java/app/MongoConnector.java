package app;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.mongodb.client.model.Filters.eq;

public class MongoConnector {
    private MongoClient mongoClient;

    public MongoConnector(){
        //TODO: Parameterizar connection string
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    }

    /**
     *
     * @param databaseName
     * @param collectionName
     * @param field
     * @param value
     * @return
     */
    public String getData(String databaseName, String collectionName, String field, String value){
        MongoDatabase database = mongoClient.getDatabase(databaseName);//"restaurantsDB"
        MongoCollection<Document> collection = database.getCollection(collectionName);//"restaurants"
        Bson filter = eq(field, value);//borough, bronx

        //Print for testing
        //while(cursor.iterator().hasNext()) {
        //    System.out.println(cursor.iterator().next());
        //}
        return StreamSupport.stream(collection.find(filter).limit(10).spliterator(), false)
                .map(Document::toJson)
                .collect(Collectors.joining(", ", "[", "]")).toString();
    }

    public String aggregateDataByQueryString(String databaseName, String collectionName, String query){
        MongoDatabase database = mongoClient.getDatabase(databaseName);//"restaurantsDB"
        MongoCollection<Document> collection = database.getCollection(collectionName);//"restaurants"
        BasicDBObject q = BasicDBObject.parse(query);
        return StreamSupport.stream(collection.aggregate(Arrays.asList(q)).spliterator(), false)
                .map(Document::toJson)
                .collect(Collectors.joining(", ", "[", "]")).toString();
    }


}
