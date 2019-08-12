import { Component, OnInit } from '@angular/core';
import { TwitterService } from 'src/app/service/twitter.service';
//import { BinaryOperator } from '@angular/compiler';

@Component({
  selector: 'app-recruiter',
  templateUrl: './recruiter.component.html',
  styleUrls: ['./recruiter.component.css']
})
export class RecruiterComponent implements OnInit {

  candidate:string = "Slamchez" //this will come from the component that loads it on the mian back end. Hard coded for testing. 

  bio:string;
  followers:number;
  following:number;
  likes:number;
  location:string;
  twitterName:string;
  displayName:string;
  profilePic:string;


  constructor( private ts: TwitterService) { }

  //c. vars need to be data base cariables not Angular variables. 
  //this.var is for Angular while arrow var is database 
  ngOnInit() {
    this.ts.getUser(this.candidate).subscribe(c => {
      //console debuging
      console.log("This is from Recruiter Component")
      console.log(c);
      console.log(c.followers);
      console.log(c.following);
      console.log(c.profilename);
      console.log(c.likes);
      console.log(c.location);
      console.log(c.username);
      this.twitterName = c.username; //should be @Name
      this.displayName = c.profilename; //should be name on profile ex: "Brian"
      this.followers = c.followers; 
      this.following = c.following;
      this.likes = c.likes;
      this.location = c.location;
      this.bio = c.bio;
      this.profilePic = c.profilePic;
    })
  }

}
