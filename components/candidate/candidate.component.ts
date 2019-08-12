import { Component, OnInit } from '@angular/core';
import { TwitterService } from 'src/app/service/twitter.service';

@Component({
  selector: 'app-card',
  templateUrl: './candidate.component.html',
  styleUrls: ['./candidate.component.css']
})
export class CardComponent implements OnInit {

  twitterUser:string = "starwars"
  user: userName = new userName("");

  constructor(private ts: TwitterService) { }

  ngOnInit() {
    // console.log("From component: " + this.twitterUser)
    // this.ts.createUser(this.twitterUser).subscribe(user => {
    //   console.log(user);
    // });
  }

 onSubmit(){
   console.log("From component: " + this.user.username)
    this.ts.createUser(this.user.username).subscribe(user => {
      console.log(user);
    });
 }

}

class userName {
  constructor(
    public username: string
    ){}
}