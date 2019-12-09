package com.blog.controller;

import com.blog.model.Category;
import com.blog.model.Writing;
import com.blog.service.CategoryService;
import com.blog.service.WritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping(value = {"/writing","/"})
public class WrittingController {
    @Autowired
    private WritingService writingService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.finAllNoSort();
    }

    //GetMapping(value = {"/list","/"})
    @RequestMapping(value = {"/list","/"},method = RequestMethod.GET)
    public ModelAndView list(Pageable pageable){
        Page<Writing> writings = writingService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/writing/list");
        modelAndView.addObject("list", writings);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/writing/create");
        modelAndView.addObject("writing", new Writing());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createWriting(@ModelAttribute("writing") Writing writing){
        writing.setTime(new Date());
        writingService.save(writing);
        ModelAndView modelAndView = new ModelAndView("/writing/create");
        modelAndView.addObject("writing", new Writing());
        modelAndView.addObject("message", "New writing created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        Writing writing = writingService.findById(id);
        ModelAndView modelAndView = new ModelAndView("writing/edit");
        modelAndView.addObject("writing",writing);
        return modelAndView;
    }
    @PostMapping("edit")
    public String editWring(@ModelAttribute("writing") Writing writing){
        writingService.save(writing);
        return "redirect:/writing/list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") Long id){
        Writing writing = writingService.findById(id);
        ModelAndView modelAndView = new ModelAndView("writing/view");
        modelAndView.addObject("writing",writing);
        return modelAndView;
    }

}
