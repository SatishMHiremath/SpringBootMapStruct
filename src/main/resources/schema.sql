DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT (
  id number AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  price number NOT NULL,
  createdat DATE NOT NULL,
  updatedat DATE NOT NULL
);