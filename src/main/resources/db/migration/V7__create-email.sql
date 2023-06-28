create table if not exists email (
    id uuid primary key,
    subject varchar(50) not null,
    sender varchar(50) not null,
    recipient varchar(50) not null,
    status varchar(15) not null,
    send_date timestamp not null
);