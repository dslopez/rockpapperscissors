package es.davidsantiago.rockpapperscissors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.davidsantiago.rockpapperscissors.bean.Application;
import es.davidsantiago.rockpapperscissors.data.ApplicationData;

@RestController
public class ApplicationController {
	@Autowired
	Application application;

	@RequestMapping("/application")
	public ApplicationData getApplication() {
		return new ApplicationData(application.getTotalRoundsPlayed(), application.getTotalWinsFirstPlayer(),
				application.getTotalWinsSecondPlayer(), application.getTotalDraws());
	}
}
