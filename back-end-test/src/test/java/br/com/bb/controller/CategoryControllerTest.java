package br.com.bb.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import br.com.bb.Application;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class CategoryControllerTest {

	@Autowired
    private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
    public void listAll() throws Exception {
        mockMvc.perform(get("/category/listAll"))
        .andExpect(status().isOk())
	    		.andExpect(jsonPath("$", hasSize(3)))
	        .andExpect(jsonPath("$[0].id", is(1)))
	        .andExpect(jsonPath("$[0].name", is("Alimentos")))
	        .andExpect(jsonPath("$[1].id", is(2)))
	        .andExpect(jsonPath("$[1].name", is("Eletrodomésticos")))
	        .andExpect(jsonPath("$[2].id", is(3)))
	        .andExpect(jsonPath("$[2].name", is("Móveis")));
    }
	
	@Test
	public void findByOccurrenceLetterA() throws Exception {
		mockMvc.perform(get("/category/findByNameContaining/a"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", is(1)))
		.andExpect(jsonPath("$.name", is("Alimentos")));
	}
	
	@Test
	public void findByOccurrenceLetterO() throws Exception {
		mockMvc.perform(get("/category/findByNameContaining/o"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", is(2)))
		.andExpect(jsonPath("$.name", is("Eletrodomésticos")));
	}
	
	@Test
	public void findByOccurrenceLetterV() throws Exception {
		mockMvc.perform(get("/category/findByNameContaining/v"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", is(3)))
		.andExpect(jsonPath("$.name", is("Móveis")));
	}
	
	@Test
	public void findByOccurrenceLetterÇNotFound() throws Exception {
		mockMvc.perform(get("/category/findByNameContaining/ç"))
		.andExpect(status().isNotFound());
	}
}