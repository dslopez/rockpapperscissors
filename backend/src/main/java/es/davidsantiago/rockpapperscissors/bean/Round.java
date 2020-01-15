package es.davidsantiago.rockpapperscissors.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Round {

	public static final String PLAYER2_WINS = "Player2 wins";
	public static final String PLAYER1_WINS = "Player1 wins";
	public static final String DRAW = "DRAW";

	public enum Choise {
		ROCK, PAPPER, SCISSORS
	}

	private Choise player1Choise;
	private Choise player2Choise = Choise.ROCK;
	private String result;
	private Application application;

	public Round(Application application) {
		super();
		this.application = application;
	}

	public String calculateResult() {
		if (player1Choise.equals(player2Choise)) {
			application.setTotalDraws(application.getTotalDraws() + 1);
			return DRAW;
		}

		if (player1Choise.equals(Choise.PAPPER)) {
			application.setTotalWinsFirstPlayer(application.getTotalWinsFirstPlayer() + 1);
			return PLAYER1_WINS;
		}

		application.setTotalWinsSecondPlayer(application.getTotalWinsSecondPlayer() + 1);
		return PLAYER2_WINS;

	}

	public Choise getPlayer1Choise() {
		return player1Choise;
	}

	public void setPlayer1Choise(Choise player1Choise) {
		this.player1Choise = player1Choise;
	}

	public Choise getPlayer2Choise() {
		return player2Choise;
	}

	public void setPlayer2Choise(Choise player2Choise) {
		this.player2Choise = player2Choise;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
