package com.javapruebatecnica.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javapruebatecnica.pruebatecnica.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
    
}
