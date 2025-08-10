CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    calories_per_100g INTEGER,
    protein_per_100g INTEGER,
    fat_per_100g INTEGER,
    carbs_per_100g INTEGER,
    price_per_100g DECIMAL(5,2)
);