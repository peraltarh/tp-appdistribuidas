Use TPAD

/******----SUCURSAL----******/
INSERT INTO Sucursal (encRecepcion,encDespacho,dir,gerente,nombre) VALUES ('Hermenegildo', 'Luciani','Rivadavia 3345', 'Perez', 'Buenos Aires');
INSERT INTO Sucursal (encRecepcion,encDespacho,dir,gerente,nombre) VALUES ('Jorge', 'Pasano','Libertador 3345', 'Gonzalez', 'La Plata');
INSERT INTO Sucursal (encRecepcion,encDespacho,dir,gerente,nombre) VALUES ('Luciano', 'Nit','Callao 3345', 'Perez', 'Quilmes');
INSERT INTO Sucursal (encRecepcion,encDespacho,dir,gerente,nombre) VALUES ('Esteban', 'Hernandez','Pueyrredon 3345', 'Gonzalez', 'Mendoza');
INSERT INTO Sucursal (encRecepcion,encDespacho,dir,gerente,nombre) VALUES ('Armando', 'Lima','Corrientes 3345', 'Perez', 'Lanus');

/******----DEPOSITO----******/
INSERT INTO Deposito (cantidadMax,encargado,numeroSucursal) VALUES (200, 'Gonzales, Ricardo',1);
INSERT INTO Deposito (cantidadMax,encargado,numeroSucursal) VALUES (100, 'Perez, German',2);
INSERT INTO Deposito (cantidadMax,encargado,numeroSucursal) VALUES (500, 'Martinez, Rodrigo',3);
INSERT INTO Deposito (cantidadMax,encargado,numeroSucursal) VALUES (800, 'Palacios, Rodrigo',4);
INSERT INTO Deposito (cantidadMax,encargado,numeroSucursal) VALUES (1000, 'Grosso, Nicolas',5);

/******----AREA----******/
INSERT INTO Area(descripcion,capacidadMaxima, idDeposito) VALUES ('Refrigeracion',450,1);
INSERT INTO Area(descripcion,capacidadMaxima, idDeposito) VALUES ('Zona Norte',150,2);
INSERT INTO Area(descripcion,capacidadMaxima, idDeposito) VALUES ('Zona Sur',4500,3);
INSERT INTO Area(descripcion,capacidadMaxima, idDeposito) VALUES ('Zona Oeste',3500,4);
INSERT INTO Area(descripcion,capacidadMaxima, idDeposito) VALUES ('Capital',1000,5);

/******----MAPA DE RUTA----******/
INSERT INTO MapaDeRuta (duracionHs,distancia,numSucOrigen,numSucDestino,costo,numeroSucursal) VALUES (3.5,350,1,2,1500,1);
INSERT INTO MapaDeRuta (duracionHs,distancia,numSucOrigen,numSucDestino,costo,numeroSucursal) VALUES (3.5,150,3,1,1400,2);
INSERT INTO MapaDeRuta (duracionHs,distancia,numSucOrigen,numSucDestino,costo,numeroSucursal) VALUES (3.5,250,2,3,1300,3);
INSERT INTO MapaDeRuta (duracionHs,distancia,numSucOrigen,numSucDestino,costo,numeroSucursal) VALUES (3.5,450,2,4,1200,4);
INSERT INTO MapaDeRuta (duracionHs,distancia,numSucOrigen,numSucDestino,costo,numeroSucursal) VALUES (3.5,550,1,2,1100,5);

