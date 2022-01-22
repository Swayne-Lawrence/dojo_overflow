package com.swayne.dojo_overflow.repositories;

import java.util.List;

import com.swayne.dojo_overflow.models.Answer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Long> {

    List<Answer> findAll();
}
