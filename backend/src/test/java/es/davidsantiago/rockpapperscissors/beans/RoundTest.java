package es.davidsantiago.rockpapperscissors.beans;

import org.junit.Test;

import es.davidsantiago.rockpapperscissors.bean.Application;
import es.davidsantiago.rockpapperscissors.bean.Round;
import es.davidsantiago.rockpapperscissors.bean.Round.Choise;

public class RoundTest {

	private Application application = new Application();
	Round round = new Round(application);

	@Test
	public void player1Wins() {
		round.setPlayer1Choise(Choise.PAPPER);
		assert (round.calculateResult().equals(Round.PLAYER1_WINS));
		assert (application.getTotalWinsFirstPlayer() == 1);
	}

	@Test
	public void player2Wins() {
		round.setPlayer1Choise(Choise.SCISSORS);
		assert (round.calculateResult().equals(Round.PLAYER2_WINS));
		assert (application.getTotalWinsSecondPlayer() == 1);
	}

	@Test
	public void draw() {
		round.setPlayer1Choise(Choise.ROCK);
		assert (round.calculateResult().equals(Round.DRAW));
		assert (application.getTotalDraws() == 1);
	}
}
