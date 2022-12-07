

use helpr;

SELECT * FROM usuarios;


CREATE TABLE bkp_usuarios(
	idUsuario INTEGER PRIMARY KEY AUTO_INCREMENT,
    cpf VARCHAR(11) NOT NULL,
    email VARCHAR(25) NOT NULL,
    nome VARCHAR(150) NOT NULL,
    perfil VARCHAR(25) NOT NULL,
    senha VARCHAR(200) NOT NULL,
    telefone VARCHAR(25),
    foto VARCHAR(255),
    idCargo INTEGER
    
);

INSERT INTO usuarios (dtype, id, cpf, email, nome, perfil, senha, telefone, foto, id_cargo) VALUES ("cliente", null, "61098015002", "gabriel@mail.com", "Gabriel", "ROLE_ADMIN", "12345", "21999999999", null, 1);

DESCRIBE usuarios;

SELECT * FROM bkp_usuarios;

SELECT * FROM usuarios;
DELIMITER //

CREATE TRIGGER th_bkp_usuarios
BEFORE DELETE ON usuarios
FOR EACH ROW
BEGIN
	 
    INSERT INTO bkp_usuarios (idUsuario, cpf, email, nome, perfil, senha, telefone, foto, idCargo)
    VALUES(OLD.id, OLD.cpf, OLD.email, OLD.nome, OLD.perfil, OLD.senha, OLD.telefone, OLD.foto, OLD.id_cargo);
END//

DELIMITER ;
DROP TRIGGER th_bkp_usuarios;

DELETE FROM usuarios WHERE id = 5;