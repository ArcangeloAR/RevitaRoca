CREATE TABLE `post` (
	`id` INT(255) NOT NULL AUTO_INCREMENT,
	`titulo` varchar(255) NOT NULL,
	`texto` TEXT(1000) NOT NULL,
	`usuario_id` INT(50) NOT NULL,
	`data` DATETIME NOT NULL,
	`tema_id` INT NOT NULL,
	`ativo` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tema` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`descricao` varchar(255) NOT NULL AUTO_INCREMENT,
	`parceria` BOOLEAN NOT NULL,
	`local` varchar(255) NOT NULL,
	`alimentacao` BOOLEAN NOT NULL,
	`pernoite` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `usuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome_completo` varchar(100) NOT NULL,
	`senha` varchar(50) NOT NULL,
	`email` varchar(100) NOT NULL,
	`tipo` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `post` ADD CONSTRAINT `post_fk0` FOREIGN KEY (`usuario_id`) REFERENCES `usuario`(`id`);

ALTER TABLE `post` ADD CONSTRAINT `post_fk1` FOREIGN KEY (`tema_id`) REFERENCES `tema`(`id`);

