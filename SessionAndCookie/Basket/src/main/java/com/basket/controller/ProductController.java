package com.basket.controller;

import com.basket.model.Basket;
import com.basket.model.Product;
import com.basket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping("/products")
    public ModelAndView list(){
        List<Product> products = this.productService.findAll();
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("product/view");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }
}
