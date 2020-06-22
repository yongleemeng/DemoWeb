drop table if exists USERS;
create table USERS(
      username varchar(128) not null primary key,
      password varchar(512) not null,
      enabled boolean not null);

drop table if exists AUTHORITIES;
create table AUTHORITIES (
      username varchar(128) not null,
      authority varchar(128) not null);

create unique index idx_auth_username on authorities (username,authority);

drop table if exists CUSTOMER;
create table CUSTOMER(
  id varchar(255) primary key,
  name varchar(255) not null,
  phone_no varchar(255) not null,
  residential_address_1 varchar(255),
  residential_address_2 varchar(255),
  residential_address_3 varchar(255),
  mailing_address_1 varchar(255),
  mailing_address_2 varchar(255),
  mailing_address_3 varchar(255),
  status boolean not null);
  
      
create unique index idx_customer_name on CUSTOMER (name);

/*
create table public.P_PERSONEL(
	id bigint not null,
	first_name varchar(255),
	last_name varchar(255),
	
);
create table public.P_PET(
	id bigint not null,
	first_name varchar(255),
	birth_date date,
	personel_id bigint
);

alter table public.p_personel add constraint public.constraint_1 primary key(id);

alter table public.p_pet add constraint public.constraint_2 primary key(id);

alter table public.p_pet add constraint public.constraint_3 foreign key(personel_id) references public.p_personel(id);

create sequence public.petclinic_sequence start with 100;
*/

