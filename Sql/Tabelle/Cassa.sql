DROP TABLE IF EXISTS cassa CASCADE;
DROP TYPE IF EXISTS pagamento_type;


CREATE TYPE pagamento_type as ENUM ('Contanti', 'Carta');


CREATE TABLE cassa (
  pagamento pagamento_type NOT NULL,
  pagamentoDovuto REAL,
  pagamentoVersato REAL,
  resto REAL,
  codOrd BIGSERIAL PRIMARY KEY,
  usernameCommesso  VARCHAR(30),
   constraint fk_commesso FOREIGN KEY (usernameCommesso) REFERENCES commesso(username) on delete cascade
);


