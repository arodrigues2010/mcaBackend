package com.mca.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@WebAppConfiguration
class SagaControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	private static String URL = "/game/{gameId}/saga";
	
	@BeforeEach
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	void testInput9() throws Exception {
		// mockMvc.perform(get(URL, 9)).andExpect(status().is(HttpStatus.OK.value()))
		// 		.andExpect(jsonPath("$.id", is("11"))).andExpect(jsonPath("$.title", is("Relic Hunter: Curse of the Emerald Eye")))
		// 		.andExpect(jsonPath("$.[0].price", is(39.99))).andExpect(jsonPath("$.[0].availability", is(false)))
		// 		.andExpect(jsonPath("$.[1].id", is("15"))).andExpect(jsonPath("$.[1].title", is("Cosmic Empires: Twilight of the Overlords")))
		// 		.andExpect(jsonPath("$.[1].price", is(49.99))).andExpect(jsonPath("$.[1].availability", is(true)))
		// 		.andExpect(jsonPath("$.[2].id", is("19"))).andExpect(jsonPath("$.[2].title", is("Arcane Realms Online: Siege of the Sorcerer")))
		// 		.andExpect(jsonPath("$.[2].price", is(29.99))).andExpect(jsonPath("$.[2].availability", is(true)))
		// 		.andReturn().getResponse().getContentAsString();

			// mockMvc.perform(get(URL, 11)).andExpect(status().is(HttpStatus.OK.value()))
            //     .andExpect(status().isOk())
            //     .andExpect(jsonPath("$.id", is(11)))
            //     .andExpect(jsonPath("$.title", is("Relic Hunter: Curse of the Emerald Eye")))
            //     .andReturn().getResponse().getContentAsString();

        // Realizar la solicitud GET y verificar la respuesta
        mockMvc.perform(get(URL, 11))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.id").value(11))
                .andExpect(jsonPath("$.title").value("Relic Hunter: Curse of the Emerald Eye"))
                .andExpect(jsonPath("$.promotions[0].id").value(11))
                .andExpect(jsonPath("$.promotions[0].validFrom").value("2023-10-05T22:47:45.356"))
                .andExpect(jsonPath("$.promotions[0].price").value(39.99))
                .andExpect(jsonPath("$.promotions[1].id").value(31))
                .andExpect(jsonPath("$.promotions[1].validFrom").value("2022-06-20T16:45:00"))
                .andExpect(jsonPath("$.promotions[1].price").value(39.99))
				.andReturn().getResponse().getContentAsString();
    }
	

	// @Test
	// void testInput12() throws Exception {
	// 	System.out.println(mockMvc.perform(get(URL, 12)).andReturn().getResponse().getContentAsString());
	// 	mockMvc.perform(get(URL, 12)).andExpect(status().is(HttpStatus.OK.value()))
	// 			.andExpect(jsonPath("$.[0].id", is("20"))).andExpect(jsonPath("$.[0].title", is("Wasteland Chronicles: Edge of Survival")))
	// 			.andExpect(jsonPath("$.[0].price", is(24.99))).andExpect(jsonPath("$.[0].availability", is(false)))
	// 			.andExpect(jsonPath("$.[1].id", is("18"))).andExpect(jsonPath("$.[1].title", is("Eternal Battlefront: Rise of the Phoenix")))
	// 			.andExpect(jsonPath("$.[1].price", is(59.99))).andExpect(jsonPath("$.[1].availability", is(true)))
	// 			.andExpect(jsonPath("$.[2].id", is("19"))).andExpect(jsonPath("$.[2].title", is("Arcane Realms Online: Siege of the Sorcerer")))
	// 			.andExpect(jsonPath("$.[2].price", is(29.99))).andExpect(jsonPath("$.[2].availability", is(true)))
	// 			.andReturn().getResponse().getContentAsString();
	// }

}