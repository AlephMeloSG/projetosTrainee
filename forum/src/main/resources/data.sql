INSERT INTO USUARIO(nome, email, senha) VALUES('Arnaldo', 'arnaldo@email.com', '$2a$10$A6R8qlmWeRPp/MY8s/Uq4OxFS7Ihuwvr5/S/sMl/sBolJooBCxC/2');
INSERT INTO USUARIO(nome, email, senha) VALUES('Beatriz', 'beatriz@email.com', '$2a$10$A6R8qlmWeRPp/MY8s/Uq4OxFS7Ihuwvr5/S/sMl/sBolJooBCxC/2');
INSERT INTO USUARIO(nome, email, senha) VALUES('Chaves', 'chaves@email.com', '$2a$10$A6R8qlmWeRPp/MY8s/Uq4OxFS7Ihuwvr5/S/sMl/sBolJooBCxC/2');

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('Photoshop', 'Animation');
INSERT INTO CURSO(nome, categoria) VALUES('Python', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-end, Programação');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor, curso) VALUES('Erro ao criar projeto', 'Erro ao criar projeto', '2019-05-05 18:01:47', 'NAO_RESPONDIDO', 2, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor, curso) VALUES('SpringBoot Fail to init data', 'When i try to run my spring application, he crash and say it: "Fail to run data"', '2019-05-05 16:25:38', 'RESPONDIDO', 3, 3);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor, curso) VALUES('Projeto Spring', 'Meu projeto esta tendo problemas em executar e queria saber se tem alguma maneira de fazer um "AutoRun" no data.sql', '2019-05-05 13:50:21', 'NAO_RESPONDIDO', 1, 2);
