import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { Producto } from "model/Producto";
import { TipoProducto } from "model/TipoProducto";
import { ProductoService } from "src/app/core/service/producto.service";
import { TipoProductoService } from "src/app/core/service/tipoProducto.service";
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: "app-productos",
  templateUrl: "./productos.component.html",
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {

  responseProductos: Producto[] = [];
  responseItems: Producto[] = [];
  responseTiposProducto: TipoProducto[] = [];


  modificarProductoForm: FormGroup;
  private modificarProductoFormBuilder = new FormBuilder;

  idProducto: number = null;
  nombreProducto: string = "";
  descripcionProducto: number = 0;
  valorProducto: number = 0;
  tipoProducto: number = 0;
  total = 0;

  constructor(private productoService: ProductoService,
              private tipoProductoService: TipoProductoService,
              private activatedRoute: ActivatedRoute,
              private toastr: ToastrService,
              private router: Router) {}

  ngOnInit() {
   
    this.crearControlesFormulario();
    this.cargarProductos();
    this.cargarTiposProducto();
    this.cargarItems();
  }

  cargarProductos():void{
    this.productoService.getAllProductos().subscribe(
      response => {
        this.responseProductos = response;
        console.log(this.responseProductos)
      },
      error => {
        console.log(error)
      }
    )
  }

  
  cargarItems():void{
    this.productoService.getAllItems().subscribe(
      response => {
        this.responseItems = response;
        console.log(this.responseItems)
      },
      error => {
        console.log(error)
      }
    )
  }

  cargarTiposProducto(): void {
    this.tipoProductoService.getAllTiposProducto().subscribe(
      response => {
        this.responseTiposProducto = response;
      },
      error => {
        console.log(error)
      }
    )
  }


  crearControlesFormulario(){
    this.modificarProductoForm = this.modificarProductoFormBuilder.group({
      nombreProducto: new FormControl ('', [Validators.required])
    });
  }

  descontarCompras(){
    this.productoService.descontarCompras().subscribe(
      response => {

           this.toastr.success('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> Gracias por tu compra.', '', {
            enableHtml: true,
            toastClass: "alert alert-success alert-with-icon",
            positionClass: 'toast-top-center',
            timeOut: 2000
          });
        this.responseProductos = response;
        console.log(this.responseProductos);
      },
      error => {
        console.log(error)
      }
    )
    
  }

  modificarProducto(){

    if (this.tipoProducto>this.descripcionProducto) {
      this.toastr.success('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> No tenemos tantos ejemplares', '', {
        enableHtml: true,
        toastClass: "alert alert-success alert-with-icon",
        positionClass: 'toast-top-center',
        timeOut: 2000
      });
    } else {
      
    const productoModificado = new Producto(this.idProducto, this.nombreProducto, this.descripcionProducto, this.valorProducto, this.tipoProducto);

    this.productoService.updateProducto(productoModificado.idProducto, productoModificado).subscribe(
      response => {
        this.toastr.success('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> Item modificado correctamente ', '', {
          enableHtml: true,
          toastClass: "alert alert-success alert-with-icon",
          positionClass: 'toast-top-center',
          timeOut: 2000
        });
        this.cargarItems();
        this.limpiarModal();
      },
      error => {
        console.log(error);
      }
    )
  }
  }

  eliminarProducto(idProducto: number){
    this.productoService.deleteProducto(idProducto).subscribe(
      response => {
        this.cargarItems();
        this.toastr.success('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> Item eliminado correctamente ', '', {
          enableHtml: true,
          toastClass: "alert alert-success alert-with-icon",
          positionClass: 'toast-top-center',
          timeOut: 2000
        });      },
      error => {
        console.log(error);
      }
    )
  }

  cargarDatosFila(data: Producto){
    this.idProducto = data.idProducto;
    this.nombreProducto = data.nombreProducto;
    this.descripcionProducto = data.descripcionProducto;
    this.valorProducto = data.valorProducto;
    this.tipoProducto = data.tipoProducto;
  }

  limpiarModal(){
    this.idProducto = null;
    this.nombreProducto = null;
    this.descripcionProducto = null;
    this.valorProducto = null;
    this.tipoProducto = null;
  }


  hallarTotal(data:Producto[]){
    
  }
}
