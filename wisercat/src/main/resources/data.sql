create table if not exists pets (
    id INT AUTO_INCREMENT primary key ,
    name varchar(30) not null ,
    code varchar(30) not null ,
    type varchar(15) not null ,
    color varchar(10),
    country varchar(15)
);