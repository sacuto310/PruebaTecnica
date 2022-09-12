CREATE DATABASE ler_pruebatecnica;

CREATE TABLE usuario
(
    id INT NOT NULL,
  cedula INT NOT NULL,
  nombre VARCHAR(60) NOT NULL,
  apellido VARCHAR(20) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  correo VARCHAR(60) NOT NULL, 
    PRIMARY KEY (id)
);

