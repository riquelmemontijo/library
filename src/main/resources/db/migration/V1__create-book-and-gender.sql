create table gender (
    id varchar(36) primary key,
    name varchar(20) not null
);

create table book (
    id varchar(36) primary key,
    title varchar(100) not null,
    author varchar(60) not null,
    units integer not null,
    available_units integer not null
);

create table book_genders (
    id uuid primary key,
    id_book varchar(36) not null unique,
    id_gender varchar(36) not null unique,

    constraint id_book foreign key (id_book) references book (id),
    constraint id_gender foreign key (id_gender) references gender (id)
);