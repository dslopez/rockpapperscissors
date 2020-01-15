package es.davidsantiago.rockpapperscissors;

import org.junit.Test;

public class GameTest {
	private Application application = new Application();
	private Game game = new Game(application);

	@Test
	public void playRoundTest() {
		assert (game.getRounds() != null);
		assert (game.getRounds().isEmpty());

		game.playRound();

		assert (game.getRounds().size() == 1);
		assert (game.getRounds().get(0).getPlayer1Choise() != null);
		assert (application.getTotalRoundsPlayed() == 1);
	}

	@Test
	public void restartGameTest() {
		game.getRounds().add(new Round(new Application()));
		game.restart();
		assert (game.getRounds().isEmpty());
	}
}
