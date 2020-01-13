package es.davidsantiago.rockpapperscissors;

import org.junit.Test;

import es.davidsantiago.rockpapperscissors.Round.Choise;

public class RoundTest {

	Round round = new Round();

	@Test
	public void player1WinsTest() {
		round.setPlayer1Choise(Choise.PAPPER);
		assert(round.calculateResult().equals("Player1 wins"));
	}
	
	@Test
	public void player2WinsTest() {
		round.setPlayer1Choise(Choise.SCISSORS);
		assert(round.calculateResult().equals("Player2 wins"));
	}
	
	@Test
	public void drawTest() {
		round.setPlayer1Choise(Choise.ROCK);
		assert(round.calculateResult().equals("DRAW"));
	}
}
