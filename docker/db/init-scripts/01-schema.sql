CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    name_pl VARCHAR(100),
    name_en VARCHAR(100),
    price_per_100g DECIMAL(5,2)
);

CREATE TABLE IF NOT EXISTS nutrition (
    id SERIAL PRIMARY KEY,
    product_id INTEGER NOT NULL REFERENCES product(id) ON DELETE CASCADE,
    calories100g NUMERIC(10,2) NOT NULL,
    protein100g NUMERIC(10,2) NOT NULL,
    fat100g NUMERIC(10,2) NOT NULL,
    carbohydrates100g NUMERIC(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS recipe (
    id SERIAL PRIMARY KEY,
    recipe_name VARCHAR(255),
    preparation_description TEXT,
    preparation_time VARCHAR(20),
    type VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS recipe_product (
    id SERIAL PRIMARY KEY,
    recipe_id INTEGER NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    product_id INTEGER NOT NULL REFERENCES product(id) ON DELETE CASCADE,
    amount NUMERIC(10, 2),
    unit VARCHAR(20)
);

CREATE TABLE product_unit_weight (
    product_id BIGINT PRIMARY KEY REFERENCES product(id),
    unit VARCHAR(20) NOT NULL,          --  'pcs', 'slice'
    weight_in_grams DECIMAL(6,2) NOT NULL
);