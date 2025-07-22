package com.example.tacocloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.model.Ingredient.Type;
import com.example.tacocloud.repository.IngredientRepository;

@SpringBootApplication
public class TacoCloudApplication  {
	

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner dataLoader(IngredientRepository repo) {
	// return args -> {
	// repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
	// repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
	// repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
	// repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
	// repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
	// repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
	// repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
	// repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
	// repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
	// repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
	// };
	// }

	

}
