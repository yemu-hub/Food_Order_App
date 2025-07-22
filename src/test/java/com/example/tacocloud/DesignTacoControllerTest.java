// package com.example.tacocloud;

// import static org.hamcrest.Matchers.containsString;
// import static 
// org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static 
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static 
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static 
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.ui.Model;

// import com.example.tacocloud.controller.DesignTacoController;

// @WebMvcTest(DesignTacoController.class)
// public class DesignTacoControllerTest {
  
//   @Autowired
//   private MockMvc mockMvc; 
  
//   @Test
//   public void showDesignForm() throws Exception {
//   mockMvc.perform(get("/design")) 
//   .andExpect(status().isOk()) 
//   .andExpect(view().name("design")) 
//   .andExpect(content().string( 
//   containsString("Design your taco!")));
//   }
// }
