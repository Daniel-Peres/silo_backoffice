SELECT * FROM silo.usuario;
SELECT * FROM silo.veiculo;
SELECT * FROM silo.equipamento;
SELECT * FROM silo.empresa;
SELECT * FROM silo.historico;

INSERT INTO empresa (`id`,`empresa_nome`) VALUES (1, 'SPtrans');
INSERT INTO empresa (`id`,`empresa_nome`) VALUES (2, 'ViaSul');
INSERT INTO empresa (`id`,`empresa_nome`) VALUES (3, 'MoveBus');
INSERT INTO empresa (`id`,`empresa_nome`) VALUES (4, 'TransUniao');

INSERT INTO usuario (`id`,  `nome`, `senha`,`empresa_id`) VALUES (1, 'admin', '$2a$10$ophOvFxBTwhbHsJ51OANTuP2VZRsHrtjR3rbpvXxlYEk7/rNx2M2q',1);
INSERT INTO usuario (`id`,  `nome`, `senha`,`empresa_id`) VALUES (2, 'Daniel', '$2a$10$5AamCX5MQSrcXqaTQDWege3fIasqi5D.KA7uBGZF5xFPFRIh4ZIWa',2);
INSERT INTO usuario (`id`,  `nome`, `senha`,`empresa_id`) VALUES (3, 'Danielle', '$2a$10$ZAYxlXzXP9QKALUTfwtOp.bVehpLoJsNkDahmkJzzLavgXP/E8mKG',3);
INSERT INTO usuario (`id`,  `nome`, `senha`,`empresa_id`) VALUES (4, 'Edgar', '$2a$10$Yt91QAQfj9KZWb2LhW.rnuz7Li/sft9ZGRNE1g1f.8OHN3eMjXqsa',4);

INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(1,'03/11/2020 - 12:22:00',14,'Lotação - Baixa', 1,1);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(2,'03/11/2020 - 12:35:00',20,'Lotação - Média', 1,1);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(3,'03/11/2020 - 12:42:00',10,'Lotação - Baixa', 1,1);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(4,'04/11/2020 - 10:15:00', 5, 'Lotação - Baixa', 1,1);

INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(5,'04/11/2020 - 10:32:00',22, 'Lotação - Média', 2,2);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(6,'04/11/2020 - 10:40:00',31, 'Lotação - Alta', 2,2);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(7,'05/11/2020 - 12:22:00',40, 'Lotação - Baixa', 2,2);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(8,'05/11/2020 - 12:54:00',24, 'Lotação - Média', 2,2);

INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(9,'05/11/2020 - 11:32:00', 30, 'Lotação - Média', 3,3);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(10,'05/11/2020 - 11:40:00', 20, 'Lotação - Baixa', 3,3);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(11,'05/11/2020 - 11:52:00',14,'Lotação - Baixa', 3,3);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(12,'05/11/2020 - 11:59:00',35,'Lotação - Alta', 3,3);

INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(13,'05/11/2020 - 09:32:00',10,'Lotação - Baixa', 4,4);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(14,'06/11/2020 - 08:22:00', 5, 'Lotação - Baixa', 4,4);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(15,'06/11/2020 - 08:32:00',15, 'Lotação - Baixa', 4,4);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(16,'06/11/2020 - 08:38:00',0, 'Lotação - Vazio', 4,4);

INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(17,'05/11/2020 - 14:32:00',36, 'Lotação - Baixa', 5,5);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(18,'05/11/2020 - 14:40:00',38, 'Lotação - Alta', 5,5);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(19,'05/11/2020 - 14:52:00', 28, 'Lotação - Média', 5,5);
INSERT INTO historico (`id`, `datahora`, `qtd_passageiros`, `status`, `veiculo_id`, `equipamento_id`) VALUES(20,'06/11/2020 - 10:42:12', 40, 'Lotação - Máxima', 5,5);