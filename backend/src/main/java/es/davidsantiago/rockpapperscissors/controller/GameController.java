package es.davidsantiago.rockpapperscissors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PostMapping(value = "/game")
	public ResponseEntity<Game> newGame() {
		Game game = new Game(application);
		return new ResponseEntity<Game>(game, HttpStatus.CREATED);
	}

	@PutMapping(value = "/game/{id}/playRound")
	public ResponseEntity<Game> playRound(@PathVariable("id") int id) {
		Game game = application.getGamesMap().get(Game.KEY_PREFIX + id);
		game.playRound();
		return new ResponseEntity<Game>(game, HttpStatus.OK);
	}

	@PutMapping(value = "/game/{id}/restart")
	public ResponseEntity<Game> restart(@PathVariable("id") int id) {
		Game game = application.getGamesMap().get(Game.KEY_PREFIX + id);
		game.restart();
		return new ResponseEntity<Game>(game, HttpStatus.OK);
	}
}
