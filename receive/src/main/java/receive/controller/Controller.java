package receive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String rootReceive() {
        return "receive";
    }

    @GetMapping("/get")
    public String rootGet() {
        return "通过http方法调通了receive模块的get";
    }

    @GetMapping("/receive")
    public String getByJSON() {
        return Tools.getRandomString(1000);
    }
}
