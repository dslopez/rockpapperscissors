package es.davidsantiago.rockpapperscissors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import es.davidsantiago.rockpapperscissors.Round.Choise;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Game {
	private List<Round> rounds;

	private Application application;

	public Game(Application application) {
		super();
		this.application = application;
	}

	public List<Round> getRounds() {
		if (rounds == null) {
			rounds = new ArrayList<Round>();
		}
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	public void playRound() {
		Round round = new Round(application);
		round.setPlayer1Choise(getRandomChoise());
		round.calculateResult();
		this.getRounds().add(round);
		application.setTotalRoundsPlayed(application.getTotalRoundsPlayed() + 1);
	}

	private Choise getRandomChoise() {
		int randomValue = getRandomNumberInRange(1, 3);
		Choise choise;

		switch (randomValue) {
		case 1:
			choise = Round.Choise.ROCK;
			break;

		case 2:
			choise = Round.Choise.PAPPER;
			break;

		case 3:
			choise = Round.Choise.SCISSORS;
			break;

		default:
			choise = Round.Choise.ROCK;
			break;
		}

		return choise;
	}

	private static int getRandomNumberInRange(int min, int max) {

		Random random = new Random();
		return random.ints(min, (max + 1)).limit(1).findFirst().getAsInt();

	}

	public void restart() {
		this.rounds = new ArrayList<Round>();
	}

}
