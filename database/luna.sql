use tarot_7may;
drop table if exists mysaved;
create table mysaved(
	id int auto_increment not null,
	reading_id varchar(16) not null, 
    cards text not null, 
    reading_date text not null,
    
    primary key(id)
);