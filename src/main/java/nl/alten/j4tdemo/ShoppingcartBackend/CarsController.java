package nl.alten.j4tdemo.ShoppingcartBackend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsController {


    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }

}
