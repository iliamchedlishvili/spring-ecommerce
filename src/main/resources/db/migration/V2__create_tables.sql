
CREATE TABLE log.error_logs (
    id SERIAL PRIMARY KEY,
    error_text VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL
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

CREATE TABLE emp.users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_type_id BIGINT NOT NULL,
    employee_id BIGINT,

    CONSTRAINT fk_users_user_type_id
        FOREIGN KEY (user_type_id)
        REFERENCES emp.user_types (id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_users_employee_id
        FOREIGN KEY (employee_id)
        REFERENCES emp.employees (id)
        ON DELETE RESTRICT
);