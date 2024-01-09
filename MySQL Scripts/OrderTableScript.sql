CREATE TABLE my_db.orders (
  id int NOT NULL AUTO_INCREMENT,
  type varchar(25),
  user_id int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES my_db.users(id)
  
);

CREATE TABLE my_db.upgrades (
  order_id int not null auto_increment,
  upgrade_type varchar(25),
  upgrade_level int NOT NULL,
  FOREIGN KEY (order_id) REFERENCES my_db.orders(id));