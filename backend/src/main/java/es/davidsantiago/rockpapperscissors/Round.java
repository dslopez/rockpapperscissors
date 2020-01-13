package es.davidsantiago.rockpapperscissors;

import org.springframework.context.annotation.Scope;

@Scope(value="prototype")
public class Round {
	
	public enum Choise{
		ROCK,
		PAPPER,
		SCISSORS
	}

	private Choise player1Choise;
	private Choise player2Choise = Choise.ROCK;
	
	public String calculateResult(){
		if(player1Choise.equals(player2Choise)){
			return "DRAW";
		}
		
		if(player1Choise.equals(Choise.PAPPER)){
			return "Player1 wins";
		}
		
		return "Player2 wins";
		
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
	
}
