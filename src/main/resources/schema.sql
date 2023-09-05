CREATE TABLE IF NOT EXISTS coffee
(
    coffee_id   BIGINT not null,
    coffee_name VARCHAR(512) not null,
    CONSTRAINT pk_coffee PRIMARY KEY (coffee_id)
);