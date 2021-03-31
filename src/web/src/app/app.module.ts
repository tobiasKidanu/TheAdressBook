import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AddressListComponent } from './address-list/address-list.component';
import {HttpClientModule} from "@angular/common/http";
import {NgbModal,NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from "@angular/forms";
import {ContactService} from "./contact.service";
import { AddressAddComponent } from './address-add/address-add.component';
import {AppComponent} from "./app.component";


@NgModule({
  declarations: [
    AppComponent,
    AddressListComponent,
    AddressAddComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
  ],
  providers: [ContactService],
  bootstrap: [AppComponent]
})
export class AppModule { }
