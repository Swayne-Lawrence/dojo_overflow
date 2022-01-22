package com.swayne.dojo_overflow.repositories;

import java.util.List;

import com.swayne.dojo_overflow.models.Question;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends CrudRepository<Question,Long>{

    List<Question> findAll();
}
