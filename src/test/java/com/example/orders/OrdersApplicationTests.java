package com.example.orders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class OrdersApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldCheckTestOrder() throws Exception {
		this.mockMvc
			.perform(get("/orders"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("TEST")));
	}

	@Test
	public void shouldAddOrder() throws Exception {

		Order testOrder = new Order();
		testOrder.setDescription("test2");

		this.mockMvc
			.perform(post("/orders")
			.contentType(MediaType.APPLICATION_JSON).content(asJsonString(testOrder))
        	.accept(MediaType.APPLICATION_JSON))
      		.andExpect(status().isCreated())
			.andDo(print())
      		.andExpect(MockMvcResultMatchers.jsonPath("$.description").value("test2"))
      		.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("IN_PROGRESS"));
	}

	public static String asJsonString(final Object obj) {
		try {
		  return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
		  throw new RuntimeException(e);
		}
	}
}
