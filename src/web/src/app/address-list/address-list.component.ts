import {Component, Injectable, OnInit, Output, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ContactService} from '../contact.service';
import {Contact} from '../contact';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-address-list',
  templateUrl: 'address-list.component.html',
  styleUrls: ['./address-list.component.css']
})

@Injectable({
  providedIn: 'root'
})

export class AddressListComponent implements OnInit {
  contactService: ContactService;
  public contacts: Contact[];

  @Output() userEdited = new EventEmitter<string>();
  @ViewChild('editName') editName: any;
  @ViewChild('editAdress') editAdress: any;


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
    //this.contactService.editContact(contactToEdit)
  }

  updateContact(contactToUpdate: Contact) {
    contactToUpdate.name = this.editName.nativeElement.value;
    contactToUpdate.adress = this.editAdress.nativeElement.value;
    contactToUpdate.edit = false;
    this.contactService.updateContact(contactToUpdate);
  }
}
