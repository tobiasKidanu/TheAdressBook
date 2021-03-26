import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AddressListComponent} from "./address-list/address-list.component";


const routes: Routes = [
  {path: 'address-list', component: AddressListComponent},
  {path: '', component: AddressListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
