INSERT INTO usuario(usuario, contrasena, tipo) VALUES
('admin', 'admin', 'Administrador'),
('pedro', 'pedro123', 'Cliente'),
('marta', 'marta123', 'Cliente'),
('lorena', 'lorena123', 'Cliente'),
('lucas', 'lucas123', 'Cliente'),
('juan', 'juan123', 'Cliente');

INSERT INTO cliente(id, dni, nombre, apellido1, apellido2, localidad, domicilio, codigo_postal, fecha_nacimiento, telefono, usuario) VALUES
(0, '02568697R', 'Pedro', 'González', 'Martínez', 'Rivas Vaciamadrid', 'Lago Como, 32', '28521', '2000-05-20 16:30:00', '675325011', 'pedro'),
(1, '54786971L', 'Marta', 'Seijo', 'Domínguez', 'Arganda', 'La verdad, 15', '28741', '1998-10-10 19:00:00', '654145521', 'marta'),
(2, '35268741L', 'Lorena', 'Rodríguez', 'Gil', 'Rivas Vaciamadrid', 'Luxemburgo, 13', '28521', '2002-12-09 10:30:00', '687412350', 'lorena'),
(3, '74879210N', 'Lucas', 'Sánchez', 'Martín', 'Madrid', 'Serrano, 23', '28914', '1985-04-30 20:30:00', '641252541', 'lucas'),
(4, '12065897R', 'Juan', 'Fernández', null, 'Rivas Vaciamadrid', 'Libertad, 25', '28521', '1993-02-24 22:00:00', '698670475', 'juan');

INSERT INTO deporte(id, nombre, precio, horario, num_jugadores, imagen) VALUES
(0, 'Fútbol 11', 50, '17:00-19:00', 23, '/img/futbol11.jpg'),
(1, 'Fútbol 7', 25, '19:00-21:00', 15, '/img/futbol7.jpg'),
(2, 'Beisbol', 30, '12:00-14:00', 23, '/img/beisbol.jpg'),
(3, 'Baloncesto', 40, '12:00-14:00', 10, '/img/baloncesto.jpg'),
(4, 'Pádel', 35, '9:00-11:00', 4, '/img/padel.jpg'),
(5, 'Tenis', 35, '19:00-21:00', 4, '/img/tenis.jpg'),
(6, 'Patinaje', 25, '9:00-11:00', 15, '/img/patinaje.jpg'),
(7, 'Ping Pong', 15, '17:00-19:00', 2, '/img/pingpong.jpg');

INSERT INTO matricula(id, fecha, cliente_id, deporte_id) VALUES
(0, CURRENT_DATE, 0, 0),
(1, CURRENT_DATE, 0, 4),
(2, CURRENT_DATE, 1, 6),
(3, CURRENT_DATE, 2, 5),
(4, CURRENT_DATE, 3, 1),
(5, CURRENT_DATE, 3, 3),
(6, CURRENT_DATE, 4, 2);

INSERT INTO pista(id, localizacion, superficie) VALUES
(0, 'Campo 1', 7000),
(1, 'Campo 2', 2600),
(2, 'Pista Beisbol', 750),
(3, 'Cancha Baloncesto', 420),
(4, 'Pista Pádel', 200),
(5, 'Pista Tenis', 192),
(6, 'Pista Patinaje', 2600),
(7, 'Pabellón', 500);

INSERT INTO material(id, nombre, descripcion, cantidad, deporte_id) VALUES
(0, 'Pelota 11', 'Pelota de fútbol reglamentaria', 8, 0),
(1, 'Pelota 7', 'Pelota de fútbol 7 reglamentaria', 5, 1),
(2, 'Bate', 'Bate de Beisbol reglamentario', 10, 2),
(3, 'Pelota Baloncesto', 'Pelota de baloncesto reglamentaria', 8, 3),
(4, 'Red Pádel', 'Red de pádel separatoria', 2, 4),
(5, 'Red Tenis', 'Red de tenis separatoria', 2, 5),
(6, 'Mesa PingPong', 'Mesa con red y raquetas de ping pong', 4, 7);

INSERT INTO empleado(id, dni, nombre, apellido1, apellido2, sueldo, fecha_nacimiento, fecha_incorporacion) VALUES
(0, '04458687L', 'Carlos', 'Domínguez', null, 1500, '1987-06-10 20:30:00', CURRENT_DATE),
(1, '57812684N', 'María', 'Gil', 'Fernández', 1200, '1975-10-12 14:00:00', CURRENT_DATE),
(2, '01536875L', 'Rodrigo', 'Domínguez', 'Redondo', 1500, '1983-10-05 07:00:00', CURRENT_DATE),
(3, '75368347R', 'Marta', 'Seijo', 'Muñoz', 1300, '1999-12-06 23:45:00', CURRENT_DATE),
(4, '35421365L', 'Francisco', 'Gómez', 'Sarabia', 1250, '2000-10-23 10:00:00', CURRENT_DATE),
(5, '78965221R', 'Gonzalo', 'Piriz', null, 1400, '1979-12-15 15:15:00', CURRENT_DATE),
(6, '65540247M', 'Lucía', 'Pena', 'Pérez', 1000, '1998-04-26 17:45:00', CURRENT_DATE),
(7, '87765054C', 'Hector', 'Uribe', 'Sanz', 2000, '1975-09-09 20:30:00', CURRENT_DATE),
(8, '98321357M', 'Luis', 'Redondo', null, 1900, '1979-10-17 02:45:00', CURRENT_DATE),
(9, '36853541F', 'Isabel', 'Muñoz', 'López', 1700, '1991-07-07 21:00:00', CURRENT_DATE);

INSERT INTO entrenador(id, especialidad, equipo) VALUES
(0, 'Fútbol 7, 11 y sala', 'Rivas F.C.'),
(1, 'Fútbol 7, 11 y sala', 'Rivas Fútbol 7 Club'),
(2, 'Beisball y Softball', 'Rivas Beisball Club'),
(3, 'Baloncesto', 'Rivas Basket Club'),
(4, 'Tenis, padel y frontón', 'Club Tenis Rivas'),
(5, 'Tenis, padel y frontón', 'Club Padel Rivas'),
(6, 'Patinaje y patinaje artístico', 'Patinaje Rivas');


INSERT INTO staff(id, departamento, puesto) VALUES
(7, 'Dirección', 'Gerente'),
(8, 'Gestión', 'Secretario de Gestión'),
(9, 'Recursos Humanos', 'Directora RRHH');

UPDATE deporte set pista_id=0, entrenador_id=0 where id=0;
UPDATE deporte set pista_id=1, entrenador_id=1 where id=1;
UPDATE deporte set pista_id=2, entrenador_id=2 where id=2;
UPDATE deporte set pista_id=3, entrenador_id=3 where id=3;
UPDATE deporte set pista_id=4, entrenador_id=4 where id=4;
UPDATE deporte set pista_id=5, entrenador_id=5 where id=5;
UPDATE deporte set pista_id=6, entrenador_id=6 where id=6;
UPDATE deporte set pista_id=7 where id=7;