package com.javapruebatecnica.pruebatecnica.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javapruebatecnica.pruebatecnica.model.Usuarios;
import com.javapruebatecnica.pruebatecnica.service.UsuariosService;

@RestController
@RequestMapping("/usuario/")
public class UsuariosRest {
    
    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    private ResponseEntity<List<Usuarios>> getAllUsuarios() {
        return ResponseEntity.ok(usuariosService.findAll());
    }

    @PostMapping
    private ResponseEntity<Usuarios> saveUser(@RequestBody Usuarios usuario) {
        try {
            Usuarios usuarioGuardado = usuariosService.save(usuario);
            return ResponseEntity.created(new URI("/usuario/"+usuarioGuardado.getId())).body(usuarioGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
    }

    @DeleteMapping (value = "delete/{id}")
    private ResponseEntity<Boolean> deleteUsuario(@PathVariable ("id") Long id){
        usuariosService.deleteById(id);
        return ResponseEntity.ok(!(usuariosService.findById(id)!= null));
        
    }
}
