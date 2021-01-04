--Mostrar tudo sobre todos os atletas
select *
  from Atleta;

--Mostrar o nic e o nome dos atletas femininos
select nic, nome
  from Atleta
 where genero = 'F';
 
--Mostrar tudo sobre os atletas femininos, ordenando por nome
select *
  from Atleta
 where genero = 'F'
 order by nome;

--Mostrar tudo sobre os atletas femininos, ordenando por nome de forma decrescente
select *
  from Atleta
 where genero = 'F'
 order by nome desc;

--Mostrar tudo sobre os atletas, ordenando por género (crescente) e nome (descendente)
select *
  from Atleta
 order by genero, nome desc;

--Mostrar todos os atletas cujo nome contém 'Mc'
--LIKE
--Metacarateres: % (qualquer sequência de carateres) _ (um único carater na posição em que estiver)
select *
  from Atleta
 where nome like '%Mc%';

--Mostrar todos os atletas cujo primeiro nome começa por 'A' e o último por 'M'
select *
  from Atleta
 where nome like 'A% M%';

--Mostrar as competições que têm '%' no seu nome
select *
  from Competicao
 where nome like '%\%%' escape '\';

--Mostrar o nic e o nome dos atletas e o nome das competições em que participaram (INNER JOINs)
--A coluna nome da competição deve chamar-se nome_competicao
select a.nic, a.nome, c.nome nome_competicao
  from Atleta a join Participa b on (a.id = b.id_atleta)
                join Competicao c on (b.id_competicao = c.id);

select a.nic, a.nome, c.nome nome_competicao
  from Atleta a, Participa b, Competicao c
 where a.id = b.id_atleta and b.id_competicao = c.id;

--Mostrar o nic e o nome dos atletas que nunca participaram em competições
select nic, nome
  from Atleta
 where id not in (select id_atleta from Participa);

select b.nic, b.nome
  from
( 
select id
  from Atleta
 minus
select id_atleta
  from Participa
) a join Atleta b on (a.id = b.id);

select nic, nome
  from Atleta
 where not exists (select * from Participa where id_atleta = Atleta.id);

--Mostrar o nic e o nome dos atletas femininos que nunca participaram em competições
select nic, nome
  from Atleta
 where id not in (select id_atleta from Participa)
   and genero = 'F';

--Mostrar o id dos atletas e o número de competições em que participaram,
--ordenado por número de competições e id de atleta.
select id_atleta, count(*) competicoes
  from Participa
 group by id_atleta
 order by 2, 1;
         
--Obter o nic e o nome dos atletas e o número de competições em que participaram,
--ordenado por número de competições e nome do atleta
select b.nic, b.nome, a.competicoes
  from (select id_atleta, count(*) competicoes
          from Participa
         group by id_atleta) a join Atleta b on (a.id_atleta = b.id)
 order by a.competicoes, b.nome;

--Obter o nic e o nome dos atletas e o número de competições em que participaram, 
--ordenado por número de competições e nome do atleta
--Os atletas que não participaram em competições também devem ser mostrados
select b.nic, b.nome, nvl(a.competicoes, 0) competicoes
  from (select id_atleta, count(*) competicoes
          from Participa
         group by id_atleta) a right join Atleta b on (a.id_atleta = b.id)
 order by nvl(a.competicoes, 0), b.nome;

select nic, nome
     , (select count(*)
          from Participa
         where id_atleta = Atleta.id) competicoes
  from Atleta
 order by 3, nome;

--Obter o nic e o nome dos atletas e o número de competições em que participaram 
--para os atletas que participaram em mais do que 2 competições,
--ordenado por número de competições e nome do atleta
select *
  from
(
select nic, nome
     , (select count(*)
          from Participa
         where id_atleta = Atleta.id) competicoes
  from Atleta
)
 where competicoes >= 2
 order by 3, nome;

select b.nic, b.nome, a.competicoes
  from (select id_atleta, count(*) competicoes
          from Participa
         group by id_atleta
        having count(*)>=2) a join Atleta b on (a.id_atleta = b.id)
 order by a.competicoes, b.nome;

with w1 as
(select id_atleta, count(*) competicoes
   from Participa
  group by id_atleta)
select b.nic, b.nome, a.competicoes
  from (select *
          from w1
         where competicoes>=2) a join Atleta b on (a.id_atleta = b.id)
 order by a.competicoes, b.nome;

--Obter o nic e o nome dos atletas e o número de competições em que participaram em mais competições,
--ordenado por número de competições e nome do atleta
with w1 as
(select id_atleta, count(*) competicoes
   from Participa
  group by id_atleta)
select b.nic, b.nome, a.competicoes
  from (select *
          from w1
         where competicoes>=(select max(competicoes) from w1)) a join Atleta b on (a.id_atleta = b.id)
 order by a.competicoes, b.nome;

--Obter o id do atleta e o número de atividades que pratica ordenando por ordem decrescente 
--do número de atividades
select a.id, count(*)
  from Atleta a join AtividadeAtleta b on (a.id = b.id_atleta)
 group by a.id
 order by 2 desc;

--Obter os atletas que praticam todas as atividades
select *
  from Atleta
 where not exists(select id
                    from Atividade
                   minus
                  select id_atividade
                    from AtividadeAtleta
                   where id_atleta = Atleta.id); 
                   
