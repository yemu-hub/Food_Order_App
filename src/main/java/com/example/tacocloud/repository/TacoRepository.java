package com.example.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.tacocloud.model.Taco;

public interface TacoRepository extends  CrudRepository<Taco,Long> {
  
  
}
