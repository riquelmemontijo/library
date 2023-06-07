create table if not exists student_debit (
    id uuid primary key,
    value float not null,
    is_paid boolean not null,
    fk_borrow uuid not null,

    constraint fk_borrow foreign key (fk_borrow) references borrow (id)
);