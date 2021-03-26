import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AddressListComponent} from "./address-list/address-list.component";
import {AddressSubmitComponent} from "./address-submit/address-submit.component";


const routes: Routes = [
  {path: 'address-list', component: AddressListComponent},
  {path: 'address-submit', component: AddressSubmitComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
