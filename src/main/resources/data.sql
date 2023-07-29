INSERT INTO usuarios(username, nombre, apellido, password, red_social, fecha_nacimiento,
    enabled, image)
VALUES
('andres.arango@est.iudigital.edu.co','Andres','Arango','',0,'1996-02-18',1, 'https://media.licdn.com/dms/image/D4E03AQHmp_zX1l12sw/profile-displayphoto-shrink_400_400/0/1688243338885?e=1695859200&v=beta&t=Cd2YICW6olMgvxeDjx0YajNX8FvmvZ63tO91hlsugPo');

INSERT INTO roles(nombre,descripcion)
VALUES('ROLE_ADMIN','administrador');

INSERT INTO roles(nombre,descripcion)
VALUES('ROLE_USER','usuario normal');

INSERT INTO roles_usuarios(usuarios_id,roles_id)
VALUES(1,1);

INSERT INTO roles_usuarios(usuarios_id,roles_id)
VALUES(1,2);

INSERT INTO delitos (nombre, descripcion, usuarios_id)
VALUES ('hurto','Cuando lo roban a uno',1);

INSERT INTO delitos (nombre, descripcion, usuarios_id)
VALUES ('homicidio','Cuando lo matan a uno',1);