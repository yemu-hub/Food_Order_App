package com.example.tacocloud.repository;


import org.springframework.data.repository.CrudRepository;


import com.example.tacocloud.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>  {


}
