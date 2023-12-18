import { Component, inject } from '@angular/core';
import { IProduct } from './product.model';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { ProductService } from './product.service';
import { CartService } from '../cart.service';

@Component({
  selector: 'tiff-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent {
  products: IProduct[]= [];
  errorMessage: string ='';
  filter: string ='';

  constructor(
    private cartSvc: CartService, 
    private productSvc: ProductService) {  }

  ngOnInit() {
    this.productSvc.getProducts().subscribe({
      next: products => this.products = products,
      error: err => this.errorMessage = err
    })
  }
    

  getImageUrl(product: IProduct){
    return 'assets/images/cake/' + product.imageUrl;
  }
  getFilterProduct() {
    return this.filter === ''
      ? this.products
      : this.products.filter((product) => product.category === this.filter);
  }
  addToCart(product: IProduct) {
    this.cartSvc.add(product);
  }
}
