package com.swayne.dojo_overflow.services;

import java.util.List;

import com.swayne.dojo_overflow.models.Answer;
import com.swayne.dojo_overflow.repositories.AnswerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepo answerRepo;

    public List<Answer> getAll(){
        return answerRepo.findAll();
    }

    public Answer getOne(Long id){
        return answerRepo.findById(id).orElse(null);
    }

    public Answer create(Answer answer){
        return answerRepo.save(answer);
    }

}
