CREATE TABLE orders (
  id int(11) NOT NULL AUTO_INCREMENT,
  customer_name varchar(50) DEFAULT NULL,
  customer_address varchar(128) DEFAULT NULL,
  total decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (id)
)