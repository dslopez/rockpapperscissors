package es.davidsantiago.rockpapperscissors;

import org.junit.Test;

import es.davidsantiago.rockpapperscissors.Round.Choise;

public class RoundTest {

	private Application application = new Application();
	Round round = new Round(application);

	@Test
	public void player1WinsTest() {
		round.setPlayer1Choise(Choise.PAPPER);
		assert (round.calculateResult().equals(Round.PLAYER1_WINS));
		assert (application.getTotalWinsFirstPlayer() == 1);
	}

	@Test
	public void player2WinsTest() {
		round.setPlayer1Choise(Choise.SCISSORS);
		assert (round.calculateResult().equals(Round.PLAYER2_WINS));
		assert (application.getTotalWinsSecondPlayer() == 1);
	}

	@Test
	public void drawTest() {
		round.setPlayer1Choise(Choise.ROCK);
		assert (round.calculateResult().equals(Round.DRAW));
		assert (application.getTotalDraws() == 1);
	}
}
