import { Component, OnInit } from '@angular/core';
import { Card } from '../models/card.model';
import { BackendService } from '../services/backend.service';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {
  
  cards!: Card[];

  constructor(private backendSvc: BackendService) {}

  ngOnInit() {
    this.cards = this.backendSvc.cardsSharingObj;
  }
}
