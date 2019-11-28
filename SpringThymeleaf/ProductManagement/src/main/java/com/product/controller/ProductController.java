package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("/products")
    public ModelAndView list(){
        List<Product> products = this.productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createProduct(@ModelAttribute("product") Product product){
        int randomId = (int)(Math.random() * 10000);
        product.setId(randomId);//For demo purpose only

        this.productService.save(product);

        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product was created");
        return modelAndView;
    }

    @GetMapping(value = "{id}/view")
    public ModelAndView view(@PathVariable("id") Integer productId){
        Product product = this.productService.findById(productId);
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
}