CREATE TABLE products(
    id UUID NOT NULL,
    name VARCHAR NOT NULL UNIQUE,
    description VARCHAR NOT NULL,
    quantity SMALLINT NOT NULL,
    image VARCHAR NOT NULL
)