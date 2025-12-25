CREATE TABLE production.products_categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE production.products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    sku VARCHAR(255) UNIQUE NOT NULL,
    price DECIMAL(19, 2) NOT NULL,
    category_id INTEGER NOT NULL,

    CONSTRAINT fk_product_category
    FOREIGN KEY (category_id)
    REFERENCES production.products_categories(id)
    ON DELETE CASCADE
);