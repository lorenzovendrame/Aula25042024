create database mvc;
use mvc;
create table aluno (nome varchar(80) not null, cpf varchar(14) not null primary key, sexo varchar(01) not null);
select * from aluno;
delete from aluno WHERE nome = 'Marcelo';