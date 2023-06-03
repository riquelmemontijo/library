create table if not exists hall (
    id uuid primary key,
    alias varchar(100) not null
);

create table if not exists bookcase (
    id uuid primary key,
    alias varchar(100) not null,
    pk_hall uuid not null,

    constraint pk_hall foreign key (pk_hall) references hall (id)
);

create table if not exists bookcase_books (

    id_bookcase uuid not null,
    id_book uuid not null,

    constraint id_bookcase foreign key (id_bookcase) references bookcase (id),
    constraint id_book foreign key (id_book) references book (id),
    constraint pk_bookcase_books primary key(id_bookcase, id_book)
);