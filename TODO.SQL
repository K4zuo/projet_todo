-- -----------------------------------------------------------------------------
--      Nom de la base : TODO
--      Auteur : Fabien HEBERT
--      Date de dernière modification : 14/6/2016 12:00:48
-- -----------------------------------------------------------------------------

--DROP TABLE PERSONNE;

--DROP TABLE TODO;

-- -----------------------------------------------------------------------------
--       TABLE : PERSONNE
-- -----------------------------------------------------------------------------

CREATE TABLE PERSONNE
   (
   PERSONNE_ID INTEGER PRIMARY KEY,
   NOM TEXT NOT NULL,
   PRENOM TEXT NOT NULL
   );

-- -----------------------------------------------------------------------------
--       TABLE : TODO
-- -----------------------------------------------------------------------------

CREATE TABLE TODO
   (
   TODO_ID INTEGER PRIMARY KEY,
   TODO_PARENT_ID INTEGER,
   PERSONNE_ID INTEGER,
   LIBELLE TEXT NOT NULL,
   ETAT TEXT,
   FOREIGN KEY(TODO_PARENT_ID) REFERENCES TODO(TODO_ID),
   FOREIGN KEY(PERSONNE_ID) REFERENCES PERSONNE(PERSONNE_ID)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE TODO
-- -----------------------------------------------------------------------------

CREATE INDEX I_FK_TODO_TODO ON TODO (TODO_PARENT_ID ASC);

CREATE INDEX I_FK_TODO_PERSONNE ON TODO (PERSONNE_ID ASC);