--Obter os atletas que participaram em todas as competições em que poderiam participar.
select *
  from Atleta
 where not exists (select id
                     from Competicao a join AtividadeAtleta b on (a.id_atividade = b.id_atividade)
                    where b.id_atleta = Atleta.id
                    minus
                   select id_competicao
                     from Participa
                    where id_atleta = Atleta.id);
                    
--Obter os registos de atletas que não têm correspondência na tabela de tipos de atleta
select *
  from Atleta
 where id not in (select id
                    from Profissional
                   union
                  select id
                    from SemiProfissional
                   union
                  select id
                    from Amador);

--Escrever um conjunto de instruções que permitam carregar todos os registos que foram obtidos
--na alínea anterior.
insert into Profissional(id)
select id
  from Atleta
 where tipo_atleta = 1;
 
insert into SemiProfissional(id)
select id
  from Atleta
 where tipo_atleta = 2;

insert into Amador(id)
select id
  from Atleta
 where tipo_atleta = 3;



select nvl(max(id),0)+1 from atleta;

--Criar um procedimento para criar atletas
--Os parâmetros do procedimento devem ser: nome, nic, género, data de nascimento e tipo de atleta
--Os parâmetros obrigatórios devem ser: nome, nic e tipo de atleta
create or replace procedure criarAtleta(
  p_nome Atleta.nome%type,
  p_nic Atleta.nic%type,
  p_genero Atleta.genero%type default null,
  p_data_nascimento Atleta.data_nascimento%type default null,
  p_tipo_atleta Atleta.tipo_atleta%type)
is
  v_id int;
begin
  select nvl(max(id), 0)+1 into v_id from Atleta;
  insert into Atleta(id, nome, nic, genero, data_nascimento, tipo_atleta)
  values(v_id, p_nome, p_nic, p_genero, p_data_nascimento, p_tipo_atleta);
  /*
  if p_tipo_atleta = 1 then
    insert into Profissional(id) values(v_id);
  elsif p_tipo_atleta = 2 then
    insert into SemiProfissional(id) values(v_id);
  elsif p_tipo_atleta = 3 then
    insert into Amador(id) values(v_id);
  end if;
  */
end;
/

begin
  --Criar o atleta Speedy Gonzalez, nic 18662716, masculino, profissional
  --Versão errada...
  --criarAtleta('Speedy Gonzalez', '18662716', 'M', 1);
  --Definindo os nomes dos argumentos
  criarAtleta(p_nome => 'Speedy Gonzalez', p_nic => '18662716', p_genero => 'M', p_tipo_atleta => 1);
end;
/

select * from atleta where id > 100;
select * from semiprofissional where id > 100;

update Atleta set tipo_atleta = 2 where id = 101;
delete from atleta where id = 101;

--Com o procedimento conseguimos garantir a coerência entre o tipo de atleta e a tabela do tipo respetiva, mas...
--Continuamos a poder ter inconsistência se...
--a) não se usar o procedimento
--b) se fizerem eliminações de registos nas tabelas de tipos
--c) se se alterar o tipo de atleta na tabela atleta
--Resolvemos este problema com triggers

create or replace trigger trgAtleta after insert or update on Atleta for each row
begin
  if inserting then
    if :new.tipo_atleta = 1 then
      insert into Profissional(id) values(:new.id);
    elsif :new.tipo_atleta = 2 then
      insert into SemiProfissional(id) values(:new.id);
    elsif :new.tipo_atleta = 3 then
      insert into Amador(id) values(:new.id);
    end if;
  elsif updating then
    if :new.tipo_atleta != :old.tipo_atleta then
      if :new.tipo_atleta = 1 then
        insert into Profissional(id) values(:new.id);
      elsif :new.tipo_atleta = 2 then
        insert into SemiProfissional(id) values(:new.id);
      elsif :new.tipo_atleta = 3 then
        insert into Amador(id) values(:new.id);
      end if;
      --
      if :old.tipo_atleta = 1 then
        delete from Profissional where id = :old.id;
      elsif :old.tipo_atleta = 2 then
        delete from SemiProfissional where id = :old.id;
      elsif :old.tipo_atleta = 3 then
        delete from Amador where id = :old.id;
      end if;
    end if;
  end if;
end;
/

--Testar... Alterar o procedimento para não fazer o insert na tabela do tipo

create or replace procedure criarAtleta(
  p_nome Atleta.nome%type,
  p_nic Atleta.nic%type,
  p_genero Atleta.genero%type default null,
  p_data_nascimento Atleta.data_nascimento%type default null,
  p_tipo_atleta Atleta.tipo_atleta%type)
is
  v_id int;
begin
  select nvl(max(id), 0)+1 into v_id from Atleta;
  insert into Atleta(id, nome, nic, genero, data_nascimento, tipo_atleta)
  values(v_id, p_nome, p_nic, p_genero, p_data_nascimento, p_tipo_atleta);
end;
/

begin
  --Criar a atleta Speedy Gonzalina, nic 11515111, feminino, profissional
  criarAtleta(p_nome => 'Speedy Gonzalina', p_nic => '11515111', p_genero => 'F', p_tipo_atleta => 1);
end;
/

select * from atleta where id > 100;
select * from profissional where id > 100;
select * from amador where id > 100;

--Alterar o tipo de atleta de profissional para amador
update atleta
   set tipo_atleta = 3
 where id = 101;

