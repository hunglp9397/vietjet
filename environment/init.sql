create table airline
(
    id   bigint generated by default as identity
        primary key,
    code varchar(255)
);

alter table airline
    owner to admin;

create table airport
(
    id      bigint generated by default as identity
        primary key,
    address varchar(255),
    name    varchar(255)
);

alter table airport
    owner to admin;

create table booking
(
    id           bigint generated by default as identity
        primary key,
    booking_time timestamp(6),
    discount     numeric(38, 2),
    flight_id    bigint,
    note         varchar(255),
    request_id   varchar(255),
    status       integer,
    subtotal     numeric(38, 2),
    total_amount numeric(38, 2),
    user_id      bigint
);

alter table booking
    owner to admin;

create table classes
(
    id          bigint generated by default as identity
        primary key,
    information varchar(255),
    name        varchar(255)
);

alter table classes
    owner to admin;

create table flight
(
    id                     bigint generated by default as identity
        primary key,
    airline_id             integer      not null,
    arrival_time           timestamp with time zone,
    departure_time         timestamp with time zone,
    destination_airport_id integer      not null,
    origin_airport_id      integer      not null,
    price                  numeric(38, 2),
    seat_count             integer      not null,
    type                   integer      not null
);

alter table flight
    owner to admin;

create table ticket_type_price
(
    id          bigint generated by default as identity
        primary key,
    classes_id  bigint         not null,
    flight_id   bigint         not null,
    price       numeric(38, 2) not null,
    ticket_type varchar(255)   not null
);

alter table ticket_type_price
    owner to admin;

create table app_user
(
    id         bigint generated by default as identity
        primary key,
    created_at timestamp(6),
    created_by varchar(255),
    email      varchar(255),
    fullname   varchar(255),
    password   varchar(255),
    updated_at timestamp(6),
    updated_by varchar(255),
    username   varchar(255)
);

alter table app_user
    owner to admin;


-- Data
DELETE FROM airline;
DELETE FROM airport;
DELETE FROM booking;
DELETE FROM classes;
DELETE FROM flight;
DELETE FROM ticket_type_price;
DELETE FROM app_user;


-- airline
INSERT INTO airline (code)
VALUES
    ('VN'),
    ('AA'),
    ('QH'),
    ('CX');

-- airport
INSERT INTO airport (address, name)
VALUES
    ('Noi Bai International Airport, Hanoi, Vietnam', 'Noi Bai'),
    ('Tan Son Nhat International Airport, Ho Chi Minh City, Vietnam', 'Tan Son Nhat'),
    ('Da Nang International Airport, Da Nang, Vietnam', 'Da Nang'),
    ('Changi Airport, Singapore', 'Changi');

-- booking
INSERT INTO booking (booking_time, discount, flight_id, note, request_id, status, subtotal, total_amount, user_id)
VALUES
    (current_timestamp, 10.00, 1, 'Priority check-in requested', 'REQ123', 1, 150.00, 140.00, 1),
    (current_timestamp, 5.00, 2, 'Window seat preferred', 'REQ456', 0, 200.00, 190.00, 2),
    (current_timestamp, 15.00, 3, 'Extra baggage added', 'REQ789', 1, 300.00, 255.00, 3);

-- classes
INSERT INTO classes (information, name)
VALUES
    ('Economy class', 'Economy'),
    ('Business class', 'Business'),
    ('First class', 'First');

-- flight table
INSERT INTO flight (airline_id, arrival_time, departure_time, destination_airport_id, origin_airport_id, price, seat_count, type)
VALUES
    (1, '2024-01-10 10:00:00', '2024-01-10 07:00:00', 2,  1, 150.00, 200, 1),
    (2, '2024-01-11 16:00:00', '2024-01-11 12:00:00', 3,  2, 200.00, 150, 1),
    (3, '2024-01-12 20:00:00', '2024-01-12 15:00:00', 4,  3, 250.00, 100, 2);


-- ticket_type_price
INSERT INTO ticket_type_price (classes_id, flight_id, price, ticket_type)
VALUES
    (1, 1, 100.00, 'Adult'),
    (1, 2, 80.00, 'Child'),
    (2, 3, 200.00, 'Adult'),
    (3, 3, 300.00, 'Adult');

-- app_user
INSERT INTO app_user (created_at, created_by, email, fullname, password, updated_at, updated_by, username)
VALUES
    (current_timestamp, 'system', 'user1@example.com', 'John Doe', 'password1', current_timestamp, 'system', 'johndoe'),
    (current_timestamp, 'system', 'user2@example.com', 'Jane Smith', 'password2', current_timestamp, 'system', 'janesmith'),
    (current_timestamp, 'system', 'user3@example.com', 'Alice Johnson', 'password3', current_timestamp, 'system', 'alicej');