/******----CLIENTE----******/
INSERT INTO Cliente (tipo,telefono,direccion,razonSoial,cuit,nombre,dni,apellido) VALUES ('Particular','41112222','Corrientes 1234',NULL,NULL,'Jorge',33900111,'Dominguez');
INSERT INTO Cliente (tipo,telefono,direccion,razonSoial,cuit,nombre,dni,apellido,regularidad) VALUES ('Empresa','41112220','Corrientes 1234','Xelere','20339',NULL,NULL,NULL,'Regular');
INSERT INTO Cliente (tipo,telefono,direccion,razonSoial,cuit,nombre,dni,apellido,regularidad) VALUES ('Empresa','41112226','Corrientes 1234','YPF','20340',NULL,NULL,NULL,'Regular');
INSERT INTO Cliente (tipo,telefono,direccion,razonSoial,cuit,nombre,dni,apellido,regularidad) VALUES ('Empresa','41112221','Corrientes 1234','ESSO','20341',NULL,NULL,NULL,'Frecuente');
INSERT INTO Cliente (tipo,telefono,direccion,razonSoial,cuit,nombre,dni,apellido,regularidad) VALUES ('Empresa','41112224','Corrientes 1234','SHELL','20342',NULL,NULL,NULL,'Regular');
INSERT INTO Cliente (tipo,telefono,direccion,razonSoial,cuit,nombre,dni,apellido,regularidad) VALUES ('Empresa','41112223','Corrientes 1234','GNC','20343',NULL,NULL,NULL,'Frecuente');
INSERT INTO Cliente (tipo,telefono,direccion,razonSoial,cuit,nombre,dni,apellido,regularidad) VALUES ('Empresa','41112221','Corrientes 1234','EDESUR','20344',NULL,NULL,NULL,'Frecuente');
INSERT INTO Cliente (tipo,telefono,direccion,razonSoial,cuit,nombre,dni,apellido,regularidad) VALUES ('Empresa','41112223','Corrientes 1234','MAKRO','20345',NULL,NULL,NULL,'Frecuente');

/******----DIRECCIONESEMPRESA----******/
INSERT INTO DireccionesEmpresa (direccion, tel,empresa) VALUES ('Jorge Newberry 884','47165435',2);
INSERT INTO DireccionesEmpresa (direccion, tel,empresa) VALUES ('Murillo 120','44456753',3);
INSERT INTO DireccionesEmpresa (direccion, tel,empresa) VALUES ('Corrientes 343','451632380',4);
INSERT INTO DireccionesEmpresa (direccion, tel,empresa) VALUES ('Santa Fe 343','41198234',5);
INSERT INTO DireccionesEmpresa (direccion, tel,empresa) VALUES ('Moreno 343','40105234',6);
INSERT INTO DireccionesEmpresa (direccion, tel,empresa) VALUES ('Tacuari 343','41055034',7);


/******----FACTURA----******/
INSERT INTO Factura (total,fecha,cliente_idCliente) VALUES (590,'2014-11-20',1);
INSERT INTO Factura (total,fecha,cliente_idCliente) VALUES (3579,'2014-11-16',2);
INSERT INTO Factura (total,fecha,cliente_idCliente) VALUES (590,'2014-11-15',3);
INSERT INTO Factura (total,fecha,cliente_idCliente) VALUES (5200,'2014-11-20',4);
INSERT INTO Factura (total,fecha,cliente_idCliente) VALUES (1450,'2014-11-15',1);
INSERT INTO Factura (total,fecha,cliente_idCliente) VALUES (590,'2014-11-20',2);
INSERT INTO Factura (total,fecha,cliente_idCliente) VALUES (870,'2014-11-19',3);
INSERT INTO Factura (total,fecha,cliente_idCliente) VALUES (590,'2014-11-19',4);
INSERT INTO Factura (total,fecha,cliente_idCliente) VALUES (1590.45,'2014-11-20',1);
INSERT INTO Factura (total,fecha,cliente_idCliente) VALUES (590,'2014-11-16',2);
INSERT INTO Factura (total,fecha,cliente_idCliente) VALUES (909,'2014-11-15',4);
INSERT INTO Factura (total,fecha,cliente_idCliente) VALUES (1000,'2014-11-14',3);

/******----ITEMFACTURA----******/
INSERT INTO ItemFactura (costo,idFactura) VALUES (20.00,1);
INSERT INTO ItemFactura (costo,idFactura) VALUES (30,2);
INSERT INTO ItemFactura (costo,idFactura) VALUES (40,3);
INSERT INTO ItemFactura (costo,idFactura) VALUES (50,4);
INSERT INTO ItemFactura (costo,idFactura) VALUES (60,5);
INSERT INTO ItemFactura (costo,idFactura) VALUES (10,6);
INSERT INTO ItemFactura (costo,idFactura) VALUES (20,7);
INSERT INTO ItemFactura (costo,idFactura) VALUES (30,5);
INSERT INTO ItemFactura (costo,idFactura) VALUES (40,7);
INSERT INTO ItemFactura (costo,idFactura) VALUES (50,1);
INSERT INTO ItemFactura (costo,idFactura) VALUES (60,1);
INSERT INTO ItemFactura (costo,idFactura) VALUES (10,3);
INSERT INTO ItemFactura (costo,idFactura) VALUES (10,2);
INSERT INTO ItemFactura (costo,idFactura) VALUES (13,5);
INSERT INTO ItemFactura (costo,idFactura) VALUES (45,7);
INSERT INTO ItemFactura (costo,idFactura) VALUES (150,1);
INSERT INTO ItemFactura (costo,idFactura) VALUES (16,1);
INSERT INTO ItemFactura (costo,idFactura) VALUES (20,2);
INSERT INTO ItemFactura (costo,idFactura) VALUES (47,4);
INSERT INTO ItemFactura (costo,idFactura) VALUES (11,4);
INSERT INTO ItemFactura (costo,idFactura) VALUES (35,6);
INSERT INTO ItemFactura (costo,idFactura) VALUES (15,3);
INSERT INTO ItemFactura (costo,idFactura) VALUES (19,3);
INSERT INTO ItemFactura (costo,idFactura) VALUES (21,2);


