package es.davidsantiago.rockpapperscissors.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import es.davidsantiago.rockpapperscissors.bean.Application;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationController.class)
public class ApplicationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	Application application;

	@Before
	public void prepareData() {
		when(application.getTotalRoundsPlayed()).thenReturn(3);
		when(application.getTotalWinsFirstPlayer()).thenReturn(2);
		when(application.getTotalWinsSecondPlayer()).thenReturn(0);
		when(application.getTotalDraws()).thenReturn(1);
	}

	@Test
	public void getApplication() throws Exception {
		this.mockMvc.perform(get("/application").characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.totalRoundsPlayed", is(3)))
				.andExpect(jsonPath("$.totalWinsFirstPlayer", is(2)))
				.andExpect(jsonPath("$.totalWinsSecondPlayer", is(0))).andExpect(jsonPath("$.totalDraws", is(1)));

	}

}
