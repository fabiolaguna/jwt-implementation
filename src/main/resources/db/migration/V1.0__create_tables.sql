CREATE TABLE IF NOT EXISTS users(
  id_user BIGSERIAL,
  username VARCHAR(30),
  pass VARCHAR(20),
  first_name VARCHAR(20),
  last_name VARCHAR(20),
  rol VARCHAR(15),
PRIMARY KEY (id_user)
);

CREATE TABLE IF NOT EXISTS cars(
  id_car BIGSERIAL,
  id_user BIGINT,
  patent VARCHAR(8),
  brand VARCHAR(20),
  model VARCHAR(20),
  PRIMARY KEY (id_car),
CONSTRAINT fk_id_user FOREIGN KEY (id_user) references users (id_user)
);