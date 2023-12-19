import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CatalogComponent } from './catalog/catalog.component';
import { CartComponent } from './cart/cart.component';

const routes: Routes =[
  { path: 'home', component: HomeComponent, title: "Home - Tiff's Sweet Shop"},
  { path: 'catalog', component: CatalogComponent, title: "Catalog - Tiff's Sweet Shop"},
  { path: 'cart', component: CartComponent, title: "Cart - Tiff's Sweet Shop"},
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
