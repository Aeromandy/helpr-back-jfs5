use helpr;

CREATE TABLE log_usuario(
idusuario INTEGER NOT NULL,
nome VARCHAR(150) NOT NULL,
perfil VARCHAR(150) NOT NULL,
DType VARCHAR(100) NOT NULL,
dataAlteracao DATE NOT NULL
);

DELIMITER //

CREATE TRIGGER tg_log_usuarios
BEFORE UPDATE ON usuarios
FOR EACH ROW 

BEGIN
	INSERT INTO log_usuario (idusuario, nome, perfil, DType, dataAlteracao) VALUES(OLD.id, OLD.nome, OLD.perfil, OLD.dtype, CURRENT_DATE());
END//

DELIMITER ;

DESCRIBE usuarios;

SELECT * FROM usuarios;

UPDATE usuarios SET nome = 'Ismael' WHERE id = 2;

SELECT * FROM log_usuario;

