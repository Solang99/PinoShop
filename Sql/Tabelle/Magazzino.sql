DROP TABLE IF EXISTS magazzino CASCADE;



CREATE TABLE magazzino (
  codMagazzino BIGSERIAL PRIMARY KEY,
  reparto VARCHAR (30),
  capacita INTEGER ,
  coda VARCHAR(30),   
  constraint fk_coda FOREIGN KEY (coda) REFERENCES articolo(coda) on delete cascade
);


