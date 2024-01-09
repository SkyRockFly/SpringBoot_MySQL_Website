CREATE TABLE my_db.users (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(25),
  email varchar(75),
  password varchar(100),
  PRIMARY KEY (id)
);

CREATE TABLE my_db.roles (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(25),
  PRIMARY KEY (id)
);

CREATE TABLE my_db.users_roles (
  user_id int NOT NULL,
  role_id int NOT NULL,
  PRIMARY KEY (user_id, role_id),
  FOREIGN KEY (user_id) REFERENCES my_db.users(id),
  FOREIGN KEY (role_id) REFERENCES my_db.roles(id));