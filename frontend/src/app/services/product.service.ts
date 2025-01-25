import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiUrl : string = "http://localhost:8085/api/v1/admin/products";

  constructor(private httpClient:HttpClient) { }

    // Method to fetch products from the backend API
  getProducts():Observable<Product[]>{
     // Perform a GET request to the API endpoint to fetch products
    return this.httpClient.get<Product[]>(this.apiUrl)
  }
  // Method to create a new product
  createProduct(formData:any):Observable<any>{
    // Perform a POST request to the API endpoint to create a new product
    return this.httpClient.post<Product>(this.apiUrl,formData);
  }
  // Method to delete a product by its ID
  deleteProductById(id:number):Observable<any>{
    // Perform a DELETE request to the API endpoint to delete a product by ID    
    return this.httpClient.delete(this.apiUrl+"/"+id);  
  }
  // Method to fetch a product by its ID
  getProductById(id:number):Observable<Product>{
    // Perform a GET request to the API endpoint to fetch a product by ID    
   return this.httpClient.get<Product>(this.apiUrl+"/"+id); 
  }
}
