import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Contact} from "./contact";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class ContactService {

  private httpClient: HttpClient;
  private url = 'http://localhost:8080';

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  addContact(name: string, adress: string){
    const newContact = {name: name, adress: adress};
    //   this.httpClient.post(this.url + '/create',newContact).subscribe(
    this.httpClient.post<Promise<Contact>>(this.url + '/create',newContact).toPromise().then();
  }

  getContacts(): Observable<any> {
    return this.httpClient.get(this.url + '/all');
  }

  deleteContact(contactToDelete: Contact) {
    let contactId = contactToDelete.id;
    console.log("delete contact with id " + contactId);
    this.httpClient.delete(this.url + '/delete/' + contactId).toPromise().then();
  }

  editContact(contactToEdit: Contact){
    console.log("Edit");
    this.httpClient.put(this.url + '/put', null).toPromise().then();
  }
}
