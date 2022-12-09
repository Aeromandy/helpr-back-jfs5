use helpr_db;

CREATE TABLE log_chamado(
idchamado INTEGER NOT NULL,
status VARCHAR(150) NOT NULL,
titulo VARCHAR(150) NOT NULL,
idfuncionario INTEGER,
idcliente INTEGER NOT NULL,
dataAlteracao DATE NOT NULL
);

DELIMITER //

CREATE TRIGGER tg_log_chamado
BEFORE UPDATE ON chamado
FOR EACH ROW

BEGIN
	INSERT INTO log_chamado (idchamado, status, titulo, idfuncionario, idcliente, dataAlteracao) 
    VALUES(OLD.id_chamado, OLD.status, OLD.titulo, OLD.id_funcionario, OLD.id_cliente, CURRENT_DATE());
END//

DELIMITER ;

DESCRIBE chamado;

SELECT * FROM chamado;

UPDATE chamado SET status = 'Atribuido' WHERE id_chamado = 1;
UPDATE chamado SET titulo = 'Segundo chamado do sistema' WHERE id_chamado = 2;
UPDATE chamado SET id_funcionario = '2' WHERE id_chamado = 1;
UPDATE chamado SET id_cliente = '2' WHERE id_chamado = 2;

SELECT * FROM log_chamado;

