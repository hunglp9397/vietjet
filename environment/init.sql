CREATE TABLE aircraft
(
    aircraft_code VARCHAR PRIMARY KEY,
    name          VARCHAR NOT NULL,
    status        VARCHAR NOT NULL
);

CREATE TABLE airport
(
    airport_code VARCHAR PRIMARY KEY,
    name         VARCHAR NOT NULL
);

CREATE TABLE seat
(
    aircraft_code VARCHAR PRIMARY KEY NOT NULL REFERENCES aircraft (aircraft_code),
    seat_code     VARCHAR NOT NULL,
    position      VARCHAR NOT NULL,
    class         VARCHAR NOT NULL
);

CREATE TABLE flight
(
    flight_id         SERIAL PRIMARY KEY,
    status            VARCHAR   NOT NULL,
    type              VARCHAR   NOT NULL,
    aircraft_code     VARCHAR   NOT NULL REFERENCES aircraft (aircraft_code),
    departure_airport VARCHAR   NOT NULL REFERENCES airport (airport_code),
    arrival_airport   VARCHAR   NOT NULL REFERENCES airport (airport_code),
    departure_time    TIMESTAMP NOT NULL,
    arrival_time      TIMESTAMP NOT NULL
);

CREATE TABLE seat_availability
(
    sa_id     SERIAL PRIMARY KEY,
    flight_id INT     NOT NULL REFERENCES flight (flight_id),
    seat_code VARCHAR NOT NULL,
    status    VARCHAR NOT NULL,
    price     NUMERIC NOT NULL
);

CREATE TABLE passenger
(
    passenger_id SERIAL PRIMARY KEY,
    name         VARCHAR  NOT NULL,
    nation       VARCHAR  NOT NULL,
    card_no      VARCHAR  NOT NULL,
    phone_number VARCHAR  NOT NULL,
    email        VARCHAR  NOT NULL,
    gender        SMALLINT NOT NULL -- 0 = Male, 1 = Female
);

CREATE TABLE booking
(
    id     SERIAL PRIMARY KEY,
    status         VARCHAR NOT NULL,
    voucher_code   VARCHAR,
    ticket_amount  NUMERIC NOT NULL,
    fee_amount     NUMERIC NOT NULL,
    discount_count NUMERIC NOT NULL,
    total_amount   NUMERIC NOT NULL,
    checkout_at    TIMESTAMP,
    paid_at        TIMESTAMP,
    extra_data     JSON,
    version        INT     NOT NULL,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by     VARCHAR,
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by     VARCHAR
);

CREATE TABLE booking_passenger
(
    booking_id   INT NOT NULL REFERENCES booking (id),
    passenger_id INT NOT NULL REFERENCES passenger (passenger_id),
    PRIMARY KEY (booking_id, passenger_id)
);

CREATE TABLE ticket
(
    ticket_id    SERIAL PRIMARY KEY,
    status       VARCHAR   NOT NULL,
    flight_id    INT       NOT NULL REFERENCES flight (flight_id),
    passenger_id INT       NOT NULL REFERENCES passenger (passenger_id),
    seat_code    VARCHAR   NOT NULL,
    issued_at    TIMESTAMP NOT NULL,
    booking_id   INT REFERENCES booking (id),
    bd_id        INT
);

CREATE TABLE booking_direction
(
    bd_id           SERIAL PRIMARY KEY,
    booking_id      INT      NOT NULL REFERENCES booking (id),
    flight_id       INT      NOT NULL REFERENCES flight (flight_id),
    direction       SMALLINT NOT NULL, -- 0 = Away, 1 = Return
    subtotal_amount NUMERIC  NOT NULL
);

CREATE TABLE bd_ticket
(
    bd_id     INT NOT NULL REFERENCES booking_direction (bd_id),
    ticket_id INT NOT NULL REFERENCES ticket (ticket_id),
    PRIMARY KEY (bd_id, ticket_id)
);

CREATE TABLE booking_line
(
    bl_id           SERIAL PRIMARY KEY,
    bd_id           INT     NOT NULL REFERENCES booking_direction (bd_id),
    type            VARCHAR NOT NULL, -- TICKET | FEE | VAT
    unit_amount     NUMERIC NOT NULL,
    quantity        INT     NOT NULL,
    subtotal_amount NUMERIC NOT NULL
);

CREATE TABLE transaction
(
    txn_id         SERIAL PRIMARY KEY,
    type           VARCHAR NOT NULL, -- PAYMENT | REFUND | DONATE
    status         VARCHAR NOT NULL,
    debit_acc      VARCHAR NOT NULL,
    credit_acc     VARCHAR NOT NULL,
    fee_charge     NUMERIC NOT NULL,
    amount         NUMERIC NOT NULL,
    booking_id     INT REFERENCES booking (id),
    payment_method VARCHAR NOT NULL, -- CARD | DWALLET
    txn_detail     VARCHAR,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE booking_history
(
    his_id         SERIAL PRIMARY KEY,
    booking_id     INT     NOT NULL REFERENCES booking (id),
    status         VARCHAR NOT NULL,
    voucher_code   VARCHAR,
    ticket_amount  NUMERIC NOT NULL,
    fee_amount     NUMERIC NOT NULL,
    discount_count NUMERIC NOT NULL,
    total_amount   NUMERIC NOT NULL,
    checkout_at    TIMESTAMP,
    paid_at        TIMESTAMP,
    extra_data     JSON,
    version        INT     NOT NULL,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by     VARCHAR,
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by     VARCHAR
);

CREATE TABLE entry
(
    entry_id       SERIAL PRIMARY KEY,
    ledger_code    VARCHAR NOT NULL,
    transaction_id INT     NOT NULL REFERENCES transaction (txn_id),
    debit          NUMERIC NOT NULL,
    credit         NUMERIC NOT NULL,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
