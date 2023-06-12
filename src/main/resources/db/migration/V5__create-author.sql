create table if not exists author (
     id uuid primary key,
     name varchar(150) not null
);

create table if not exists author_books (
    id_author uuid not null,
    id_book uuid not null,

    constraint id_author foreign key (id_author) references author (id),
    constraint id_book foreign key (id_book) references book (id),
    constraint pk_author_books primary key(id_author, id_book)
);