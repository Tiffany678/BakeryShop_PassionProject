import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IProduct } from '../catalog/product.model';

@Component({
  selector: 'tiff-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent  {
  @Input() product!: IProduct;
  @Output() buy = new EventEmitter()  

  constructor() { }

  getImageUrl(product: IProduct){
    return 'assets/images/cake/' + product.imageUrl;
  }

  buyButtonClicked(product: IProduct){
    this.buy.emit();
  }
}
