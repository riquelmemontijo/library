create table if not exists student (
    id uuid primary key,
    name varchar(100) not null,
    date_of_birth date not null,
    email varchar(100) not null,
    phone_number varchar(20) not null,
);

create table if not exists borrow (
    id uuid primary key,
    name varchar(100) not null,
    date_of_birth date not null,
    email varchar(100) not null,
    phone_number varchar(20) not null,
);