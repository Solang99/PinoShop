DROP TABLE IF EXISTS cassa CASCADE;
DROP TYPE IF EXISTS pagamento_type;


CREATE TYPE pagamento_type as ENUM ('Contanti', 'Carta di Credito');


CREATE TABLE cassa (
  pagamento pagamento_type NOT NULL,
  pagamentoDovuto INTEGER,
  pagamentoVersato INTEGER,
  resto INTEGER,
  Id BIGSERIAL PRIMARY KEY
);