/******----CUENTACORRIENTE  CAMBIAR CBU A LONG!!!!----******/
INSERT INTO CuentaCorriente (cbu,estado,minimoPermitidoSinAuth,saldoActual,empresa) VALUES (9992,1,2000,1000,2);
INSERT INTO CuentaCorriente (cbu,estado,minimoPermitidoSinAuth,saldoActual,empresa) VALUES (9993,0,1500,0,3);
INSERT INTO CuentaCorriente (cbu,estado,minimoPermitidoSinAuth,saldoActual,empresa) VALUES (9994,1,1500,900,4);
INSERT INTO CuentaCorriente (cbu,estado,minimoPermitidoSinAuth,saldoActual,empresa) VALUES (9995,1,1500,5000,6);
INSERT INTO CuentaCorriente (cbu,estado,minimoPermitidoSinAuth,saldoActual,empresa) VALUES (9996,1,1500,900,4);
INSERT INTO CuentaCorriente (cbu,estado,minimoPermitidoSinAuth,saldoActual,empresa) VALUES (9997,1,1500,5000,5);
INSERT INTO CuentaCorriente (cbu,estado,minimoPermitidoSinAuth,saldoActual,empresa) VALUES (9998,1,1500,100,2);

/******----MOVIMIENTOCUENTA----******/
INSERT INTO MovimientoCuenta (monto,fecha,cbu) VALUES (1000,'2014-11-14',9992);
INSERT INTO MovimientoCuenta (monto,fecha,cbu) VALUES (800,'2014-11-14',9993);
INSERT INTO MovimientoCuenta (monto,fecha,cbu) VALUES (100,'2014-11-14',9994);
INSERT INTO MovimientoCuenta (monto,fecha,cbu) VALUES (1500,'2014-11-14',9995);
INSERT INTO MovimientoCuenta (monto,fecha,cbu) VALUES (7000,'2014-11-14',9996);
INSERT INTO MovimientoCuenta (monto,fecha,cbu) VALUES (400,'2014-11-14',9997);
INSERT INTO MovimientoCuenta (monto,fecha,cbu) VALUES (9500,'2014-11-14',9998);

/******----PRODUCTOSVALIDOS----******/
INSERT INTO ProductosValidos (descripcion,tipo,empresa) VALUES ('Producto X', 'porVolumen', 1);
INSERT INTO ProductosValidos (descripcion,tipo,empresa) VALUES ('CAJA', 'porPeso', 2);
INSERT INTO ProductosValidos (descripcion,tipo,empresa) VALUES ('BOLSA', 'porPeso', 3);
INSERT INTO ProductosValidos (descripcion,tipo,empresa) VALUES ('Cilindro', 'porVolumen',4);
INSERT INTO ProductosValidos (descripcion,tipo,empresa) VALUES ('CAJA XL', 'porVolumen', 5);

