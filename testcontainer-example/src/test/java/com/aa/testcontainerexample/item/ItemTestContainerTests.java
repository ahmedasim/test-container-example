package com.aa.testcontainerexample.item;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.aa.testcontainerexample.dto.inventoryservice.request.InventoryItemRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Slf4j
@Testcontainers
class ItemTestContainerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Container
	private static final MySQLContainer<?> MY_SQL_CONTAINER = new MySQLContainer<>("mysql:latest");
 
	static void dynamicConfig(DynamicPropertyRegistry reg) {
		reg.add("spring.datasource.url", MY_SQL_CONTAINER::getJdbcUrl);
		reg.add("spring.datasource.username", MY_SQL_CONTAINER::getUsername);
		reg.add("spring.datasource.password", MY_SQL_CONTAINER::getPassword);
	}
	
	
	@Test
	void testFindAll() {
		try {
			mockMvc.perform(MockMvcRequestBuilders
					.get("/api/v1/item")
					.contentType("application/json")
					.accept("application/json")).andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Test
	void testSaveItem() {
		try {
			InventoryItemRequestDto reqDto = InventoryItemRequestDto.builder().itemCode("Test-09").itemName("Test-09").categoryId(1l).statusId(1).cost(BigDecimal.TEN).build();
			mockMvc.perform(MockMvcRequestBuilders
					.post("/api/v1/item")
					.contentType("application/json")
					.content(objectMapper.writeValueAsString(reqDto))
					.accept("application/json")).andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$.response.itemId").exists());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	
	@Test
	void testFindById() {
		try {
			mockMvc.perform(MockMvcRequestBuilders
					.get("/api/v1/item/2")
					.contentType("application/json")
					.accept("application/json")).andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$.response.itemId").exists());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
}
