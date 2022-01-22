package com.swayne.dojo_overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.swayne.dojo_overflow.models.TQ;
import com.swayne.dojo_overflow.models.Tag;
import com.swayne.dojo_overflow.services.QuestionService;
import com.swayne.dojo_overflow.services.TQService;
import com.swayne.dojo_overflow.services.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TagController {
    @Autowired
    private TagService tagService;

    
    @Autowired
    private QuestionService questionService;

    @Autowired
    private TQService tqService;

    private  long num=0;


    @GetMapping("/index/tags/{id}")
    public String index_tags(@PathVariable("id") Long id, @ModelAttribute("tag") Tag tag, Model model){
        model.addAttribute("question", questionService.getOne(id));
        num++;
        model.addAttribute("num", Long.valueOf(num));
        return "/tag/tag_index.jsp";
    }

    @PostMapping("/tag_form/{id}")
    public String tag_form(@Valid @ModelAttribute("tag") Tag tag, BindingResult result,@PathVariable("id") Long id){
        if(result.hasErrors()){
            return "/question/index.jsp";
        }
        Tag fun_tag=new Tag();


        fun_tag=tagService.create(tag);
        String temp=String.valueOf(id);
        
        TQ new_tq= new TQ(fun_tag.getId(), fun_tag.getCreatedAt(), fun_tag.getUpdatedAt(), questionService.getOne(id), fun_tag);

        tqService.create(new_tq);
        return "redirect:/index/tags/"+temp;
    }
}
