package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Season {
    @GetMapping("/season")
    public String season(){
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model){
        StringBuilder result= new StringBuilder();
        for (String check:condiment){
            result.append(check).append(", ");
        }
        model.addAttribute("result", result.toString());
        return "show";
    }
}
