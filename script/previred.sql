CREATE DATABASE previred;
USE previred;

CREATE TABLE Empresas (
	id_empresa INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    rut_empresa VARCHAR(10) NOT NULL,
    razon_social VARCHAR(100) NOT NULL,
	fecha_registro DATETIME NOT NULL
);

CREATE TABLE Trabajadores (
	id_trabajador INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    apellido_paterno VARCHAR(20) NOT NULL,
    apellido_materno VARCHAR(20) NOT NULL,
    direccion VARCHAR(100) NOT NULL
);
-- Agregamos la foreing key a la tabla trabajadores
ALTER TABLE Trabajadores ADD COLUMN fk_id_empresa INTEGER UNSIGNED;

-- Agregamos la columna rut a la tabla trabajadores
ALTER TABLE Trabajadores ADD COLUMN rut_trabajador VARCHAR(10) NOT NULL;

-- -----  Creamos la relacion entre tablas con la Foreing Key -------
ALTER TABLE Trabajadores ADD FOREIGN KEY (fk_id_empresa) REFERENCES Empresas(id_empresa);

SELECT * FROM Trabajadores;
SELECT * FROM Empresas;

SELECT * FROM Empresas INNER JOIN Trabajadores ON Empresas.id_empresa = Trabajadores.fk_id_empresa;

-- Query de la tabla Trabajadores --
SELECT id_trabajador, nombre, apellido_paterno, apellido_materno, direccion FROM Trabajadores;
