import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

export class Contact {
  constructor(
    public id: number,
    public name: string,
    public adress: string,
  ) {
  }
}

@Component({
  selector: 'app-home-page',
  templateUrl: 'home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public contact: Contact[];
  public httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.contact = [];
    this.httpClient = httpClient;
  }

  ngOnInit(): void {
    this.getContacts()
  }

  getContacts(){
    this.httpClient.get<any>('http://localhost:8080/all').subscribe(
      response => {
        console.log(response);
        this.contact = response;
      }
    );
  }
}
