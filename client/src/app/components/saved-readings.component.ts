import { Component, OnInit } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { Card } from '../models/card.model';
import { Reading } from '../models/reading.model';

@Component({
  selector: 'app-saved-readings',
  templateUrl: './saved-readings.component.html',
  styleUrls: ['./saved-readings.component.css']
})
export class SavedReadingsComponent implements OnInit {

  readings!: Reading[];

  constructor(private backendSvc: BackendService) {}

  ngOnInit() {
    this.backendSvc.getSavedReadings()
      .then(result => {
        console.log(result);
        this.readings = result;
      }).catch(error => {
        console.log(error);
      })
  }
}
