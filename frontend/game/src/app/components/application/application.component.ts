import { Component, OnInit } from '@angular/core';
import { ApplicationService } from './../../services/application.service';
import { Application } from './../../interfaces/application'

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css']
})
export class ApplicationComponent implements OnInit {
	application;
  	constructor(
    	private applicationService: ApplicationService,
  	) { }

  	ngOnInit() { 
  		this.application = this.applicationService.getApplication()
  		.subscribe(data => this.application = {
 			  totalRoundsPlayed: (data as any).totalRoundsPlayed,
 			  totalWinsFirstPlayer:  (data as any).totalWinsFirstPlayer,
        totalWinsSecondPlayer:  (data as any).totalWinsSecondPlayer,
        totalDraws:  (data as any).totalDraws,
		  });
      
  		console.log(this.application.totalRoundsPlayed);
  	}

}
