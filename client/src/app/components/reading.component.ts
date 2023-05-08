import { Component, OnInit } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { Card } from '../models/card.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reading',
  templateUrl: './reading.component.html',
  styleUrls: ['./reading.component.css']
})
export class ReadingComponent implements OnInit {

  dailyCard!: Card;

  constructor(private backendSvc: BackendService,
              private router: Router) { }

  ngOnInit() {
    this.backendSvc.getDailyReading()
      .then(result => {
        this.dailyCard = result;
        console.log(this.dailyCard);
      }).catch(error => {
        console.log(error);
      });
  }

  saveReading() {

    this.backendSvc.saveReading(this.dailyCard)
      .then(result => {
        console.log(result);
      }).catch(error => {
        console.log(error);
      })

      this.router.navigate(["/saved"]);
  }
}
