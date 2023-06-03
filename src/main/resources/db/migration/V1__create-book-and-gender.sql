create table if not exists gender(
    id uuid primary key,
    name varchar(20) not null
);

create table if not exists book(
    id uuid primary key,
    title varchar(100) not null,
    author varchar(60) not null,
    units integer not null,
    available_units integer not null
);

create table if not exists book_genders(

    id_book uuid not null,
    id_gender uuid not null,

    constraint id_book foreign key (id_book) references book (id),
    constraint id_gender foreign key (id_gender) references gender (id),
    constraint pk_book_gender primary key(id_book, id_gender)
);