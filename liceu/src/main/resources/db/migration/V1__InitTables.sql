-- Drop sequences
DROP SEQUENCE elevi_seq;
DROP SEQUENCE camine_seq;
DROP SEQUENCE camere_seq;
DROP SEQUENCE cazare_elev_seq;
DROP SEQUENCE licee_seq;

-- Drop tables
DROP TABLE CazareElev;
DROP TABLE Camere;
DROP TABLE Camine;
DROP TABLE Elevi;
DROP TABLE Licee;

-- Create tables
CREATE TABLE Licee
(
    id int PRIMARY KEY,
    nume varchar(100) UNIQUE,
    adresa varchar(100),
    is_deleted NUMBER(1) DEFAULT 0 CHECK (is_deleted IN (0, 1))
);

CREATE TABLE Elevi
(
    id int PRIMARY KEY,
    nume varchar(100) NOT NULL,
    prenume varchar(100) NOT NULL,
    telefon varchar(20) NOT NULL,
    liceu_id int,
    FOREIGN KEY (liceu_id) REFERENCES Licee(id)
);

CREATE TABLE Camine
(
    id int PRIMARY KEY,
    numar int NOT NULL,
    adresa varchar(100) NOT NULL,
    numar_total_camere int NOT NULL,
    liceu_id int,
    FOREIGN KEY (liceu_id) REFERENCES Licee(id)
);

CREATE TABLE Camere
(
    id int PRIMARY KEY,
    numar int NOT NULL,
    capacitate int NOT NULL,
    camin_id int,
    FOREIGN KEY (camin_id) REFERENCES Camine(id)
);

CREATE TABLE CazareElev
(
    id int PRIMARY KEY,
    id_elev int,
    data_sosire date NOT NULL,
    data_plecare date NOT NULL,
    camera_id int,
    FOREIGN KEY (id_elev) REFERENCES Elevi(id),
    FOREIGN KEY (camera_id) REFERENCES Camere(id)
);

-- Create sequences
CREATE SEQUENCE licee_seq START WITH 1 INCREMENT BY 1;

CREATE TRIGGER licee_trigger
    BEFORE INSERT
    ON Licee
    FOR EACH ROW
BEGIN
    SELECT licee_seq.NEXTVAL INTO :new.id FROM DUAL;
END;
/

CREATE SEQUENCE elevi_seq START WITH 1 INCREMENT BY 1;

CREATE TRIGGER elevi_trigger
    BEFORE INSERT
    ON Elevi
    FOR EACH ROW
BEGIN
    SELECT elevi_seq.NEXTVAL INTO :new.id FROM DUAL;
END;
/

CREATE SEQUENCE camine_seq START WITH 1 INCREMENT BY 1;

CREATE TRIGGER camine_trigger
    BEFORE INSERT
    ON Camine
    FOR EACH ROW
BEGIN
    SELECT camine_seq.NEXTVAL INTO :new.id FROM DUAL;
END;
/

CREATE SEQUENCE camere_seq START WITH 1 INCREMENT BY 1;

CREATE TRIGGER camere_trigger
    BEFORE INSERT
    ON Camere
    FOR EACH ROW
BEGIN
    SELECT camere_seq.NEXTVAL INTO :new.id FROM DUAL;
END;
/

CREATE SEQUENCE cazare_elev_seq START WITH 1 INCREMENT BY 1;

CREATE TRIGGER cazare_elev_trigger
    BEFORE INSERT
    ON CazareElev
    FOR EACH ROW
BEGIN
    SELECT cazare_elev_seq.NEXTVAL INTO :new.id FROM DUAL;
END;
/

COMMIT;
