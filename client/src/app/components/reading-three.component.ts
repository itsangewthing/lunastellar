import { Component, OnInit } from '@angular/core';
import { Card } from '../models/card.model';
import { BackendService } from '../services/backend.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reading-three',
  templateUrl: './reading-three.component.html',
  styleUrls: ['./reading-three.component.css']
})
export class ReadingThreeComponent implements OnInit {

  threeCards!: Card[];

  constructor(private backendSvc: BackendService,
              private router: Router) {}

  ngOnInit(): void {
    this.backendSvc.getPPFReading()
      .then(result => {
        this.threeCards = result;
        console.log(this.threeCards);
      }).catch(error => {
        console.log(error);
      });
  }

  saveReadings(): void {
    this.backendSvc.saveReadings(this.threeCards)
      .then(result => {
        console.log(result);
      }).catch(error => {
        console.log(error);
      })

      this.router.navigate(["/saved"]);
  }
}
