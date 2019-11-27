package controller;

import Model.Table;
import Utils.TableDB;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloWorld {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/table")
    public ModelAndView table(){
        ModelAndView modelAndView = new ModelAndView("table");
        List<Table> tables = TableDB.findAll();
        modelAndView.addObject("table", tables.get(0).getLocal());
        return modelAndView;
    }
}
