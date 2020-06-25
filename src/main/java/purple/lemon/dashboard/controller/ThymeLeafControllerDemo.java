package purple.lemon.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import thymeleaf.ThymeleafDemo;
import thymeleaf.ThymeleafDemoImpl;

@Controller
public class ThymeLeafControllerDemo {

    private final ThymeleafDemo thymeleafDemo;

    public ThymeLeafControllerDemo() {
        this.thymeleafDemo = new ThymeleafDemoImpl();
    }

    @GetMapping("/hello")
    public String sayHello(Model model) {

        thymeleafDemo.getGreetings(model);

        return "helloWorld";
    }

}
