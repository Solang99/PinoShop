
CREATE OR REPLACE FUNCTION crea_o_aggiorna() RETURNS trigger AS $insert_or_update$
BEGIN
	PERFORM 1 FROM articolo	WHERE id_articolo = NEW.id_articolo;
	IF NOT FOUND THEN
		--INSERT INTO articolo(id_articolo) VALUES (NEW.id_articolo);
		RETURN NEW;
	ELSE
		UPDATE articolo 
		SET
		produttore = NEW.produttore,
		taglia = NEW.taglia,
		colore = NEW.colore,
		collezione = NEW.collezione,
		quantita=quantita  + NEW.quantita,
		prezzo = NEW.prezzo,
		genere = NEW.genere,
		foto = NEW.foto
		
		WHERE id_articolo=NEW.id_articolo;	
					 
								 
	
	END IF;										 
	RETURN NULL;									 
	END;
	
$insert_or_update$ LANGUAGE 'plpgsql';

DROP TRIGGER IF EXISTS  insert_or_update ON ARTICOLO;

CREATE TRIGGER insert_or_update
  BEFORE INSERT
  ON articolo
  FOR EACH ROW
  EXECUTE PROCEDURE crea_o_aggiorna();