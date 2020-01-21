package es.davidsantiago.rockpapperscissors.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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

	@Before
	public void initializeGame() {
		Game game = new Game(application);
		HashMap<String, Game> gamesMap = new HashMap<>();
		gamesMap.put("game1", game);

		when(application.getGamesMap()).thenReturn(gamesMap);
		
		Round round = new Round(application);
		round.setPlayer1Choise(Round.Choise.PAPPER);

		game.getRounds().add(round);
	}
	
	@Test
	public void getGame() throws Exception {
		this.mockMvc
				.perform(get("/game").param("id", "1").characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.roundsPlayed", is(1)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.rounds").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.rounds[*].result").isNotEmpty());

	}

	@Test
	public void createNewGame() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/game")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(Game.KEY_PREFIX + "2"));
	}
	
	@Test
	public void playRound() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .put("/game/{id}/playRound", 1)
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON)).andDo(print())
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.rounds[1].player1Choise").isNotEmpty())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.rounds[1].player2Choise").value("ROCK"))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.rounds[1].result").isNotEmpty());
	}
	
	@Test
	public void restartGame() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .put("/game/{id}/restart", 1)
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON)).andDo(print())
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.rounds").isEmpty());
	}
}
