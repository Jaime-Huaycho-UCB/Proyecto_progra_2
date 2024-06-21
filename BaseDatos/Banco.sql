create database ProyectoProgra2;
use ProyectoProgra2;

create table USUARIOS_SISTEMA(
	id int not null auto_increment,
    nombre varchar(20) not null,
    contrasena varchar(30) not null,
    primary key (id)
);
insert into USUARIOS_SISTEMA (nombre,contrasena) values ("sergio","pepe");
select * from USUARIOS_SISTEMA;

select * from USUARIOS_SISTEMA;

select * from TRANSFERENCIAS;
delete from TRANSFERENCIAS where id = 11;


create table TRANSACCIONES_CUENTA(
	id int not null auto_increment,
    numeroCuenta numeric(14,0) not null,
    tipo numeric(1,0) not null,
    fecha date not null,
    descripcion varchar(225) not null,
    monto decimal(10,2) not null,
    primary key (id),
    foreign key (numeroCuenta) references CUENTAS_AHORRO(numeroCuenta) on delete cascade
);
select PERSONAS.nombre,PERSONAS.apellidoPaterno,PERSONAS.apellidoMaterno,CUENTAS_AHORRO.numeroCuenta,PERSONAS.ci,TIPOS_CUENTA.nombre as nombreTipoCuenta,TIPOS_CUENTA.tipoInteres,CUENTAS_AHORRO.fechaApertura,TIPOS_CUENTA.interes,CUENTAS_AHORRO.saldo 
from CUENTAS_AHORRO,PERSONAS,TIPOS_CUENTA 
where CUENTAS_AHORRO.ciPersona=PERSONAS.ci and PERSONAS.ci= 8343043 ;
INSERT INTO TRANSACCIONES_CUENTA (numeroCuenta,tipo,fecha,descripcion,monto) values(89129577,1,'2024-05-21','efwefwef',23.43);
select * from TRANSACCIONES_CUENTA;

create table CUENTAS_AHORRO(
	numeroCuenta numeric(14,0) not null,
    ciPersona numeric(7,0) not null,
    tipo int not null,
    fechaApertura date not null,
    saldo double(10,2) not null,
    primary key (numeroCuenta),
    foreign key (ciPersona) references PERSONAS(ci),
    foreign key (tipo) references TIPOS_CUENTA(id) on delete cascade
);
select * from CUENTAS_AHORRO;
select CUENTAS_AHORRO.numeroCuenta,PERSONAS.nombre,PERSONAS.apellidoPaterno,PERSONAS.apellidoMaterno,TIPOS_CUENTA.nombre as Tipo,CUENTAS_AHORRO.saldo
FROM CUENTAS_AHORRO,TIPOS_CUENTA,PERSONAS
where CUENTAS_AHORRO.ciPersona = PERSONAS.ci and TIPOS_CUENTA.id=CUENTAS_AHORRO.tipo;
delete from CUENTAS_AHORRO WHERE ciPersona=8343043;

create table TIPOS_CUENTA(
	id int not null auto_increment,
    nombre varchar(20) not null,
    interes double(3,2) not null,
    tipoInteres varchar(20) not null,
    primary key (id)
);
ALTER TABLE CIUDADES_PAIS AUTO_INCREMENT = 1;
select * from TIPOS_CUENTA;
delete FROM TIPOS_CUENTA where id>=1;
insert into TIPOS_CUENTA (nombre,interes,tipoInteres) values ();


create table PERSONAS(
	ci numeric(7,0) not null,
    nombre varchar(20) not null,
    apellidoPaterno varchar(20) not null,
    apellidoMaterno varchar(20) not null,
    fechaNacimiento date not null,
    idGenero int not null,
    idPais int not null,
    idCiudad int not null,
    direccion varchar(50) not null,
	primary key (ci),
    foreign key (idGenero) references GENEROS(id),
	foreign key (idPais) references PAISES(id),
    foreign key (idCiudad) references CIUDADES(id)
);
select * from PERSONAS;
INSERT INTO PERSONAS (ci,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,idGenero,idUbicacion) 
values (1,"jj","hh","cc","2024-03-12",1,5);
delete from PERSONAS where ci=8343043;

create table GENEROS(
	id int not null auto_increment,
    nombre varchar(20) not null,
    primary key (id)
);
insert into GENEROS(nombre)
values ("Masculino");
select * from GENEROS;

create table CIUDADES_PAIS(
	id int not null auto_increment,
	idPais int not null,
    idCiudad int not null,
    foreign key (idPais) references PAISES(id),
    foreign key (idCiudad) references CIUDADES(id),
    primary key (id)
);
ALTER TABLE CIUDADES_PAIS AUTO_INCREMENT = 10;
insert into CIUDADES_PAIS(idPais,idCiudad) 
values (2,10);
delete from CIUDADES_PAIS where id>=17;
select * from CIUDADES_PAIS;
drop table CIUDADES_PAIS;
select CIUDADES_PAIS.id,PAISES.nombre As nombrePais,CIUDADES.nombre As nombreCiudad FROM CIUDADES_PAIS,PAISES,CIUDADES
where CIUDADES_PAIS.idPAis=PAISES.id and CIUDADES_PAIS.idCiudad=CIUDADES.id and PAISES.id = 1;

create table PAISES(
	id int not null auto_increment,
    nombre varchar(20) not null,
    primary key (id)
);
insert into PAISES(nombre)
values ("Argentia");
select * from PAISES;

create table CIUDADES(
	id int not null auto_increment,
    nombre varchar(20) not null,
    primary key (id)
);
insert into CIUDADES (nombre) 
values ("Buenos Aires");
select * from CIUDADES;
drop table CIUDADES;
