begin
  for r in (select 'drop table ' || table_name || ' cascade constraints' cmd
              from user_tables order by table_name)
  loop
    execute immediate(r.cmd);
  end loop;
end;
/

create table Genero(
genero varchar(1)
  constraint pk_Genero primary key
  constraint ck_Genero_genero check (upper(genero) in ('F', 'M')));

create table TipoAtleta(
tipo int
  constraint pk_TipoAtleta primary key,
nome varchar(20));

create table TipoAmador(
tipo int
  constraint pk_TipoAmador primary key,
pct_variavel number(5, 2));

create table TipoSemiProfissional(
tipo int
  constraint pk_TipoSemiProfissional primary key,
pct_fixa number(5, 2));

create table TipoProfissional(
tipo int
  constraint pk_TipoProfissional primary key,
pct_variavel number(5, 2));

create table Atleta(
id int
  constraint pk_Atleta primary key,
nome varchar(50),
nic varchar(15) not null,
  constraint uk_Atleta_nic unique(nic),
genero varchar(1),
data_nascimento date
  constraint ck_Atleta_data check (data_nascimento >= to_date('1940-01-01', 'yyyy-mm-dd')),
tipo_atleta int not null);

create table Amador(
id int
  constraint pk_Amador primary key,
data_filiacao date);

create table SemiProfissional(
id int
  constraint pk_SemiProfissional primary key,
data_filiacao date);

create table Profissional(
id int
  constraint pk_Profissional primary key,
pct_fixa number(5, 2));

create table atividade(
id int
  constraint pk_atividade primary key,
nome varchar(50));

create table competicao(
id int
  constraint pk_Competicao primary key,
data date,
nome varchar(50),
id_atividade int);

create table Participa(
id_atleta int constraint fk_Participa_Atleta references Atleta(id),
id_competicao constraint fk_Participa_Competicao references Competicao(id),
constraint pk_Participa primary key (id_atleta, id_competicao));

create table Premio(
id int constraint pk_premio primary key,
id_atleta int,
id_competicao int,
  constraint fk_Premio_Participa foreign key (id_atleta, id_competicao)
  references Participa(id_atleta, id_competicao),
valor number
  constraint ck_Premio_Valor check(valor > 0));

create table FormulaFCM(
id int
  constraint pk_FormulaFCM primary key,
formula varchar(1000));

create table FormulaFCT(
id int
  constraint pk_FormulaFCT primary key,
formula varchar(1000));

create table FCM(
id_formula int,
genero varchar(1),
id_atividade int,
constraint pk_FCM primary key(id_formula, genero, id_atividade));

create table FCT(
id_formula int
  constraint pk_FCT primary key);

create table Pagamento(
id int
  constraint pk_Pagamento primary key,
data date,
valor number
  constraint ck_Pagamento_Valor check(valor > 0),
id_atleta int);
  
create table AtividadeAtleta(
id_atleta int,
id_atividade int,
constraint pk_AtividadeAtleta primary key (id_atleta, id_atividade));

create table Antiguidade(
id int
  constraint pk_Antiguidade primary key,
de number,
ate number,
pct number,
constraint ck_Antiguidade_Periodo check (de < ate));

-- Foreign keys

alter table AtividadeAtleta add
  constraint fk_AtividadeAtleta_Atleta foreign key (id_atleta) references Atleta(id);
alter table AtividadeAtleta add
  constraint fk_AtividadeAtleta_Atividade foreign key (id_atividade) references Atividade(id);

alter table TipoProfissional add
  constraint fk_TipoProfissional foreign key (tipo) references TipoAtleta(tipo);

alter table TipoSemiProfissional add
  constraint fk_TipoSemiProfissional foreign key (tipo) references TipoAtleta(tipo);

alter table TipoAmador add
  constraint fk_TipoAmador_TipoAtleta foreign key (tipo) references TipoAtleta(tipo);

alter table Atleta add
  constraint fk_Atleta_TipoAtleta foreign key (tipo_atleta) references TipoAtleta(tipo);
alter table Atleta add
  constraint fk_Atleta_genero foreign key (genero) references genero(genero);

alter table Competicao add
   constraint fk_Competicao_atividade foreign key (id_atividade) references Atividade(id);

alter table FCM add
  constraint fk_FCM_Genero foreign key (genero) references Genero(genero);
alter table FCM add
  constraint fk_FCM_Atividade foreign key (id_atividade) references Atividade(id);
