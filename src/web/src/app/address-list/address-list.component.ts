import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ContactService} from '../contact.service';
import {Contact} from '../contact';

@Component({
  selector: 'app-address-list',
  templateUrl: 'address-list.component.html',
  styleUrls: ['./address-list.component.css']
})

export class AddressListComponent implements OnInit {
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

  deleteContact(contactToDelete: Contact) {
    this.contactService.deleteContact(contactToDelete).toPromise().then(respone => {this.getContacts()})

  }

  cancelEditContact(contactToCancelEdit: Contact) {
    contactToCancelEdit.edit = false;
  }

  editContact(contactToEdit: Contact){
    contactToEdit.edit = true;
  }

  updateContact(contactToUpdate: Contact) {
    contactToUpdate.edit = false;
    this.contactService.updateContact(contactToUpdate);
  }
}
