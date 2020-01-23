DROP TABLE IF EXISTS articolo cascade;
DROP TYPE IF EXISTS taglia_type;
DROP TYPE IF EXISTS genere_type;

CREATE TYPE taglia_type as ENUM ('XS','S,''M','L','XL','XXL');
CREATE TYPE genere_type as ENUM ('MASCHILE' , 'FEMMINILE');

CREATE TABLE articolo (
    nome VARCHAR(20) ,
    codA VARCHAR(20) NOT NULL PRIMARY KEY,
    produttore VARCHAR(20),
    taglia taglia_type NOT NULL,
    colore VARCHAR(10),
    collezione VARCHAR(20),
    quantita INTEGER,
    prezzo REAL,
    genere genere_type NOT NULL,
    foto bytea
);


