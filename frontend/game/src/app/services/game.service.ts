import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Game } from './../interfaces/game'
import { Subject } from 'rxjs/Subject';
import { Observable } from 'rxjs/Observable';
import { catchError, retry } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';
import { HttpParams } from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    }),
    observe: 'response'
};

const apiUrl = 'http://localhost:8080/game';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  game : Game;
  private game$ = new Subject<Game>();
responseData;
  constructor(
  	private http: HttpClient
  ) { }

  getGame$(): Observable<Game> {
    return this.game$.asObservable();
  }

  public newGame() { 	
    this.game = new Game();
    console.log('sending post request to ' +  apiUrl);
  	this.http.post<Game>(apiUrl, {})
  	 .subscribe(
        (val) => {
            console.log("POST call successful value returned in body", 
                        val);
            this.copyData(val);

        },
        response => {
            console.log("POST call in error", response);
        },
        () => {
            console.log("The POST observable is now completed.");
            this.game$.next(this.game);
        });


  }	

  public playRound(gameId : string) {  
    this.game = new Game();
    console.log('sending put request to ' +  apiUrl);
    this.http.put<Game>(apiUrl + '/' + gameId + '/playRound', {})
    .subscribe(
        (val) => {
            console.log("PUT call successful value returned in body", 
                        val);
            this.copyData(val);

        },
        response => {
            console.log("PUT call in error", response);
        },
        () => {
            console.log("The PUT observable is now completed.");
            this.game$.next(this.game);
        });


  }

  public restartGame(gameId : string) {  
    this.game = new Game();
    console.log('sending put request to ' +  apiUrl);
    this.http.put<Game>(apiUrl + '/' + gameId + '/restart', {})
    .subscribe(
        (val) => {
            console.log("PUT call successful value returned in body", 
                        val);
            this.copyData(val);

        },
        response => {
            console.log("PUT call in error", response);
        },
        () => {
            console.log("The PUT observable is now completed.");
            this.game$.next(this.game);
        });


  }

  private copyData(val : Object) {
    this.game['roundsPlayed'] = val['roundsPlayed'];
    this.game['rounds'] = val['rounds'];
    this.game['id'] = val['id'];
  }
}
