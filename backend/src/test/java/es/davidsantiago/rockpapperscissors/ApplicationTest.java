package es.davidsantiago.rockpapperscissors;

import org.junit.Test;

public class ApplicationTest {

	@Test
	public void checkApplicationCounters(){
		Application application = new Application();
		assert(application.getTotalRoundsPlayed().intValue() == 0);
		assert(application.getTotalWinsFirstPlayer().intValue() == 0);
		assert(application.getTotalWinsSecondPlayer().intValue() == 0);
		assert(application.getTotalDraws().intValue() == 0);
	}
}
