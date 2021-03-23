import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

export class Contact {
  constructor(
    public id: string,
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

  contacts: Contact[];
  private httpClient: HttpClient;
  private url = 'http://localhost:8080';

  constructor(httpClient: HttpClient) {
    this.contacts = [];
    this.httpClient = httpClient;
  }

  ngOnInit(): void {
    this.getContacts()
  }

  addContact(name: string, adress: string){
   const newContact = {name: name, adress: adress};
    this.httpClient.post(this.url + '/create',newContact).subscribe(
      response => {console.log('New Contact added' + JSON.stringify(newContact))}
    )
  }

  getContacts(){
    this.httpClient.get<any>(this.url + '/all').subscribe(
      response => {
        console.log(response);
        this.contacts = response;
      }
    );
  }

  deleteContact(contactToDelete: Contact) {
    let contactId = contactToDelete.id;
    console.log("delete contact with id " + contactId);
    this.httpClient.delete(this.url + '/delete/' + contactId).subscribe(
      response => {console.log(" Deleted contact " + response);}
    )
  }

  editContact(contactToEdit: Contact){
    console.log("Edit");
    this.httpClient.put(this.url + '/put', null).subscribe(
     // response => {console.log(response);}
    )
  }

  refresh(): void {
    window.location.reload();
  }
}
