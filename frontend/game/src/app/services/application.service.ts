import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Application } from './../interfaces/application'

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  constructor(
  	private http: HttpClient
  ) { }

  getApplication() {
    return this.http.get<Application>('http://localhost:8080/application');
  }

}
