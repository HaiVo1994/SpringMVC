package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Transfer {
    @PostMapping("/transfer-money")
    public String transferMoney(@RequestParam int money, Model model){
        double result = (double) money/20000;
        model.addAttribute("result", result);
        model.addAttribute("input", money);
        return "Transfer";
    }
}
