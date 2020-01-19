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