/******----PEDIDO----******/
INSERT INTO Pedido(manifiesto,dirDestino,prioridad,horarioDeEntregaDesde, horarioDeEntregahasta,dirDeRetiroSoloEmpresa,fechaEnregaMaxima,condEspeciales,fechaEntregaEstimada,estado,cliente_idCliente,numeroSucursal)VALUES('Pedido de Cajas','Oronio 150, Rosario, Santa Fe',1,'10:00:00','18:00:00','Av. Corrientes 2030','2014-11-27','Ninguna','2014-11-25','ENTREGADO', 1,1);
INSERT INTO Pedido(manifiesto,dirDestino,prioridad,horarioDeEntregaDesde, horarioDeEntregahasta,dirDeRetiroSoloEmpresa,fechaEnregaMaxima,condEspeciales,fechaEntregaEstimada,estado,cliente_idCliente,numeroSucursal)VALUES('Cartones','Justo 250, Cordoba, Santa Fe',1,'10:00:00','18:00:00','Araoz 1950','2014-11-28','Ninguna','2014-11-26','DESPACHADO', 2,1);
INSERT INTO Pedido(manifiesto,dirDestino,prioridad,horarioDeEntregaDesde, horarioDeEntregahasta,dirDeRetiroSoloEmpresa,fechaEnregaMaxima,condEspeciales,fechaEntregaEstimada,estado,cliente_idCliente,numeroSucursal)VALUES('Pedido de Cajas L','Moreno 350, Rosario, Santa Fe',2,'11:00:00','19:00:00','Av. Cordoba 6530','2014-11-29','Ninguna','2014-11-27','SIN_PROCESAR', 3,2);
INSERT INTO Pedido(manifiesto,dirDestino,prioridad,horarioDeEntregaDesde, horarioDeEntregahasta,dirDeRetiroSoloEmpresa,fechaEnregaMaxima,condEspeciales,fechaEntregaEstimada,estado,cliente_idCliente,numeroSucursal)VALUES('Despacho Productos','Nicasio 450, Cordoba, Santa Fe',2,'8:00:00','17:30:00','AV. Corrientes 1030','2014-11-30','Ninguna','2014-11-28','SIN_PROCESAR', 4,2);
INSERT INTO Pedido(manifiesto,dirDestino,prioridad,horarioDeEntregaDesde, horarioDeEntregahasta,dirDeRetiroSoloEmpresa,fechaEnregaMaxima,condEspeciales,fechaEntregaEstimada,estado,cliente_idCliente,numeroSucursal)VALUES('Pedido de Cajas S','Juan B. Justo 50, Capital Federal',1,'8:30:00','16:30:00','Suipacha 112','2014-12-01','Ninguna','2014-11-28','DESPACHADO', 1,3);
INSERT INTO Pedido(manifiesto,dirDestino,prioridad,horarioDeEntregaDesde, horarioDeEntregahasta,dirDeRetiroSoloEmpresa,fechaEnregaMaxima,condEspeciales,fechaEntregaEstimada,estado,cliente_idCliente,numeroSucursal)VALUES('Pedido de Cajas XS','Coronel Diaz 150, Bernal, Provincia de Buenos Aires',1,'10:00:00','18:00:00','Chile 207','2014-12-02','Ninguna','2014-11-28','DESPACHADO', 2,5);
INSERT INTO Pedido(manifiesto,dirDestino,prioridad,horarioDeEntregaDesde, horarioDeEntregahasta,dirDeRetiroSoloEmpresa,fechaEnregaMaxima,condEspeciales,fechaEntregaEstimada,estado,cliente_idCliente,numeroSucursal)VALUES('Pedido de Cajas XS','Paraguay 350, Capital Federal',3,'10:00:00','18:00:00','Uriburu 2679','2014-12-03','Ninguna','2014-11-28','DESPACHADO', 3,4);
INSERT INTO Pedido(manifiesto,dirDestino,prioridad,horarioDeEntregaDesde, horarioDeEntregahasta,dirDeRetiroSoloEmpresa,fechaEnregaMaxima,condEspeciales,fechaEntregaEstimada,estado,cliente_idCliente,numeroSucursal)VALUES('Pedido de Bolsas','Montevideo 450, Capital Federal',1,'10:00:00','20:00:00','Moldes 1940','2014-12-04','Ninguna','2014-11-29','DESPACHADO', 4,4);


/******----CONSIDERACIONESPECIAL----******/
INSERT INTO ConsideracionEspecial (requiereAvioneta,autorizacionAvioneta,requiereCamionExterno,entregaInmediata,costoExtra,idPedido) VALUES (1,1,1,1,1000,2);
INSERT INTO ConsideracionEspecial (requiereAvioneta,autorizacionAvioneta,requiereCamionExterno,entregaInmediata,costoExtra,idPedido) VALUES (0,0,1,1,450,3);
INSERT INTO ConsideracionEspecial (requiereAvioneta,autorizacionAvioneta,requiereCamionExterno,entregaInmediata,costoExtra,idPedido) VALUES (0,0,1,1,450,4);

