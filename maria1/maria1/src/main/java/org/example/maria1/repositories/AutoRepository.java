package org.example.maria1.repositories;


import org.example.maria1.model.Auto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends CrudRepository<Auto, Long> {


}
