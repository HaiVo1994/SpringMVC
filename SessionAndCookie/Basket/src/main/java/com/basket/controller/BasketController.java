package com.basket.controller;

import com.basket.model.Basket;
import com.basket.model.Product;
import com.basket.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("ListBasket")
public class BasketController {
    @Autowired
    private BasketService basketService;
    @ModelAttribute("ListBasket")
    public List<Basket> setBasket(){
        return new ArrayList<Basket>();
    }

    @PostMapping("/put")
    public String put(@RequestParam("id") int id, @ModelAttribute("ListBasket") List<Basket> ListBasket){
        basketService.putProduct(ListBasket, id);
        return "redirect:products";
    }

    @GetMapping("/viewBasket")
    public ModelAndView view(){
        ModelAndView modelAndView = new ModelAndView("basket/viewBasket");
        return modelAndView;
    }

    @PostMapping("/change")
    public String change(@RequestParam("id") int id, @RequestParam("amount") int amount,
                         @ModelAttribute("ListBasket") List<Basket> ListBasket){
        basketService.changeAmount(ListBasket,id,amount);
        return "redirect:viewBasket";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("id") int id,
                         @ModelAttribute("ListBasket") List<Basket> ListBasket){
        basketService.removeProduct(ListBasket,id);
        return "redirect:viewBasket";
    }

    @PostMapping("/removeAll")
    public String removeAll(@ModelAttribute("ListBasket") List<Basket> ListBasket,
                            WebRequest request,
                            SessionStatus status){
        status.setComplete();
        request.removeAttribute("ListBasket", WebRequest.SCOPE_SESSION);
        return "redirect:viewBasket";
    }
}
