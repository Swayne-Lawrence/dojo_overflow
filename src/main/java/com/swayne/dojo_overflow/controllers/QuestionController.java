package com.swayne.dojo_overflow.controllers;

import javax.validation.Valid;

import com.swayne.dojo_overflow.models.Question;
import com.swayne.dojo_overflow.models.Tag;
import com.swayne.dojo_overflow.services.QuestionService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {
    @Autowired 
    private QuestionService questionService;

    @GetMapping("/")
    public String index(@ModelAttribute("quest") Question quest,@ModelAttribute("tag") Tag tag){
        return "/question/index.jsp";
    }

    @PostMapping("/form")
    public String form(@Valid @ModelAttribute("quest")Question quest, BindingResult result){
        if(result.hasErrors()){
            return "/question/index.jsp";
        }

        Question que=questionService.create(quest);
        String id= String.valueOf(que.getId());
        return "redirect:/index/tags/"+id;
    }

    @GetMapping("/question_show")
    public String question_show(Model model){
        model.addAttribute("questions", questionService.getAll());
        return "/question/question_show.jsp";
    }
}
