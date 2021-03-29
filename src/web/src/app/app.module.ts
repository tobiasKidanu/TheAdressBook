import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AddressListComponent } from './address-list/address-list.component';
import {HttpClientModule} from "@angular/common/http";
import {NgbModal,NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from "@angular/forms";
import {ContactService} from "./contact.service";
import { AddressSubmitComponent } from './address-submit/address-submit.component';


@NgModule({
  declarations: [
    AddressListComponent,
    AddressSubmitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
  ],
  providers: [ContactService],
  bootstrap: [AddressListComponent]
})
export class AppModule { }
