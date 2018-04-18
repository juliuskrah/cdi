create table CUSTOMER (
    ID uuid not null,
    LAST_NAME varchar(100) not null,
    FIRST_NAME varchar(100) not null,
    MIDDLE_INITIAL varchar(25),
    STREET varchar(100),
    CITY varchar(100),
    STATE varchar(100),
    ZIP bigint,
    PHONE varchar(10),
    EMAIL varchar(100)
);

alter table if exists CUSTOMER add constraint CUSTOMER_PK primary key(ID);