/******----CARRIER----******/
INSERT INTO Carrier (origen, destino , costo ,idConsideracionEspecial) VALUES ('Buenos Aires', 'Cordoba', 6700, 1);
INSERT INTO Carrier (origen, destino , costo ,idConsideracionEspecial) VALUES ('Buenos Aires', 'Cordoba', 4200, 2);
INSERT INTO Carrier (origen, destino , costo ,idConsideracionEspecial) VALUES ('Buenos Aires', 'Rosario', 2700, 3);


/******----VEHICULOEXTERNO----******/
INSERT INTO VehiculoExterno (tipo,identificacion,capacidadCarga,idConsideracionEspecial) Values ('Camion', 'GPI 451', 4500, 1);

/******----VEHICULO----******/
INSERT INTO Vehiculo(nroChasis,condEspeciales,estado,tipo,patente,pesoMax,tara,volumenMax,modelo,kilometrakeActual,numeroPolizaSeguro,expiracionGarantia,coordenadaActual,kilometrajemaximo,numeroSucursal) VALUES (00001,'Ninguna','DESPACHADO','Camion', 'AAA 001', 4000, 19000, 24000,'2014-01-01',215000,010100,'2017-01-01','202 203',560000,1);
INSERT INTO Vehiculo(nroChasis,condEspeciales,estado,tipo,patente,pesoMax,tara,volumenMax,modelo,kilometrakeActual,numeroPolizaSeguro,expiracionGarantia,coordenadaActual,kilometrajemaximo,numeroSucursal) VALUES (00002,'Ninguna','DESPACHADO','Camion', 'BBB 001', 4000, 19000, 24000,'2014-01-01',215000,011100,'2017-01-01','202 203',560000,2);
INSERT INTO Vehiculo(nroChasis,condEspeciales,estado,tipo,patente,pesoMax,tara,volumenMax,modelo,kilometrakeActual,numeroPolizaSeguro,expiracionGarantia,coordenadaActual,kilometrajemaximo,numeroSucursal) VALUES (00003,'Ninguna','MEDIA_CARGA','Moto', 'CCC 001', 4000, 19000, 24000,'2014-01-01',215000,010000,'2017-01-01','202 203',560000,3);
INSERT INTO Vehiculo(nroChasis,condEspeciales,estado,tipo,patente,pesoMax,tara,volumenMax,modelo,kilometrakeActual,numeroPolizaSeguro,expiracionGarantia,coordenadaActual,kilometrajemaximo,numeroSucursal) VALUES (00004,'Ninguna','DESPACHADO','Camion', 'DDD 001', 4000, 19000, 24000,'2014-01-01',215000,012100,'2017-01-01','202 203',560000,4);
INSERT INTO Vehiculo(nroChasis,condEspeciales,estado,tipo,patente,pesoMax,tara,volumenMax,modelo,kilometrakeActual,numeroPolizaSeguro,expiracionGarantia,coordenadaActual,kilometrajemaximo,numeroSucursal) VALUES (00005,'Ninguna','DESPACHADO','Furgoneta', 'EEE 001', 4000, 19000, 24000,'2014-01-01',215000,022100,'2017-01-01','202 203',560000,5);
INSERT INTO Vehiculo(nroChasis,condEspeciales,estado,tipo,patente,pesoMax,tara,volumenMax,modelo,kilometrakeActual,numeroPolizaSeguro,expiracionGarantia,coordenadaActual,kilometrajemaximo,numeroSucursal) VALUES (00006,'Ninguna','DISPONIBLE','Furgoneta', 'FFF 001', 4000, 19000, 24000,'2014-01-01',215000,022100,'2017-01-01','202 203',560000,2);
INSERT INTO Vehiculo(nroChasis,condEspeciales,estado,tipo,patente,pesoMax,tara,volumenMax,modelo,kilometrakeActual,numeroPolizaSeguro,expiracionGarantia,coordenadaActual,kilometrajemaximo,numeroSucursal) VALUES (00006,'Ninguna','DISPONIBLE','Furgoneta', 'AA1 001', 4000, 19000, 24000,'2014-01-01',215000,022100,'2017-01-01','202 203',560000,2);

