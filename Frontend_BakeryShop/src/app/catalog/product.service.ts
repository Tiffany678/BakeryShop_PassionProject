import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IProduct } from './product.model';
import { Observable, catchError, tap, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private productUrl ='http://localhost:8080/api/cake';

  constructor(private http: HttpClient) { }

  // getProducts(): Observable<IProduct[]>{
  //   return this.http.get<IProduct[]>('/api/cake');  
  // }
  getProducts(): Observable<IProduct[]> {
    return this.http.get<IProduct[]>(this.productUrl).pipe(
      tap(data => console.log('All', JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  private handleError(err: HttpErrorResponse){
    let errorMessage ='';
    if  (err.error instanceof ErrorEvent) {
      errorMessage =`An error occurred: ${err.error.message}`;
    }else {
      errorMessage = `Server return code: ${err.status}, error message is: ${err.message}`;
    }
    console.error(errorMessage);
    return throwError(()=>errorMessage);
  }
}
