package de.vobasolutions.gablerlog.controller;

import com.sun.faces.action.RequestMapping;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    @RequestMapping("/")
    String home() {
        return "home";
    }
}
