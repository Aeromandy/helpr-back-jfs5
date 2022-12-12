use helpr;

SELECT * FROM cargo;

CREATE TABLE  bkp_cargo(
	id_cargo INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    descricao VARCHAR(25) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,	
    iniciouEm DATE NOT NULL
);

INSERT INTO cargo (id_cargo, descricao, nome, salario) VALUES (null, "teste", "Fernanda", 2500.0);

DESCRIBE cargo;

SELECT * FROM bkp_cargo;

SELECT * FROM cargo;

DELIMITER //

CREATE TRIGGER tg_bkp_cargo
BEFORE DELETE ON cargo
FOR EACH ROW
BEGIN
	INSERT INTO bkp_cargo (id_cargo, descricao, nome, salario, iniciouEm)
    VALUES(OLD.id_cargo, OLD.descricao, OLD.nome, OLD.salario, current_date());
END//

DELIMITER ;

DELETE FROM cargo WHERE id_cargo = 4;

SELECT * FROM bkp_helpr.bkp_cargos;

SHOW TRIGGERS;

DROP TABLE bkp_cargos;

DROP TRIGGER tg_bkp_cargo;
