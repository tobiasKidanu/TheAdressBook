import { Component, OnInit, Output, EventEmitter} from '@angular/core';
import { ContactService} from "../contact.service";
import { Contact} from "../contact";
import {AddressListComponent} from "../address-list/address-list.component";

@Component({
  selector: 'app-address-add',
  templateUrl: './address-add.component.html',
  //styleUrls: ['./address-add.component.css']
})
export class AddressAddComponent implements OnInit {

  @Output() addedAddress = new EventEmitter<any>();

  private contactService: ContactService;

  constructor(contactService: ContactService) {
    this.contactService = contactService;
  }

  ngOnInit(): void {
  }

  addContact(name: string, adress: string) {
    this.contactService.addContact(name, adress).subscribe(
      response => {
        this.addedAddress.emit();
      }
    );
  }


}
