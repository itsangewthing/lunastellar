import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BackendService } from '../services/backend.service';
import { Card } from '../models/card.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  searchForm!: FormGroup;

  cards!: Card[];
  error: boolean = false;
  errorMsg!: string;

  constructor(private fb: FormBuilder, private backendSvc: BackendService,
              private router: Router) {}

  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.searchForm = this.fb.group({
      name: this.fb.control<string>(""),
      suit: this.fb.control<string>("")
    });
  }

  search() {
    console.log(this.searchForm.value);
    this.backendSvc.searchCardsByNameSuit(this.searchForm.value)
      .then(result => {
        this.cards = result;
        console.log(this.cards);
        this.error = false;
        this.backendSvc.cardsSharingObj = this.cards;
        this.router.navigate(["/search"]);
      }).catch(error => {
        console.log(error);
        this.error = true;
        this.errorMsg = "Search returns no results. Please try again.";
      });
  }

}
