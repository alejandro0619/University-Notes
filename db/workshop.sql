-- Alejandro Lopez
-- 1. Listar empleados (CI, nombre) y el departamento donde labora
-- 2. Agregar sueldo.
-- 3. Salio capital america en la lista 1?
-- 4. Listar empleados y sus departamentos, tengan o no departamentos.
-- 5. Agregar genero
-- 6. Sueldos por genero

CREATE DATABASE workshop;

USE workshop;

CREATE TABLE departamentos(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL
);

CREATE TABLE empleados(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  cedula VARCHAR(10) NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  dep INT NOT NULL,
  FOREIGN KEY(dep) REFERENCES departamentos(id)
);

-- Insertamos varios valores en departamentos
INSERT INTO departamentos(nombre) 
  VALUES 
  ("RRHH"), 
  ("Contaduria"), 
  ("Presidencia"), 
  ("Atencion al cliente")
  ;

-- Insertamos varios valores en empleados
INSERT INTO empleados(cedula, nombre, fecha_nacimiento, dep)
  VALUES
  ("30819825", "Alejandro Lopez", "2004-08-24", 1),
  ("308567136", "Vivian Romero", "2003-04-30", 3),
  ("00066652", "John Doe", "2000-01-30", 4),
  ("10701676", "CAPITAN AMERICA", "2003-02-24", NULL)
  ;

-- Apartado 1.
SELECT empleados.cedula, empleados.nombre
FROM empleados INNER JOIN departamentos
ON empleados.dep = departamentos.id;

-- Apartado 2.
ALTER TABLE empleados ADD COLUMN sueldo INT NOT NULL DEFAULT 0;

-- Apartado 3.
-- Respuesta: No.

-- Apartado 4.
SELECT empleados.cedula, empleados.nombre, empleados.dep
FROM empleados LEFT JOIN departamentos
ON empleados.dep = departamentos.id;

-- Apartado 5.
ALTER TABLE empleados ADD COLUMN genero VARCHAR(15) NOT NULL;

UPDATE empleados 
SET genero = 'masculino'
WHERE nombre IN ('Alejandro Lopez', 'John Doe', 'CAPITAN AMERICA');

UPDATE empleados
SET genero = "femenino"
WHERE nombre = "Vivian Romero";
