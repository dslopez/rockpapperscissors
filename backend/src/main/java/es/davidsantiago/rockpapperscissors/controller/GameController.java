package es.davidsantiago.rockpapperscissors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.davidsantiago.rockpapperscissors.bean.Application;
import es.davidsantiago.rockpapperscissors.bean.Game;

@RestController

public class GameController {

	@Autowired
	Application application;

	@RequestMapping("/game")
	public Game getGame(@RequestParam(value = "id") String id) {
		return application.getGamesMap().get("game" + id);
	}
}
