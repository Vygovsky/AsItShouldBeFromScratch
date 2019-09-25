DROP TABLE roles;
DROP TABLE usr;
DROP TABLE user_roles;
/*Table Users*/
CREATE TABLE usr (
  id        INT          NOT NULL PRIMARY KEY,
  login     VARCHAR(255) NOT NULL,
  password  VARCHAR(255) NOT NULL,
  email     VARCHAR(255) NOT NULL,
  firstName VARCHAR(255) NOT NULL,
  lastName  VARCHAR(255) NOT NULL
);


/*Table Role*/
CREATE TABLE roles (
  id   INT          NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

/*Table for mapping user and roles*/
CREATE TABLE user_roles (
  usr_id INT NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (usr_id) REFERENCES usr (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),
  UNIQUE (role_id, usr_id)
);

INSERT INTO usr VALUES (1, 'roman', 'roman', 'roman@ukr.net', 'roman', 'vygovsky');
INSERT INTO roles VALUES (1, 'USER');
INSERT INTO roles VALUES (2, 'ADMIN');

INSERT INTO user_roles VALUES (1, 2);