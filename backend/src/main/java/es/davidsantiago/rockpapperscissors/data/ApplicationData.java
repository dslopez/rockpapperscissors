package es.davidsantiago.rockpapperscissors.data;

import java.util.Collection;

import es.davidsantiago.rockpapperscissors.bean.Game;

public class ApplicationData {
	private Integer totalRoundsPlayed = 0;
	private Integer totalWinsFirstPlayer = 0;
	private Integer totalWinsSecondPlayer = 0;
	private Integer totalDraws = 0;
	private Collection<Game> games;

	public ApplicationData(Integer totalRoundsPlayed, Integer totalWinsFirstPlayer, Integer totalWinsSecondPlayer,
			Integer totalDraws, Collection<Game> games) {
		super();
		this.totalRoundsPlayed = totalRoundsPlayed;
		this.totalWinsFirstPlayer = totalWinsFirstPlayer;
		this.totalWinsSecondPlayer = totalWinsSecondPlayer;
		this.totalDraws = totalDraws;
		this.setGames(games);
	}
	
	public Integer getTotalRoundsPlayed() {
		return totalRoundsPlayed;
	}

	public void setTotalRoundsPlayed(Integer totalRoundsPlayed) {
		this.totalRoundsPlayed = totalRoundsPlayed;
	}

	public Integer getTotalWinsFirstPlayer() {
		return totalWinsFirstPlayer;
	}

	public void setTotalWinsFirstPlayer(Integer totalWinsFirstPlayer) {
		this.totalWinsFirstPlayer = totalWinsFirstPlayer;
	}

	public Integer getTotalWinsSecondPlayer() {
		return totalWinsSecondPlayer;
	}

	public void setTotalWinsSecondPlayer(Integer totalWinsSecondPlayer) {
		this.totalWinsSecondPlayer = totalWinsSecondPlayer;
	}

	public Integer getTotalDraws() {
		return totalDraws;
	}

	public void setTotalDraws(Integer totalDraws) {
		this.totalDraws = totalDraws;
	}
	
	public Collection<Game> getGames() {
		return games;
	}

	public void setGames(Collection<Game> games) {
		this.games = games;
	}

}
