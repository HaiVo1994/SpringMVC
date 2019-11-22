package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam String name,@RequestParam int test, Model model){
        model.addAttribute("name", name);
        model.addAttribute("test_1", test);
        return "index";
    }
}
