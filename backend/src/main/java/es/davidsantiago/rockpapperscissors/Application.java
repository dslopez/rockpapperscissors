package es.davidsantiago.rockpapperscissors;

public class Application {

	private Integer totalRoundsPlayed = 0;
	private Integer totalWinsFirstPlayer = 0;
	private Integer totalWinsSecondPlayer = 0;
	private Integer totalDraws = 0;

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
}
