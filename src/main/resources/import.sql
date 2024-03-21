insert into cozinha (id, nome) values (1, 'Japonesa');
insert into cozinha (id, nome) values (2, 'Chinesa');

insert into estado (id, nome) values (1, 'SP');
insert into estado (id, nome) values (2, 'RJ');
insert into estado (id, nome) values (3, 'MG');
insert into estado (id, nome) values (4, 'SC');

insert into cidade (id, nome, estado_id) values (1, 'Mogi das Cruzes', 1)
insert into cidade (id, nome, estado_id) values (2, 'Saquarema', 2)
insert into cidade (id, nome, estado_id) values (3, 'Belo Horizonte', 3)

insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (1, 'ChinChin', 10, 1, utc_timestamp, utc_timestamp, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (2, 'ChinChin Delivery', 9.00, 1, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (3, 'Doggo', 9.50, 2, utc_timestamp, utc_timestamp);

insert into forma_pagamento (descricao) values ('Dinheiro');
insert into forma_pagamento (descricao) values ('Cartao');
insert into forma_pagamento (descricao) values ('Pix');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 2), (2, 3), (3, 1)