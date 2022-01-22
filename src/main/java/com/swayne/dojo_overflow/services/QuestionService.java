package com.swayne.dojo_overflow.services;

import java.util.List;

import com.swayne.dojo_overflow.models.Question;
import com.swayne.dojo_overflow.repositories.QuestionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    public List<Question> getAll(){
        return questionRepo.findAll();
    }

    public Question getOne(Long id){
        return questionRepo.findById(id).orElse(null);
    }

    public Question create(Question question){
        return questionRepo.save(question);
    }

}
