import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Category } from 'src/app/common/category';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {
  
  categories: Category [] = [];

  constructor(private categoryService:CategoryService, private toastr: ToastrService) { }
 
  ngOnInit(): void {
    this.listCategories();
  }

  listCategories(){
    this.categoryService.getCategoryList().subscribe(
      data => {this.categories = data
        console.log(data);
      }
    );  
  }

  deleteCategoryById(id:number){
    console.log('El id de categoria antes de eliminar: '+id);
    Swal.fire({
      title: "¿Estás seguro de eliminar este registro?",
      text: "",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Eliminar",
      cancelButtonText: "Cancelar"
    }).then((result) => {
      if (result.isConfirmed) {
        this.categoryService.deleteCategoryById(id).subscribe(
          ()=>this.listCategories()
        );
        Swal.fire({
          title: "Categorías",
          text: "Categoría eliminada correctamente.",
          icon: "success"
        });
      }
    })
  }   

}
