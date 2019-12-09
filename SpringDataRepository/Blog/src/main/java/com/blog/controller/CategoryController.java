package com.blog.controller;

import com.blog.model.Category;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/category"})
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = {"/list","/"},method = RequestMethod.GET)
    public ModelAndView listCategory(Pageable pageable){
        Page<Category> categories = categoryService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public ModelAndView prepareEdit(@PathVariable Long id){
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("messenger", "Category edited");
        return modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView createCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("messenger", "Category Created");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @RequestMapping(value = "/remove/{id}",method = RequestMethod.GET)
    public ModelAndView checkRemove(@PathVariable("id") Long id){
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/category/delete");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public String remove(@ModelAttribute("category") Category category){
        categoryService.remove(category.getId());
        return "redirect:/category/list";
    }
}
