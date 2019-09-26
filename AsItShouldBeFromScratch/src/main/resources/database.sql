DROP TABLE roles;
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

/*Table for mapping user and roles*/
CREATE TABLE user_roles (
  usr_id INT NOT NULL,
  roles VARCHAR(255) NOT NULL,
  FOREIGN KEY (usr_id) REFERENCES usr (id),
  UNIQUE (roles, usr_id)
);

INSERT INTO usr VALUES (2, 'roman', 'roman', 'roman@ukr.net', 'roman', 'vygovsky');
INSERT INTO user_roles VALUES (2, 'USER');