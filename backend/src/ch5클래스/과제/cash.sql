drop database if exists cash_db;
create database cash_db;

drop table if exists cash;


create table cash(
	num int auto_increment not null primary key,
	cash_date varchar(100),
    cash_price int,
    cash_content varchar(100)
);

select * from cash;


insert into cash values(null , '2000-05-15' , 10000 , '치킨' );
insert into cash values(null , '2000-05-15' , 10000 , '아메리카노' );

UPDATE cash SET cash_date = 'qwd' , 필드명2 = 수정필드명2 = 새로운값 WHERE num= 1;
UPDATE cash SET cash_date = '112113' , cash_price = '1211312' , cash_content = 'q11wze' where num = '1';
UPDATE cash set cash_date = 'asd' , cash_price = '123' , cash_content = 'asd' where num = 8;

select * from cash;
delete from cash where num = 1;