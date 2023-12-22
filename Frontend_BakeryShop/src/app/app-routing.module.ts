import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CatalogComponent } from './catalog/catalog.component';
import { CartComponent } from './cart/cart.component';
import { SignInComponent } from './user/sign-in/sign-in.component';
import { TemplateFormControlsComponent } from './user/template-form-controls/template-form-controls.component';
import { RegistrationComponent } from './user/registration/registration.component';

const routes: Routes =[
  { path: 'home', component: HomeComponent, title: "Home - Tiff's Sweet Shop"},
  { path: 'catalog', component: CatalogComponent, title: "Catalog - Tiff's Sweet Shop"},
  { path: 'cart', component: CartComponent, title: "Cart - Tiff's Sweet Shop"},
  { path: 'sign-in', component: SignInComponent, title: "Sign-in - Tiff's Sweet Shop"},
  { path: 'registration', component: RegistrationComponent, title: "registration - Tiff's Sweet Shop" },
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
