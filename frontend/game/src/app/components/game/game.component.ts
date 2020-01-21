import { Component, OnInit } from '@angular/core';
import { GameService } from './../../services/game.service';
import { Game } from './../../interfaces/game'
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
	game$: Observable<Game>;
  	game;

	constructor(
		private gameService: GameService,
	) { }

	ngOnInit() {
		this.game$ = this.gameService.getGame$();
  		this.game$.subscribe(game => this.game = game);
  		this.gameService.newGame();
		
		//console.log('game id=' + this.game.id);
		//console.log(this.game.roundsPlayed);
		//console.log('game.roundsPlayed=' + this.game.roundsPlayed);
	}

}
