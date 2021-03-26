import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Contact} from "./contact";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class ContactService {

  private httpClient: HttpClient;
  private url = 'http://localhost:8080/contacts';

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  addContact(name: string, adress: string): Observable<any>{
    const newContact = {name: name, adress: adress};
    //   this.httpClient.post(this.url + '/create',newContact).subscribe(
    return this.httpClient.post<Promise<Contact>>(this.url + '/',newContact);
  }

  getContacts(): Observable<any> {
    return this.httpClient.get(this.url + '/');
  }

  deleteContact(contactToDelete: Contact): Observable<any> {
    let contactId = contactToDelete.id;
    console.log("delete contact with id " + contactId);
    return this.httpClient.delete(this.url + '/' + contactId);
  }

  updateContact(contactToEdit: Contact){
    let contactId = contactToEdit.id;
    console.log("Editing contact" + contactId);
    this.httpClient.put(this.url + '/' + contactId,contactToEdit).toPromise().then();
  }
}
