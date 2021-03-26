import { Component, OnInit } from '@angular/core';
import { ContactService} from "../contact.service";
import { Contact} from "../contact";
import {AddressListComponent} from "../address-list/address-list.component";

@Component({
  selector: 'app-address-submit',
  templateUrl: './address-submit.component.html',
  styleUrls: ['./address-submit.component.css']
})
export class AddressSubmitComponent implements OnInit {

  private contactService: ContactService;
  private adressListComponent: AddressListComponent;

  constructor(contactService: ContactService, adressListComponent: AddressListComponent) {
    this.contactService = contactService;
    this.adressListComponent = adressListComponent;
  }

  ngOnInit(): void {
  }

  addContact(name: string, adress: string) {
    this.contactService.addContact(name, adress).toPromise().then(response => {this.adressListComponent.getContacts()});
  }


}
