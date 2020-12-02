CREATE TABLE `Postagem` (
	`id` bigint(255) NOT NULL AUTO_INCREMENT,
	`titulo` varchar(255) NOT NULL,
	`texto` TEXT(1000) NOT NULL,
	`parceria` varchar(255) NOT NULL,
	`local` varchar(255) NOT NULL,
	`usuario_id` bigint(255) NOT NULL,
	`tema_id` bigint(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Usuario` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`nome_completo` varchar(100) NOT NULL,
	`senha` varchar(50) NOT NULL,
	`email` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Tema` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`descricao` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Postagem` ADD CONSTRAINT `Postagem_fk0` FOREIGN KEY (`usuario_id`) REFERENCES `Usuario`(`id`);

ALTER TABLE `Postagem` ADD CONSTRAINT `Postagem_fk1` FOREIGN KEY (`tema_id`) REFERENCES `Tema`(`id`);

