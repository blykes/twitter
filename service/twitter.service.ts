import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
//import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TwitterService {
  apiURL = 'http://localhost:8080/user';
  //handleError: any;

  constructor(private http: HttpClient) { }


httpOptions = {
  headers: new HttpHeaders
  ({
    'Content-Type': 'application/json'
  })}
createUser(TwitterUser:string): Observable<any>
{
  console.log(TwitterUser)
  return this.http.post<string>(this.apiURL + "/twitter", JSON.stringify({'username':TwitterUser}), this.httpOptions)

}
getUser(TwitterUser:string): Observable<any>
{
  console.log(TwitterUser)
  return this.http.get<string>(this.apiURL + "/twitter/" + TwitterUser, this.httpOptions)

}

}