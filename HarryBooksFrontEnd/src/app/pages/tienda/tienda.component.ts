import { Component, OnInit } from "@angular/core";
import { Producto } from "model/Producto";
import { ProductoService } from "src/app/core/service/producto.service";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: "app-tienda",
  templateUrl: "tienda.component.html"
})
export class TiendaComponent implements OnInit {

  responseProductos: Producto[] = [];

  modificarProductoForm: FormGroup;
  private modificarProductoFormBuilder = new FormBuilder;

  idProducto: number = null;
  nombreProducto: string = "";
  descripcionProducto: number = 0;
  valorProducto: number = 0;
  tipoProducto: number = 0;


  constructor(private productoService: ProductoService,
              private toastr: ToastrService) {}

  ngOnInit() {
    this.cargarProductos();

  }

  cargarProductos(): void {
    this.productoService.getAllProductos().subscribe(
      response => {
        this.responseProductos = response;
      },
      error => {
        console.log(error)
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

  crearProducto(){

    if (this.tipoProducto>this.descripcionProducto) {
      this.toastr.success('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> No tenemos tantos ejemplares', '', {
        enableHtml: true,
        toastClass: "alert alert-success alert-with-icon",
        positionClass: 'toast-top-center',
        timeOut: 2000
      });
    } else {
    const nuevoProducto = new Producto(0, this.nombreProducto, this.descripcionProducto, this.valorProducto, this.tipoProducto);

    this.productoService.createProducto(nuevoProducto).subscribe(
      response => {
        this.toastr.success('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> Item agregado al carrito ', '', {
          enableHtml: true,
          toastClass: "alert alert-success alert-with-icon",
          positionClass: 'toast-top-center',
          timeOut: 2000
        });
        this.cargarProductos();
        this.limpiarModal();
      },
      error => {
        console.log(error);
      }
    )
    }
  }

  limpiarModal(){
    this.idProducto = null;
    this.nombreProducto = null;
    this.descripcionProducto = null;
    this.valorProducto = null;
    this.tipoProducto = null;
  }
}
