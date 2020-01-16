package es.davidsantiago.rockpapperscissors.beans;

import org.junit.Test;

import es.davidsantiago.rockpapperscissors.bean.Application;
import es.davidsantiago.rockpapperscissors.bean.Game;
import es.davidsantiago.rockpapperscissors.bean.Round;

public class GameTest {
	private Application application = new Application();
	private Game game = new Game(application);

	@Test
	public void createNewGame() {
		String key = Game.KEY_PREFIX + "1";
		assert (key.equals(game.getId()));
		assert (application.getGamesMap().get(key).equals(game));
	}

	@Test
	public void playRound() {
		assert (game.getRounds() != null);
		assert (game.getRounds().isEmpty());

		game.playRound();

		assert (game.getRounds().size() == 1);
		assert (game.getRounds().get(0).getPlayer1Choise() != null);
		assert (application.getTotalRoundsPlayed() == 1);
	}

	@Test
	public void restartGame() {
		game.getRounds().add(new Round(new Application()));
		game.restart();
		assert (game.getRounds().isEmpty());
	}
}
