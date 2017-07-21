INSERT INTO PERFIL (Id, Nome) VALUES (100, 'Administrador');
INSERT INTO PERFIL (Id, Nome) VALUES (101, 'TI');
INSERT INTO PERFIL (Id, Nome) VALUES (200, 'Gestor');
INSERT INTO PERFIL (Id, Nome) VALUES (300, 'Back-office');
INSERT INTO PERFIL (Id, Nome) VALUES (400, 'Vendedor');

INSERT INTO MENU (Id, Nome, Caminho) VALUES (1000, 'Usuários', 'usuarios');
INSERT INTO MENU (Id, Nome, Caminho) VALUES (2000, 'Filiais', 'filiais');
INSERT INTO MENU (Id, Nome, Caminho) VALUES (3000, 'Produtos', 'produtos');
INSERT INTO MENU (Id, Nome, Caminho) VALUES (3001, 'Coleções', 'colecoes');
INSERT INTO MENU (Id, Nome, Caminho) VALUES (5000, 'PDV', 'venda');
INSERT INTO MENU (Id, Nome, Caminho) VALUES (6000, 'Relatório', 'rel-vendas-geral');
INSERT INTO MENU (Id, Nome, Caminho) VALUES (7000, 'Clientes', 'clientes');

INSERT INTO MENUPERFIL (IdMenu, IdPerfil) VALUES (1000, 100);
INSERT INTO MENUPERFIL (IdMenu, IdPerfil) VALUES (2000, 100);
INSERT INTO MENUPERFIL (IdMenu, IdPerfil) VALUES (1000, 101);
INSERT INTO MENUPERFIL (IdMenu, IdPerfil) VALUES (3000, 300);
INSERT INTO MENUPERFIL (IdMenu, IdPerfil) VALUES (3001, 300);
INSERT INTO MENUPERFIL (IdMenu, IdPerfil) VALUES (5000, 400);
INSERT INTO MENUPERFIL (IdMenu, IdPerfil) VALUES (7000, 400);
INSERT INTO MENUPERFIL (IdMenu, IdPerfil) VALUES (6000, 200);

INSERT INTO COLECAO (Nome, Periodo, Ano, Ativo, DataCadastro) VALUES ('Fashion Week', 'Ano Todo', 2017, TRUE, '2017-05-01');
INSERT INTO COLECAO (Nome, Periodo, Ano, Ativo, DataCadastro) VALUES ('Curtindo o verão', 'Verão', 2017, TRUE, '2017-05-01');
INSERT INTO COLECAO (Nome, Periodo, Ano, Ativo, DataCadastro) VALUES ('Universo Marvel', 'Ano todo', 2017, TRUE, '2017-05-01');
INSERT INTO COLECAO (Nome, Periodo, Ano, Ativo, DataCadastro) VALUES ('Básico', 'Ano todo', 2017, TRUE, '2017-05-01');

INSERT INTO PRODUTO (Codigo, Nome, Descricao, IdColecao, Tipo, Cor, ValorProducao, ValorVenda, Ativo, DataCadastro) VALUES ('02CABR0010', 'Camiseta', 'Camiseta básica gola V', 1, 'tipo01', 'Azul', 9.7, 19.9, TRUE, '2017-05-16');
INSERT INTO PRODUTO (Codigo, Nome, Descricao, IdColecao, Tipo, Cor, ValorProducao, ValorVenda, Ativo, DataCadastro) VALUES ('02CABR0011', 'Vestido', 'Vestido com estampa florida para dia a dia', 1, 'tipo01', 'Estapado', 11.70, 59.9, TRUE, '2017-05-16');
INSERT INTO PRODUTO (Codigo, Nome, Descricao, IdColecao, Tipo, Cor, ValorProducao, ValorVenda, Ativo, DataCadastro) VALUES ('02CABR0012', 'Moletom Marvel', 'Agasalho com capuz', 3, 'tipo01', 'Vermelho', 31.0, 129.1, TRUE, '2017-05-16');
INSERT INTO PRODUTO (Codigo, Nome, Descricao, IdColecao, Tipo, Cor, ValorProducao, ValorVenda, Ativo, DataCadastro) VALUES ('02CABR0013', 'Pcte Meias', 'Conjunto com 6 pares de meia', 4, 'tipo01', 'Branco/Cinza', 6.8, 23.5, TRUE, '2017-05-16');
INSERT INTO PRODUTO (Codigo, Nome, Descricao, IdColecao, Tipo, Cor, ValorProducao, ValorVenda, Ativo, DataCadastro) VALUES ('02CABR0014', 'Calça jeans', 'Calça jeans slim', 1, 'tipo01', 'Azul', 17.8, 99.0, TRUE, '2017-05-16');

INSERT INTO FILIAL (Nome, Cnpj, Matriz, Ativo, DataCadastro) VALUES ('MATRIZ - SP', '0885453000154', TRUE, TRUE, '2017-05-10');
INSERT INTO FILIAL (Nome, Cnpj, Matriz, Ativo, DataCadastro) VALUES ('Loja 1 - PR', '0885453000254', FALSE, TRUE, '2017-05-10');
INSERT INTO FILIAL (Nome, Cnpj, Matriz, Ativo, DataCadastro) VALUES ('Loja 2 - MG', '0885453000354', FALSE, TRUE, '2017-05-10');


INSERT INTO USUARIO (IdPerfil, IdFilial, Nome, Email, Login, Senha, Ativo, DataCadastro) VALUES (100, 1, 'Adminitrador', 'admin@kkcoolwear.com.br', 'admin', '$2a$10$wPu4O.TXLeIsfcbxwZ9UQuf5yDyiX4fASk5QlOPAZ3OfCZZg./XEi', TRUE, '2017-05-01');


--USUARIO MASTER - todos os menus
INSERT INTO LOJA.PERFIL VALUES (500, 'master');
INSERT INTO LOJA.MENUPERFIL VALUES (1000, 500);
INSERT INTO LOJA.MENUPERFIL VALUES (2000, 500);
INSERT INTO LOJA.MENUPERFIL VALUES (3000, 500);
INSERT INTO LOJA.MENUPERFIL VALUES (3001, 500);
INSERT INTO LOJA.MENUPERFIL VALUES (5000, 500);
INSERT INTO LOJA.MENUPERFIL VALUES (6000, 500);
INSERT INTO LOJA.MENUPERFIL VALUES (7000, 500);
INSERT INTO USUARIO (IdPerfil, IdFilial, Nome, Email, Login, Senha, Ativo, DataCadastro) VALUES (500, 1, 'master', 'master@master.com', 'master', '$2a$10$bGjTYTfQNfybErNO8YpCPOsXqgVmx9mbxj1TyL04xcs9ytMwIvwr6', true, '2017-06-04');


INSERT INTO CLIENTE (Nome, Cpf, Sexo, DataNascimento, Ativo, DataCadastro) VALUES ('Gabriela Leandro', '33350066828','Feminino','1994-02-18', true, '2017-06-06');
INSERT INTO CLIENTE (Nome, Cpf, Sexo, DataNascimento, Ativo, DataCadastro) VALUES ('Gabriel Malta', '35104624838','Masculino','1987-11-04', true, '2017-05-07');
INSERT INTO CLIENTE (Nome, Cpf, Sexo, DataNascimento, Ativo, DataCadastro) VALUES ('Karolina Kallajian', '41590156463','Feminino','1989-10-26', true, '2016-06-06');
INSERT INTO CLIENTE (Nome, Cpf, Sexo, DataNascimento, Ativo, DataCadastro) VALUES ('Ana Paula', '22663228427','Feminino','1984-03-23', true, '2017-06-06');
