package app;
import java.util.concurrent.atomic.AtomicLong;
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

    @RequestMapping("/restaurants")
    public String getRestaurants(@RequestParam(value="name", defaultValue="World") String name) {
        return new String("getRestaurants");
    }
}