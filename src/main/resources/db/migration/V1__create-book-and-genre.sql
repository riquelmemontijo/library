create table if not exists genre(
    id uuid primary key,
    name varchar(20) not null
);

create table if not exists book(
    id uuid primary key,
    title varchar(100) not null,
    units integer not null,
    available_units integer not null
);

create table if not exists book_genres(

    id_book uuid not null,
    id_genre uuid not null,

    constraint id_book foreign key (id_book) references book (id),
    constraint id_gender foreign key (id_genre) references genre (id),
    constraint pk_book_genre primary key(id_book, id_genre)
);