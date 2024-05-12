create table t_inventory
(
    id  bigint auto_increment
        primary key,
    sku_code     varchar(255) not null,
    quantity     int          not null,
    created_date timestamp    not null
);