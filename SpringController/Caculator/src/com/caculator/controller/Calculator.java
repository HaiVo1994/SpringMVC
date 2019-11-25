package com.caculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
    @GetMapping("/calculator")
    public String calculator(){
        return "index";
    }

    @PostMapping("/result")
    public String result (@RequestParam("firstNumber") int first,
                          @RequestParam("secondNumber") int second,
                          @RequestParam("action") String action,
                          Model model){
        double resultCalculator;
        switch (action){
            case "add":
                resultCalculator = first + second;
                break;
            case "sub":
                resultCalculator = first - second;
                break;
            case "multi":
                resultCalculator = first * second;
                break;
            case "divine":
                resultCalculator = (double) first / second;
                break;
            default:
                return "error";
        }

        model.addAttribute("result", resultCalculator);
        return "index";
    }
}
