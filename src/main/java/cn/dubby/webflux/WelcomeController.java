package cn.dubby.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by teeyoung on 17/9/22.
 */
@RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "Hello World";
    }

}
