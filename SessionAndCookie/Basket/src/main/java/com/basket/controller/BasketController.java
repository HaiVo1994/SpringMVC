package com.basket.controller;

import com.basket.model.Basket;
import com.basket.model.Product;
import com.basket.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
//@SessionAttributes("ListBasket")
public class BasketController {
    @Autowired
    private BasketService basketService;
//    @ModelAttribute("ListBasket")
//    public List<Basket> setBasket(){
//        return new ArrayList<Basket>();
//    }

    @PostMapping(value = "/put", produces = MediaType.TEXT_PLAIN_VALUE)
//    public String put(@RequestParam("id") int id, @ModelAttribute("ListBasket") List<Basket> ListBasket){
//        basketService.putProduct(ListBasket, id);
//        return "redirect:products";
//    }
    public String put(HttpSession httpSession, @RequestParam("id") int id){
        List<Basket> ListBasket;
        if(httpSession.getAttribute("ListBasket")!=null){
            ListBasket = (List<Basket>) httpSession.getAttribute("ListBasket");
        }
        else{
            ListBasket = new ArrayList<Basket>();
        }
        basketService.putProduct(ListBasket, id);
        httpSession.setAttribute("ListBasket", ListBasket);
        return "redirect:products";
    }

    @GetMapping("/viewBasket")
    public ModelAndView view(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("basket/viewBasket");
        List<Basket> ListBasket = (List<Basket>) httpSession.getAttribute("ListBasket");
        modelAndView.addObject("ListBasket", ListBasket);
        return modelAndView;
    }

//    @PostMapping("/change")
//    public String change(@RequestParam("id") int id, @RequestParam("amount") int amount,
//                         @ModelAttribute("ListBasket") List<Basket> ListBasket){
//        basketService.changeAmount(ListBasket,id,amount);
//        return "redirect:viewBasket";
//    }

    @PostMapping("/change")
    public String change(@RequestParam("id") int id, @RequestParam("amount") int amount,
                         HttpSession httpSession){
        List<Basket> ListBasket = (List<Basket>) httpSession.getAttribute("ListBasket");
        basketService.changeAmount(ListBasket,id,amount);
        httpSession.setAttribute("ListBasket", ListBasket);
        return "redirect:viewBasket";
    }

//    @PostMapping("/remove")
//    public String remove(@RequestParam("id") int id,
//                         @ModelAttribute("ListBasket") List<Basket> ListBasket){
//        basketService.removeProduct(ListBasket,id);
//        return "redirect:viewBasket";
//    }

    @PostMapping("/remove")
    public String remove(@RequestParam("id") int id,
                         HttpSession httpSession){
        List<Basket> ListBasket = (List<Basket>) httpSession.getAttribute("ListBasket");
        basketService.removeProduct(ListBasket,id);
        httpSession.setAttribute("ListBasket", ListBasket);
        return "redirect:viewBasket";
    }

//    @PostMapping("/removeAll")
//    public String removeAll(@ModelAttribute("ListBasket") List<Basket> ListBasket,
//                            WebRequest request,
//                            SessionStatus status){
//        status.setComplete();
//        request.removeAttribute("ListBasket", WebRequest.SCOPE_SESSION);
//        return "redirect:viewBasket";
//    }
    @PostMapping("/removeAll")
    public String removeAll(HttpSession httpSession){
        httpSession.removeAttribute("ListBasket");
        return "redirect:viewBasket";
    }
}
