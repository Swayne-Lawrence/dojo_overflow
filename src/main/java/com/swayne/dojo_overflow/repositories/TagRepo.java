package com.swayne.dojo_overflow.repositories;

import java.util.List;

import com.swayne.dojo_overflow.models.Tag;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends CrudRepository<Tag,Long>{

    List<Tag> findAll();
}
