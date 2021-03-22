import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {any} from "codelyzer/util/function";

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

  contact: Contact[];
  private httpClient: HttpClient;
  private url = 'http://localhost:8080';

  constructor(httpClient: HttpClient) {
    this.contact = [];
    this.httpClient = httpClient;
  }

  ngOnInit(): void {
    this.getContacts()
  }

  getContacts(){
    this.httpClient.get<any>(this.url + '/all').subscribe(
      response => {
        console.log(response);
        this.contact = response;
      }
    );
  }

  deleteContact(contactToDelete: Contact){
   // this.httpClient.delete(this.url + '/delete', headers.none);
    console.log("delete");

  }

  editContact(contactToEdit: Contact){
    console.log("Edit");
    this.httpClient.put(this.url + '/put', null).subscribe(
      response => {
        console.log(response);
      }

    )

  }

}
