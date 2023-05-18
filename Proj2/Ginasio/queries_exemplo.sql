insert into login values ('cli1', 'cli1');
insert into cliente values (1, '4925-627', '1999-11-19', 'alsantos@ipvc.pt', 23, '123123123', 'Alexandre', '961234567', 'cli1');
insert into planotreino values (1, '2023-05-18', 'ativo', 1, 1);
insert into sala values (1, 's1.1');
insert into aulagrupo values (1, '2023-05-16 16:00:00', 30, 'boxing', 15, 7, 1, 1);
insert into aulagrupo values (2, '2023-06-29 18:00:00', 30, 'yoga', 15, 8, 1, 1);

insert into equipamento values (1, 'halter');
insert into exercicio values (1, 'levantamento uni-lateral', 1);

insert into linhaexercicio values (1, NULL, 20, 3, 10, NULL, 1, 1);
insert into linhaparticipante values (1, 1, 1);
insert into linhaparticipante values (2, 2, 1);

select * from linhaparticipante