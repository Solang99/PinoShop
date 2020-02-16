
DROP TABLE IF EXISTS cassa CASCADE;


CREATE TABLE cassa (
  nome VARCHAR(20),
  cognome VARCHAR(20),
  username VARCHAR(20),
  chiave VARCHAR(50),
  mail VARCHAR(20)  UNIQUE,
  data_nascita DATE,
  foto BYTEA
);


