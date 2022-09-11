import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { usuario } from './models/Usuario';
import { UsuarioService } from './services/usuario/usuario.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  

  title = 'Front';
  usuarioForm: FormGroup; 
  usuario: usuario;
  usuarios: usuario[];
  

  constructor(
    public fb: FormBuilder,
    public usuarioService: UsuarioService
    ){
    
  }
  ngOnInit(): void {
    this.usuarioForm = this.fb.group({ 
      id: [''],
      cedula : ['', Validators.required],
      nombre : ['', Validators.required],
      apellido : ['', Validators.required],
      fechanacimiento : ['', Validators.required],
      correo : ['', Validators.required] 
    });
    this.obtenerUsuarios();
}

  obtenerUsuarios():void{
    this.usuarioService.getAllUsuarios().subscribe((resp) => {
      console.log(resp);
      this.usuarios = resp;
  },
    error => { console.error(error) }
  );
  }

  guardar():void{
    this.usuarioService.saveUsuario(this.usuarioForm.value).subscribe(resp =>{
      this.usuarioForm.reset();
      this.usuarios=this.usuarios.filter((usuario)=> resp.id!==usuario.id)
      this.usuarios.push(resp);
    },
    error => { console.error(error) }
    )
  }

  eliminar(usuario:usuario){    
    this.usuarioService.deleteUsuario(usuario.id).subscribe(resp=>{
      if(resp==false){
        this.obtenerUsuarios();
      }
    })
  }

  editar(usuario:usuario){
    this.usuarioForm.setValue({
      id : usuario.id,
      cedula : usuario.cedula,
      nombre : usuario.nombre,
      apellido : usuario.apellido,
      fechanacimiento : usuario.fechanacimiento,
      correo : usuario.correo 
    })
  }

  

}
