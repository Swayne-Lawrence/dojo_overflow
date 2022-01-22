package com.swayne.dojo_overflow.services;

import com.swayne.dojo_overflow.models.TQ;
import com.swayne.dojo_overflow.repositories.TQRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TQService {

    @Autowired
    private TQRepo tqRepo;

    public TQ create(TQ tq){
        return tqRepo.save(tq);
    }

}
