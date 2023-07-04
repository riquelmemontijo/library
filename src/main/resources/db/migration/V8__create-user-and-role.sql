create table if not exists tb_user (
    id uuid primary key,
    name varchar(150) not null,
    username varchar(150) not null,
    password varchar(150) not null,
    email varchar(150) not null,
    phone_number varchar(20),
    status varchar(15) not null,
    created_at date not null,
    updated_at date
);

create table if not exists role (
    id uuid primary key,
    name varchar(150) not null
);

create table if not exists user_roles (
    id_user uuid not null,
    id_role uuid not null,

    constraint id_user foreign key (id_user) references tb_user(id),
    constraint id_role foreign key (id_role) references role(id),
    constraint pk_user_roles primary key(id_user, id_role)
);



