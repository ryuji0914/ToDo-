package com.example.demo.mvc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends CrudRepository<ToDo,Long>{
	

}
