package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class Dictionary {
    public static final HashMap<String,String> dictionayBook = new HashMap<>();
    static {
        dictionayBook.put("hello", "Xin chao");
        dictionayBook.put("cook", "nau an");
    }
    @GetMapping("/Input")
    public String dicString(){
        return "transfer";
    }
    @PostMapping("/dictionary")
    public String dictionay(@RequestParam String word, Model model){
        model.addAttribute("dictionary", dictionayBook.get(word));
        return "transfer";
    }
}
