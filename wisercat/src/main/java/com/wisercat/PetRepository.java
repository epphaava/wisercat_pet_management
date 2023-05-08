package com.wisercat;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
    @Query("select name from Pet p where p.name like %:name")
    String findByName(String name);
}
