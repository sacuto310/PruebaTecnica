package com.javapruebatecnica.pruebatecnica.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table (name = "usuario")
public class Usuarios {
    @Id
    @SequenceGenerator(name = "usuario_generator", sequenceName = "usuario_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator") 
    private Long id;
    private Long cedula;
    private String nombre;
    private String apellido;
    private String fechanacimiento;
    private String correo;
    

    
}