/******----REMITO----******/
INSERT INTO Remito (nroRemito,estado,patente) VALUES (000001,'DESPACHADO','AAA 001');
INSERT INTO Remito (nroRemito,estado,patente) VALUES (000002,'DESPACHADO','BBB 001');
INSERT INTO Remito (nroRemito,estado,patente) VALUES (000003,'ENTREGADO','CCC 001');
INSERT INTO Remito (nroRemito,estado,patente) VALUES (000004,'ENTREGADO','DDD 001');

/******----MERCADERIA----******/
INSERT INTO Mercaderia (tipo,cantApilable,condDeViaje,coordenadasDestino,profundidad,indicacionesManpulacion,fragilidad,apilable,ancho,alto,peso,volumen,nroRemito,idDeposito,idPedido) VALUES ('porPeso',40,'Ninguna','300-250',20,'Fragil',1,20,10,0.560,133.33,10.1,0001,1,1);
INSERT INTO Mercaderia (tipo,cantApilable,condDeViaje,coordenadasDestino,profundidad,indicacionesManpulacion,fragilidad,apilable,ancho,alto,peso,volumen,nroRemito,idDeposito,idPedido) VALUES ('porVolumen',80,'Ninguna','301-251',30,'Ninguna',1,10,20,0.340,10.1,200,0002,2,2);
INSERT INTO Mercaderia (tipo,cantApilable,condDeViaje,coordenadasDestino,profundidad,indicacionesManpulacion,fragilidad,apilable,ancho,alto,peso,volumen,nroRemito,idDeposito,idPedido) VALUES ('porVolumen',80,'Ninguna','301-251',30,'Ninguna',1,10,20,0.340,10.1,200,null,1,3);
INSERT INTO Mercaderia (tipo,cantApilable,condDeViaje,coordenadasDestino,profundidad,indicacionesManpulacion,fragilidad,apilable,ancho,alto,peso,volumen,nroRemito,idDeposito,idPedido) VALUES ('porVolumen',80,'Ninguna','301-251',30,'Ninguna',1,10,20,0.340,10.1,200,null,1,4);



/******----MOVIMIENTO----******/
INSERT INTO Movimiento (estado,fechaSalida,condicionDeArribo,fechaLlegada,origen,destino,idMercaderia) VALUES ('En Condiciones', '2014-11-10', 'En Hora', '2014-11-20','Buenos Aires', 'Cordoba',2);
INSERT INTO Movimiento (estado,fechaSalida,condicionDeArribo,fechaLlegada,origen,destino,idMercaderia) VALUES ('Con marcas en caja', '2014-11-10', 'Atrasado', '2014-11-20','Buenos Aires', 'Rosario',2);

/******----PLANDEMANTENIMIENTO----******/
INSERT INTO PlanDeMantenimiento (tipo,cantKilometros,controlEspecial,patente) VALUES ('Cambio Aceite',10000,'Ninguno','AAA 001');
INSERT INTO PlanDeMantenimiento (tipo,cantKilometros,controlEspecial,patente) VALUES ('Arreglo Ventana',250,'Ninguno','BBB 001');

/******----MANTENIMIENTOREALIZADO----******/
INSERT INTO MantenimientoRealizado (descripcion,fecha,tipo,kilometrajeActual,costo,kilometrosRealizadosDesdeUltimoControl,patente) VALUES ('Cambio de Aceite', '2014-11-14','motor',10000,57000,100000,'AAA 001');
INSERT INTO MantenimientoRealizado (descripcion,fecha,tipo,kilometrajeActual,costo,kilometrosRealizadosDesdeUltimoControl,patente) VALUES ('Chapa y Pintura', '2014-11-14','chasis',20000,14000,10000,'BBB 001');
INSERT INTO MantenimientoRealizado (descripcion,fecha,tipo,kilometrajeActual,costo,kilometrosRealizadosDesdeUltimoControl,patente) VALUES ('Arreglo Ventana', '2014-11-14','interior',20000,35000,10000,'CCC 001');
INSERT INTO MantenimientoRealizado (descripcion,fecha,tipo,kilometrajeActual,costo,kilometrosRealizadosDesdeUltimoControl,patente) VALUES ('Limpieza', '2014-11-14','motor',10020,26000,10000,'DDD 001');
--------------------------------





