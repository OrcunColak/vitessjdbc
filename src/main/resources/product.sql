CREATE TABLE IF NOT EXISTS product(
    sku VARCHAR(100),
    price NUMERIC(10,0),
    PRIMARY KEY (sku)
    );

INSERT INTO product(sku, price) values ('item1', 10);
INSERT INTO product(sku, price) values ('item2', 20);