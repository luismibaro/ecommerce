import { Component, OnInit } from '@angular/core'; // Importing necessary modules from Angular
import { Product } from 'src/app/common/product'; // Importing the Product class from the product module
import { ProductService } from 'src/app/services/product.service'; // Importing the ProductService from the services module

@Component({
  selector: 'app-home', // Component selector
  templateUrl: './home.component.html', // Template file for the component
  styleUrls: ['./home.component.css'] // Stylesheet file for the component
})
export class HomeComponent implements OnInit { // HomeComponent class implementing OnInit interface
  products: Product [] = []; // Array to store products

  constructor(private productService: ProductService) { } // Constructor injecting ProductService

  ngOnInit(): void { // Implementation of OnInit interface method
    // Calling the getProducts() method of the ProductService and subscribing to the response
    // Assigning the received data to the products array
    this.productService.getProducts().subscribe(
      data => this.products = data
    );
  }

}
