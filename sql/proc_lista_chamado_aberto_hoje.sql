USE helpr_db;

DELIMITER //

CREATE PROCEDURE proc_reajuste_salario(piso DECIMAL)
BEGIN
	UPDATE funcionario SET salario = salario + 150 WHERE salario <= piso;
END//

DELIMITER ;

CALL proc_reajuste_salario(20000.0);
