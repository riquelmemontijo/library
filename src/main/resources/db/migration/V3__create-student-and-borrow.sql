create table if not exists student (
    id uuid primary key,
    name varchar(100) not null,
    date_of_birth date not null,
    email varchar(100) not null,
    phone_number varchar(20) not null
);

create table if not exists borrow (
    id uuid primary key,
    cod_borrow serial,
    pk_student uuid not null,
    borrow_date date not null,
    due_date date,
    penalty float
);

create table if not exists borrow_books (

    id_borrow uuid not null,
    id_book uuid not null,

    constraint id_borrow foreign key (id_borrow) references borrow (id),
    constraint id_book foreign key (id_book) references book (id),
    constraint pk_borrow_books primary key(id_borrow, id_book)
);