alter table FCM add
  constraint fk_FCM_Formula foreign key (id_formula) references FormulaFCM(id);

alter table FCT add
  constraint fk_FCT_Formula foreign key (id_formula) references FormulaFCT(id);

alter table Amador add
  constraint fk_Amador_Atleta foreign key (id) references Atleta(id);
alter table SemiProfissional add
  constraint fk_SemiProfissional_Atleta foreign key (id) references Atleta(id);
alter table Profissional add
  constraint fk_Profissional_Atleta foreign key (id) references Atleta(id);
  
alter table Pagamento add
  constraint fk_Pagamento_Atleta foreign key (id) references Atleta(id);

--Dados.

insert into Atividade(id, nome) values(1, 'Caminhada');
insert into Atividade(id, nome) values(2, 'Corrida');
insert into Atividade(id, nome) values(3, 'Ciclismo');
insert into Atividade(id, nome) values(4, 'Natação');

insert into TipoAtleta(tipo, nome) values(1, 'Profissional');
insert into TipoAtleta(tipo, nome) values(2, 'SemiProfissional');
insert into TipoAtleta(tipo, nome) values(3, 'Amador');
  
insert into Genero(genero) values('F');
insert into Genero(genero) values('M');

insert into FormulaFCM(id, formula) values(1, '208.75-(0.73*idade)');
insert into FormulaFCM(id, formula) values(2, '189-(0.56*idade)');
insert into FormulaFCM(id, formula) values(3, '202-(0.72*idade)');
insert into FormulaFCM(id, formula) values(4, '204-(1.7*idade)');

insert into FormulaFCT(id, formula) values(1, 'fcr+(it*(fcm-fcr))');

insert into TipoProfissional(tipo, pct_variavel) values (1, 20);

insert into TipoSemiProfissional(tipo, pct_fixa) values (2, null);

insert into TipoAmador(tipo, pct_variavel) values (3, 7);

insert into Antiguidade (id, de, ate, pct) values (1, 5, 10, 2);
insert into Antiguidade (id, de, ate, pct) values (2, 10.001, 20, 8);
insert into Antiguidade (id, de, ate, pct) values (3, 20.001, null, 20);

INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (1,'Harper Chapman','726164761','1994-02-02','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (2,'Autumn Allen','280442756','1955-02-07','F',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (3,'Chanda Sanchez','559765545','1983-11-10','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (4,'Libby Warren','309645065','1962-02-23','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (5,'Ivy Bruce','631769045','1957-01-10','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (6,'Cyrus Morin','740125160','1989-05-31','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (7,'Rowan Mcgee','283601078','1956-07-28','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (8,'Uriel Schneider','075413578','1981-11-09','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (9,'Buckminster Hendrix','150334658','1994-05-06','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (10,'Omar Rich','733593979','1985-05-22','F',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (11,'Benedict Morrow','468626473','1955-10-31','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (12,'Tamara Acosta','653842226','1979-04-17','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (13,'Jacqueline Nolan','671003090','1996-01-30','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (14,'Rina Hines','247101431','1995-03-17','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (15,'India Olson','464679555','1970-04-16','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (16,'Dexter King','365881961','2000-07-02','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (17,'Dai Chandler','271443848','2001-11-11','F',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (18,'Virginia Nelson','029402482','1993-03-19','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (19,'Ashton Patrick','370475747','1994-05-24','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (20,'Whilemina Meadows','645898377','1982-01-15','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (21,'Melodie Whitley','816326673','1969-04-07','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (22,'Dean Gallegos','607281570','1989-12-04','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (23,'Xander Walters','607412274','1952-08-29','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (24,'Yuli Cannon','980497654','1988-02-17','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (25,'Clio Vinson','547280376','1989-08-12','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (26,'Desiree Woodward','950693882','1984-07-05','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (27,'Martin Houston','130217026','1992-10-22','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (28,'Kieran Gould','233980669','1970-09-04','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (29,'Walter Conley','110071269','1980-09-22','F',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (30,'Ivy Elliott','918756017','1990-01-24','F',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (31,'Whoopi Terrell','230785395','1951-07-20','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (32,'Edward Williamson','131769584','1952-06-16','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (33,'Ignacia Mooney','229254757','1952-05-18','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (34,'Leah Massey','774004588','1957-05-13','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (35,'Octavius Dickson','604385918','1958-08-23','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (36,'Tashya Mckee','656545993','1966-04-13','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (37,'Cruz Flores','380423765','1975-11-03','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (38,'Carl Sloan','041961576','1999-05-07','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (39,'Ashely Carroll','077250080','1956-04-15','F',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (40,'Plato Frye','258926719','1952-09-30','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (41,'Molly Gilliam','550297815','1957-09-02','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (42,'Macaulay Holloway','236115862','1994-06-25','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (43,'Pamela Rhodes','246871011','1957-05-14','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (44,'Joelle Singleton','101545264','1978-04-12','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (45,'Leila Ayala','717054756','1986-02-06','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (46,'Kibo Stevenson','849698331','1999-04-10','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (47,'Jermaine Harrell','316555946','1965-12-08','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (48,'Walter Huber','171904310','1965-05-07','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (49,'Knox Patton','143120676','1972-11-29','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (50,'Odysseus Duran','139855390','1976-03-27','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (51,'Harding Flores','486580835','1982-04-18','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (52,'Priscilla Mcintosh','411163523','1994-03-29','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (53,'Tana Welch','462297052','2004-03-01','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (54,'Elliott Olson','367192894','1974-06-05','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (55,'Amela Rodriguez','279383595','1991-06-14','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (56,'Shaeleigh Langley','410069037','1971-06-15','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (57,'Amethyst Shannon','483766935','1986-05-14','F',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (58,'Judah Roy','209707769','1996-02-11','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (59,'Axel Mcneil','380637258','1980-12-03','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (60,'Dominic Durham','167863533','1988-01-24','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (61,'Colt Dominguez','154689461','1997-06-25','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (62,'Adena Hatfield','770757427','1977-09-26','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (63,'Ferdinand Cantu','329814702','1957-04-26','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (64,'Maya Baldwin','886447956','1960-06-28','F',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (65,'Finn Hines','556489893','1980-09-24','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (66,'Honorato Goodman','910269236','1993-05-30','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (67,'Lisandra Fields','739414764','1993-08-16','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (68,'Jolene Marsh','610901953','1992-10-07','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (69,'Ferdinand Patterson','169397582','1998-04-30','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (70,'Calvin Matthews','460948374','1979-11-12','F',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (71,'Benedict Massey','629641459','1998-10-22','F',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (72,'Ishmael Mcmillan','527439505','2004-01-07','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (73,'Reese Walton','906471116','1987-01-01','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (74,'Theodore Sargent','402101091','1969-02-22','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (75,'Zachery Giles','506429210','1953-06-11','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (76,'Jared Donaldson','035879489','1963-05-12','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (77,'Caryn Mathis','849019924','1952-03-04','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (78,'Aimee Ferguson','052677493','1982-04-07','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (79,'Keith Rodgers','390673595','1963-07-09','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (80,'Kermit Gallegos','473956373','1958-06-27','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (81,'Tallulah Eaton','031246179','2001-03-01','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (82,'Tiger Brewer','806505005','1966-07-28','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (83,'Stacy English','923143243','1997-10-11','F',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (84,'Whitney Cortez','230896504','1956-07-13','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (85,'Cheyenne Blankenship','996885679','1983-01-06','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (86,'Denise Hunter','202185659','1966-12-13','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (87,'Erica Cohen','172138430','1967-08-20','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (88,'Martena Weaver','336774794','1973-04-14','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (89,'Kelsey Green','348247600','1997-04-09','M',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (90,'Hayley Vargas','904228528','1991-11-18','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (91,'Malcolm Vazquez','377454942','1999-08-30','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (92,'Charity Zamora','859661770','1975-05-03','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (93,'Vladimir Nichols','303152782','1994-07-02','F',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (94,'Tana Moon','332466160','1964-07-22','M',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (95,'Kennan Mcdowell','709231193','1997-04-12','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (96,'Alexis Morin','726589100','1962-11-18','F',3);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (97,'Wesley Suarez','583664365','1964-05-29','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (98,'Alfonso Waters','882185369','1974-06-28','M',2);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (99,'Farrah Santos','795239336','1958-03-19','F',1);
INSERT INTO Atleta (id,nome,nic,data_nascimento,genero,tipo_atleta) VALUES (100,'Tanisha Moody','569160060','1979-03-19','F',1);

insert into AtividadeAtleta (id_atleta, id_atividade) values (1, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (2, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (3, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (4, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (5, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (6, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (7, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (8, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (8, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (8, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (9, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (10, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (11, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (12, 4);
insert into AtividadeAtleta (id_atleta, id_atividade) values (13, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (14, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (15, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (16, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (17, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (18, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (19, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (20, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (21, 4);
insert into AtividadeAtleta (id_atleta, id_atividade) values (22, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (23, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (24, 4);
insert into AtividadeAtleta (id_atleta, id_atividade) values (25, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (26, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (27, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (28, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (29, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (30, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (31, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (32, 4);
insert into AtividadeAtleta (id_atleta, id_atividade) values (33, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (34, 4);
insert into AtividadeAtleta (id_atleta, id_atividade) values (35, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (36, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (37, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (38, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (39, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (40, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (41, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (42, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (42, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (43, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (44, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (45, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (46, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (47, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (48, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (49, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (49, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (50, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (51, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (52, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (53, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (54, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (55, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (56, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (56, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (57, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (58, 4);
insert into AtividadeAtleta (id_atleta, id_atividade) values (59, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (60, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (61, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (61, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (61, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (61, 4);
insert into AtividadeAtleta (id_atleta, id_atividade) values (62, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (63, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (64, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (65, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (66, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (67, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (68, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (69, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (70, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (71, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (72, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (73, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (74, 4);
insert into AtividadeAtleta (id_atleta, id_atividade) values (75, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (76, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (77, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (78, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (79, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (80, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (81, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (82, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (83, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (84, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (85, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (86, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (87, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (88, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (89, 4);
insert into AtividadeAtleta (id_atleta, id_atividade) values (90, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (91, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (92, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (93, 2);
insert into AtividadeAtleta (id_atleta, id_atividade) values (94, 1);
insert into AtividadeAtleta (id_atleta, id_atividade) values (95, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (96, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (97, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (98, 4);
insert into AtividadeAtleta (id_atleta, id_atividade) values (99, 3);
insert into AtividadeAtleta (id_atleta, id_atividade) values (100, 2);

insert into Competicao(id, data, nome, id_atividade) values (1, to_date('2020-01-15', 'yyyy-mm-dd'), 'Masters Caminhada 2020', 1);
insert into Competicao(id, data, nome, id_atividade) values (2, to_date('2020-03-15', 'yyyy-mm-dd'), 'Upskill a Correr', 2);
insert into Competicao(id, data, nome, id_atividade) values (3, to_date('2020-03-25', 'yyyy-mm-dd'), 'Upskill 100% a pedalar', 3);
insert into Competicao(id, data, nome, id_atividade) values (4, to_date('2020-06-15', 'yyyy-mm-dd'), 'Nadar é saúde', 4);

insert into Participa(id_atleta, id_competicao) values(1, 2);
insert into Participa(id_atleta, id_competicao) values(2, 2);
insert into Participa(id_atleta, id_competicao) values(3, 3);
insert into Participa(id_atleta, id_competicao) values(4, 2);
insert into Participa(id_atleta, id_competicao) values(5, 2);
insert into Participa(id_atleta, id_competicao) values(7, 2);
insert into Participa(id_atleta, id_competicao) values(8, 1);
insert into Participa(id_atleta, id_competicao) values(8, 2);
insert into Participa(id_atleta, id_competicao) values(8, 3);
insert into Participa(id_atleta, id_competicao) values(9, 2);
insert into Participa(id_atleta, id_competicao) values(10, 2);
insert into Participa(id_atleta, id_competicao) values(11, 3);
insert into Participa(id_atleta, id_competicao) values(12, 4);
insert into Participa(id_atleta, id_competicao) values(13, 2);
insert into Participa(id_atleta, id_competicao) values(14, 1);
insert into Participa(id_atleta, id_competicao) values(16, 3);
insert into Participa(id_atleta, id_competicao) values(17, 1);
insert into Participa(id_atleta, id_competicao) values(18, 1);
insert into Participa(id_atleta, id_competicao) values(19, 1);
insert into Participa(id_atleta, id_competicao) values(20, 1);
insert into Participa(id_atleta, id_competicao) values(21, 4);
insert into Participa(id_atleta, id_competicao) values(22, 3);
insert into Participa(id_atleta, id_competicao) values(23, 1);
insert into Participa(id_atleta, id_competicao) values(24, 4);
insert into Participa(id_atleta, id_competicao) values(26, 1);
insert into Participa(id_atleta, id_competicao) values(27, 1);
insert into Participa(id_atleta, id_competicao) values(28, 1);
insert into Participa(id_atleta, id_competicao) values(29, 3);
insert into Participa(id_atleta, id_competicao) values(30, 1);
insert into Participa(id_atleta, id_competicao) values(31, 3);
insert into Participa(id_atleta, id_competicao) values(32, 4);
insert into Participa(id_atleta, id_competicao) values(34, 4);
insert into Participa(id_atleta, id_competicao) values(35, 3);
insert into Participa(id_atleta, id_competicao) values(36, 1);
insert into Participa(id_atleta, id_competicao) values(38, 1);
insert into Participa(id_atleta, id_competicao) values(39, 2);
insert into Participa(id_atleta, id_competicao) values(40, 3);
insert into Participa(id_atleta, id_competicao) values(41, 2);
insert into Participa(id_atleta, id_competicao) values(42, 2);
insert into Participa(id_atleta, id_competicao) values(42, 3);
insert into Participa(id_atleta, id_competicao) values(44, 2);
insert into Participa(id_atleta, id_competicao) values(45, 1);
insert into Participa(id_atleta, id_competicao) values(46, 2);
insert into Participa(id_atleta, id_competicao) values(48, 3);
insert into Participa(id_atleta, id_competicao) values(49, 1);
insert into Participa(id_atleta, id_competicao) values(49, 2);
insert into Participa(id_atleta, id_competicao) values(50, 1);
insert into Participa(id_atleta, id_competicao) values(51, 1);
insert into Participa(id_atleta, id_competicao) values(52, 2);
insert into Participa(id_atleta, id_competicao) values(53, 1);
insert into Participa(id_atleta, id_competicao) values(55, 1);
insert into Participa(id_atleta, id_competicao) values(56, 1);
insert into Participa(id_atleta, id_competicao) values(56, 3);
insert into Participa(id_atleta, id_competicao) values(57, 3);
insert into Participa(id_atleta, id_competicao) values(58, 4);
insert into Participa(id_atleta, id_competicao) values(59, 2);
insert into Participa(id_atleta, id_competicao) values(60, 1);
insert into Participa(id_atleta, id_competicao) values(61, 1);
insert into Participa(id_atleta, id_competicao) values(61, 2);
insert into Participa(id_atleta, id_competicao) values(61, 3);
insert into Participa(id_atleta, id_competicao) values(62, 1);
insert into Participa(id_atleta, id_competicao) values(63, 3);
insert into Participa(id_atleta, id_competicao) values(65, 2);
insert into Participa(id_atleta, id_competicao) values(66, 1);
insert into Participa(id_atleta, id_competicao) values(67, 1);
insert into Participa(id_atleta, id_competicao) values(68, 1);
insert into Participa(id_atleta, id_competicao) values(69, 2);
insert into Participa(id_atleta, id_competicao) values(70, 1);
insert into Participa(id_atleta, id_competicao) values(72, 3);
insert into Participa(id_atleta, id_competicao) values(73, 2);
insert into Participa(id_atleta, id_competicao) values(74, 4);
insert into Participa(id_atleta, id_competicao) values(75, 3);
insert into Participa(id_atleta, id_competicao) values(77, 1);
insert into Participa(id_atleta, id_competicao) values(78, 1);
insert into Participa(id_atleta, id_competicao) values(79, 3);
insert into Participa(id_atleta, id_competicao) values(80, 3);
insert into Participa(id_atleta, id_competicao) values(81, 2);
insert into Participa(id_atleta, id_competicao) values(83, 3);
insert into Participa(id_atleta, id_competicao) values(84, 3);
insert into Participa(id_atleta, id_competicao) values(86, 3);
insert into Participa(id_atleta, id_competicao) values(87, 3);
insert into Participa(id_atleta, id_competicao) values(88, 2);
insert into Participa(id_atleta, id_competicao) values(89, 4);
insert into Participa(id_atleta, id_competicao) values(90, 1);
insert into Participa(id_atleta, id_competicao) values(91, 2);
insert into Participa(id_atleta, id_competicao) values(92, 1);
insert into Participa(id_atleta, id_competicao) values(93, 2);
insert into Participa(id_atleta, id_competicao) values(94, 1);
insert into Participa(id_atleta, id_competicao) values(96, 3);
insert into Participa(id_atleta, id_competicao) values(97, 3);
insert into Participa(id_atleta, id_competicao) values(98, 4);
insert into Participa(id_atleta, id_competicao) values(99, 3);
insert into Participa(id_atleta, id_competicao) values(100, 2);

commit;