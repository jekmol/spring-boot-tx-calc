CREATE TABLE IF NOT EXISTS bill
(
  id SERIAL PRIMARY KEY,
  name     VARCHAR(25) NOT NULL,
  tax_code INT NOT NULL,
  price FLOAT NOT NULL
);

INSERT INTO bill ("name", "tax_code", "price")
VALUES ('Lucky Stretch',2,1000), ('Big Mac', 1, 1000), ('Movie', 3, 150);