import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ContactService} from '../contact.service';
import {Contact} from '../contact';
import {readSpanComment} from "@angular/compiler-cli/src/ngtsc/typecheck/src/comments";

@Component({
  selector: 'app-home-page',
  templateUrl: 'home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  contactService: ContactService;
  public contacts: Contact[];

  constructor(httpClient: HttpClient, contactService: ContactService) {
    this.contactService = contactService;
    this.contacts = [];
  }

  ngOnInit(): void {
    this.getContacts();
  }

  getContacts() {
    this.contactService.getContacts().subscribe(response => {this.contacts = response});
  }

  addContact(name: string, adress: string) {
    this.contactService.addContact(name, adress).toPromise().then(response => {this.getContacts()});
  }

  deleteContact(contactToDelete: Contact) {
    this.contactService.deleteContact(contactToDelete).toPromise().then(respone => {this.getContacts()})

  }

  editContact(contactToEdit: Contact){
    contactToEdit.edit = true;
    //this.contactService.editContact(contactToEdit)
  }
}
