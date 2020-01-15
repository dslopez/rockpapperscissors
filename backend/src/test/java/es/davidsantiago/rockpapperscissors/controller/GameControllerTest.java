package es.davidsantiago.rockpapperscissors.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import es.davidsantiago.rockpapperscissors.bean.Application;
import es.davidsantiago.rockpapperscissors.bean.Game;
import es.davidsantiago.rockpapperscissors.bean.Round;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	Application application;

	@Test
	public void getGameReturnJsonArray() throws Exception {
		Game game = new Game(application);
		Round round = new Round(application);
		round.setPlayer1Choise(Round.Choise.PAPPER);

		List<Round> rounds = Arrays.asList(round);
		game.setRounds(rounds);

		HashMap<String, Game> gamesMap = new HashMap<>();
		gamesMap.put("game1", game);

		when(application.getGamesMap()).thenReturn(gamesMap);

		this.mockMvc
				.perform(get("/game").param("id", "1").characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.actualRound", is(rounds.size() + 1)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.rounds").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.rounds[*].result").isNotEmpty());

	}

}
