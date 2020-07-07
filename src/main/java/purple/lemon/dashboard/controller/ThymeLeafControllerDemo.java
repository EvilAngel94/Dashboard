package purple.lemon.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import thymeleaf.ThymeleafDemo;
import thymeleaf.ThymeleafDemoImpl;

/**
 * Demo purpose
 */
@Controller
public class ThymeLeafControllerDemo {

    private final ThymeleafDemo thymeleafDemo;

    public ThymeLeafControllerDemo() {
        this.thymeleafDemo = new ThymeleafDemoImpl();
    }

    @GetMapping("/")
    public String welcomeMessage(Model model) {

        thymeleafDemo.getGreetings(model);

        return "dashboard";
    }

}
