package com.swayne.dojo_overflow.controllers;

import javax.validation.Valid;

import com.swayne.dojo_overflow.models.Answer;
import com.swayne.dojo_overflow.services.AnswerService;
import com.swayne.dojo_overflow.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    private long num=0;

    @GetMapping("/answers/{id}")
    public String answers(@ModelAttribute("ans") Answer ans, Model model,@PathVariable("id") Long id){
        model.addAttribute("question", questionService.getOne(id));
        num++;
        model.addAttribute("num", Long.valueOf(num));
        return "/answer/answer.jsp";
    }

    @PostMapping("/answer_form/{id}")
    public String answer_form(@Valid @ModelAttribute("ans") Answer ans,BindingResult result,@PathVariable("id") Long id ){
        if(result.hasErrors()){
            return "/answer/answer.jsp";
        }
        answerService.create(ans);
        String temp=String.valueOf(id);
        return "redirect:/answers/"+temp;
        
    }
}
