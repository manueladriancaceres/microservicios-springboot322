INSERT INTO usuarios (username,password,enable,nombre,apellido,email) VALUES('jgome1','1234',1,'juan','gomez','jgome1@jg.com');
INSERT INTO usuarios (username,password,enable,nombre,apellido,email) VALUES('jgome2','1234',1,'juan','gomez','jgome2@jg.com');
INSERT INTO usuarios (username,password,enable,nombre,apellido,email) VALUES('jgome3','1234',1,'juan','gomez','jgome3@jg.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id,roles_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id,roles_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id,roles_id) VALUES (2,1);