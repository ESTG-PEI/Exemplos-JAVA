package app;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Building a RESTful Web Service retrieved from: https://spring.io/guides/gs/rest-service/#scratch
 * https://spring.io/guides/gs/rest-service/#scratch
 * Additionally see: https://spring.io/guides/gs/accessing-mongodb-data-rest/
 */
@RestController
public class RestaurantController {

    @RequestMapping("/getRestaurants")
    public String getRestaurants(@RequestParam(value="value") String value) {
        MongoConnector mongo = new MongoConnector();
        String res = mongo.getData("restaurantsDB", "restaurants", "borough", value);
        return res;
    }

    @RequestMapping("/aggregateRestaurantsByQueryString")
    public String aggregateRestaurantsByQueryString(@RequestParam(value="query") String query) {
        //Example: %7B%24group%3A%7B%22_id%22%3Anull%2Ccount%3A%7B%24sum%3A1%7D%7D%7D para {$group:{"_id":null,count:{$sum:1}}} -> utilizar: https://meyerweb.com/eric/tools/dencoder/
        MongoConnector mongo = new MongoConnector();
        String res = mongo.aggregateDataByQueryString("restaurantsDB", "restaurants", query);
        return res;
    }
}