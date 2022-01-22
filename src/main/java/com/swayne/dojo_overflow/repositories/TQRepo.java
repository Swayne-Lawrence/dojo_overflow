package com.swayne.dojo_overflow.repositories;

import com.swayne.dojo_overflow.models.TQ;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TQRepo extends CrudRepository<TQ,Long> {

}
