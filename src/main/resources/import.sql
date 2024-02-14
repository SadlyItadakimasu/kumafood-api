insert into cozinha (id, nome) values (1, 'Japonesa');
insert into cozinha (id, nome) values (2, 'Chinesa');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('ChinChin', 10.00, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('ChinChin Delivery', 9.00, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Doggo', 9.50, 2);

insert into forma_pagamento (descricao) values ('Dinheiro');
insert into forma_pagamento (descricao) values ('Cartao');
insert into forma_pagamento (descricao) values ('Pix');

insert into estado (id, nome) values (1, 'SP');
insert into estado (id, nome) values (2, 'RJ');
insert into estado (id, nome) values (3, 'MG');
insert into estado (id, nome) values (4, 'SC');

insert into cidade (id, nome, estado_id) values (1, 'Mogi das Cruzes', 1)
insert into cidade (id, nome, estado_id) values (2, 'Saquarema', 2)
insert into cidade (id, nome, estado_id) values (3, 'Belo Horizonte', 3)
