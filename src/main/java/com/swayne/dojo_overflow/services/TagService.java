package com.swayne.dojo_overflow.services;

import java.util.List;

import com.swayne.dojo_overflow.models.Tag;
import com.swayne.dojo_overflow.repositories.TagRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagRepo tagRepo;

    public List<Tag> getAll(){
        return tagRepo.findAll();
    }

    public Tag getOne(Long id){
        return tagRepo.findById(id).orElse(null);
    }

    public Tag create(Tag tag){
        return tagRepo.save(tag);
    }

}
