package com.example.tacocloud.controller;

import java.util.ArrayList;
// import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
// import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.model.Taco;
import com.example.tacocloud.repository.IngredientRepository;
import com.example.tacocloud.repository.TacoRepository;

// import jakarta.validation.Valid;

import com.example.tacocloud.model.Ingredient.Type;
import com.example.tacocloud.model.Order;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
  private final IngredientRepository ingredientRepo;
  private TacoRepository designRepo;

  public DesignTacoController(
      IngredientRepository ingredientRepo,
      TacoRepository designRepo) {
    this.ingredientRepo = ingredientRepo;
    this.designRepo = designRepo;
  }

  @ModelAttribute(name = "order")
  public Order order() {
    return new Order();
  }

  @ModelAttribute(name = "taco")
  public Taco taco() {
    return new Taco();
  }

  @GetMapping
  public String showDesignForm(Model model) {
    // in-memory data store
    // List<Ingredient> ingredients = Arrays.asList(
    // new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
    // new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
    // new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
    // new Ingredient("CARN", "Carnitas", Type.PROTEIN),
    // new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
    // new Ingredient("LETC", "Lettuce", Type.VEGGIES),
    // new Ingredient("CHED", "Cheddar", Type.CHEESE),
    // new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
    // new Ingredient("SLSA", "Salsa", Type.SAUCE),
    // new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

    // using database
    List<Ingredient> ingredients = new ArrayList<>();
    ingredientRepo.findAll().forEach(i -> ingredients.add(i));
    Type[] types = Ingredient.Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(),
          filterByType(ingredients, type));
    }
    model.addAttribute("design", new Taco());
    return "design";
  }

  @PostMapping
  public String processDesign(Taco design, Errors errors,
      @ModelAttribute Order order) {
    if (errors.hasErrors()) {
      return "design";
    }

    // Save the taco design...
    // We'll do this in chapter 3
    // log.info("Processing design: " + design);

    Taco saved = designRepo.save(design);
    order.addDesign(saved);

    return "redirect:/orders/current";
  }

  private List<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {
    return ((Collection<Ingredient>) ingredients).stream()
        .filter(x -> x.getType().equals(type))
        .collect(Collectors.toList());
  }

}
