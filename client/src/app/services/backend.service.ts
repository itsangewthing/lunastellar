import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Card } from '../models/card.model';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private _cardsSharingObj: any;

  public get cardsSharingObj(): any {
    return this._cardsSharingObj;
  }
  public set cardsSharingObj(value: any) {
    this._cardsSharingObj = value;
  }

  constructor(private http: HttpClient) { }

  searchCardsByNameSuit(params: any): Promise<any> {
    const param = new HttpParams()
                    .set('name', params['name'])
                    .set('suit', params['suit']);

    return lastValueFrom(this.http.get<any>("http://localhost:8080/api/search", {params: param}));
  }

  getDailyReading(): Promise<any> {
    return lastValueFrom(
      this.http.get<any>("http://localhost:8080/api/get-1")
    );
  }

  getPPFReading(): Promise<any> {
    return lastValueFrom(
      this.http.get<any>("http://localhost:8080/api/get-3")
    );
  }

  getSavedReadings(): Promise<any> {
    return lastValueFrom(
      this.http.get<any>(`http://localhost:8080/api/saved`)
    );
  }

  saveReading(payload: any): Promise<any> {
    return lastValueFrom(
      this.http.post<any>(`http://localhost:8080/api/save-reading`, payload)
    );
  }

  saveReadings(payload: any): Promise<any> {
    return lastValueFrom(
      this.http.post<any>(`http://localhost:8080/api/save-reading`, payload)
    );
  }

  deleteReading(readingId: string): Promise<any> {
    return lastValueFrom(
      this.http.delete<any>(`http://localhost:8080/api/delete-reading/${readingId}`)
    );
  }
}
