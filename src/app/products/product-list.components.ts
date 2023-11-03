import { Component, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { IProduct } from "./product";
import { ProductService } from "./product.service";

@Component({
    selector: 'pm-products',
    templateUrl: './product-list.component.html',
    styleUrls: ['./product-list.component.css'],
})

export class ProductListComponet implements OnInit{
 pageTitle : string = 'cakes';
 showImage : boolean = true;
 errorMessage: string ='';
 sub!: Subscription;

 private _listFilter:string ='';

 get listFilter() :string{
    return this._listFilter;
 }
 set listFilter(value:string){
    this._listFilter = value;
    console.log('In setter:', value);
    this.filteredProducts = this.performFilter(value);
 }

constructor (private productService: ProductService){}

performFilter(filterBy: string): IProduct[] {
    filterBy = filterBy.toLocaleLowerCase();
    return this.products.filter((product: IProduct) =>
      product.title.toLocaleLowerCase().includes(filterBy));
  }

 filteredProducts: IProduct[] = [];

 products : IProduct[] = [  ];

  toggleImage() : void{
    this.showImage = !this.showImage;
  }
  ngOnInit(): void {
        this.productService.getProducts().subscribe({
            next: products => {
                this.products = products;
                this.filteredProducts =  this.products;
            },
            error: err=> this.errorMessage =err
        });
  }


  ngOnDestroy():void{
    this.sub.unsubscribe();
  }
}