# Taco Cloud Project

## 1. Technology Stack

- Spring Boot
- Mybatis



## 2. Mysql table

```mysql
create table if not exists taco_ingredient (
	id bigint not null,
    ingredient varchar(4) not null
);


create table if not exists ingredient (
	id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists user (
	id bigint not null auto_increment primary key,
    username varchar(25) not null,
    password_ varchar(25) not null,
    fullname varchar(25) not null,
    street varchar(25) not null,
    city varchar(25) not null,
    state varchar(25) not null,
    zip varchar(25) not null,
    phone_number varchar(25) not null,
);


```



```mysql
insert into ingredient(id,name,type)
	values('FLTO', 'Flour Tortilla', 'WRAP');

insert into ingredient(id,name,type)
	values('COTO', 'Corn Tortilla', 'WRAP');
	
insert into ingredient(id,name,type)
	values('GRBF', 'Ground Beef', 'PROTEIN');
	
insert into ingredient(id,name,type)
	values('CARN', 'Carnitas', 'PROTEIN');
	
insert into ingredient(id,name,type)
	values('TMTO', 'Diced Tomatoes', 'VEGGIES');
	
insert into ingredient(id,name,type)
	values('LETC', 'Lettuce', 'VEGGIES');
	
insert into ingredient(id,name,type)
	values('CHED', 'Cheddar', 'CHEESE');
	
insert into ingredient(id,name,type)
	values('JACK', 'Monterrey Jack', 'CHEESE');
	
insert into ingredient(id,name,type)
	values('SLSA', 'Salsa', 'SAUCE');
	
insert into ingredient(id,name,type)
	values('SRCR', 'Sour Cream', 'SAUCE');
```

