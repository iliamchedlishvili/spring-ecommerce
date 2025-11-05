
CREATE TABLE log.error_logs (
    id SERIAL PRIMARY KEY,
    error_text VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE emp.users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE emp.user_types (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE emp.employees (
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    mobile VARCHAR(255)
);
