// package com.example.tacocloud.repository;

// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.List;
// import java.util.Optional;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.stereotype.Repository;

// import com.example.tacocloud.model.Ingredient;

// @Repository
// public class JdbcIngredientRepository implements IngredientRepository {

//   private JdbcTemplate jdbc;

//   public JdbcIngredientRepository(JdbcTemplate jdbc) {
//     this.jdbc = jdbc;
//   }

//   @Override
//   public Iterable<Ingredient> findAll() {
//     return jdbc.query("select  id, name, type from Ingredient",
//         this::mapRowToIngredient);
//   }

//   @Override
//   public Optional<Ingredient> findById(String id) {
//     List<Ingredient> results = jdbc.query(
//         "select id, name, type from Ingredient where id=?",
//         this::mapRowToIngredient,
//         id);

//     return results.size() == 0 ? Optional.empty() : Optional.of(results.get(0));

//   }

//   private Ingredient mapRowToIngredient(ResultSet row, int rowNum)
//       throws SQLException {
//     return new Ingredient(
//           row.getString("id"),
//         row.getString("name"),
//         Ingredient.Type.valueOf(row.getString("type")));
//   }

//   @Override
//   public Ingredient save(Ingredient ingredient) {
//     jdbc.update(
//         "insert into Ingredient (id, name, type) values (?, ?, ?)",
//         ingredient.getId(),
//         ingredient.getName(),
//         ingredient.getType().toString());
//     return ingredient;

//   }

// }
