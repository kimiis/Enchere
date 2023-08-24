USE ENCHERES

GO

CREATE TABLE Roles

(

    Pseudo VARCHAR(255) NOT NULL,

    Role VARCHAR(50) NOT NULL,



)


ALTER TABLE Roles

    ADD constraint PK_ROLE PRIMARY KEY (Pseudo, Role)


CREATE TABLE Taille

(

    nom VARCHAR(20) not null,

    id INTEGER idENTITY (1,1) not null

        CONSTRAINT PK_Taille PRIMARY KEY,

    texte VARCHAR(255)

);


CREATE TABLE Energie

(

    nom VARCHAR(20) not null,

    id INTEGER idENTITY (1,1) not null

        CONSTRAINT PK_Energie PRIMARY KEY,

    texte VARCHAR(255)

);


CREATE TABLE Localisation

(

    nom VARCHAR(20) not null,

    id INTEGER idENTITY (1,1) not null

        CONSTRAINT PK_Localisation PRIMARY KEY,

    texte VARCHAR(255)

);


CREATE TABLE Type

(

    nom VARCHAR(20) not null,

    id INTEGER idENTITY (1,1) not null

        CONSTRAINT PK_Type PRIMARY KEY,

    texte VARCHAR(255)

);


CREATE TABLE Marque

(

    nom VARCHAR(20) not null,

    id INTEGER idENTITY (1,1) not null

        CONSTRAINT PK_Marque PRIMARY KEY,

    texte VARCHAR(255),

    idType INT

        CONSTRAINT FK_idTypeMarque FOREIGN KEY

        REFERENCES Type (id) ON DELETE CASCADE,

);


CREATE TABLE Couleur

(

    nom VARCHAR(20) not null,

    id INTEGER idENTITY (1,1) not null

        CONSTRAINT PK_Couleur PRIMARY KEY,

    texte VARCHAR(255)

);


CREATE TABLE Coupe

(

    nom VARCHAR(20) not null,

    id INTEGER idENTITY (1,1) not null

        CONSTRAINT PK_Coupe PRIMARY KEY,

    texte VARCHAR(255)

);


CREATE TABLE ModaliteRetrait

(

    nom VARCHAR(20) not null,

    id INTEGER idENTITY (1,1) not null

        CONSTRAINT PK_Moda PRIMARY KEY,

    texte VARCHAR(255)

);


CREATE TABLE UTILISATEURS

(


    id INTEGER idENTITY (1,1) NOT NULL,

    pseudo VARCHAR(30) NOT NULL,

    nom VARCHAR(30) NOT NULL,

    prenom VARCHAR(30) NOT NULL,

    email VARCHAR(20) NOT NULL,

    tel VARCHAR(15),

    adresse VARCHAR(50) NOT NULL,

    mdp VARCHAR(255) NOT NULL,

    credit INTEGER NOT NULL,

    admin bit NOT NULL

)

ALTER TABLE UTILISATEURS

    ADD constraint utilisateur_pk PRIMARY KEY (id)



CREATE TABLE Objet

(

    energie CHAR(1),

    id INTEGER idENTITY (1,1)

        CONSTRAINT PK_Objet PRIMARY KEY ,

    nbRoue INT,

    annee SMALLINT,

    portable bit,

    encastarble bit,

    dateD DATE,

    dateF DATE,

    prixD int,

    adresse VARCHAR(255) not null,

    idUtilisateur int

        CONSTRAINT FK_idUtilisateur FOREIGN KEY

        REFERENCES UTILISATEURS (id) ON DELETE CASCADE,

    idCoupe INT

        CONSTRAINT FK_idCoupe FOREIGN KEY

        REFERENCES Coupe (id) ON DELETE CASCADE,

    idCouleur INT

        CONSTRAINT FK_idCouleur FOREIGN KEY

        REFERENCES Couleur (id) ON DELETE CASCADE,

    idMarque INT

        CONSTRAINT FK_idMarque FOREIGN KEY

        REFERENCES Marque (id) ON DELETE CASCADE,

    idType INT

        CONSTRAINT FK_idType FOREIGN KEY

        REFERENCES Type (id) ON DELETE NO ACTION,

    idLocalisation INT

        CONSTRAINT FK_idLocalisation FOREIGN KEY

        REFERENCES Localisation (id) ON DELETE CASCADE,

    idEnergie INT

        CONSTRAINT FK_idEnergie FOREIGN KEY

        REFERENCES Energie (id) ON DELETE CASCADE,

    idTaille INT

        CONSTRAINT FK_idTaille FOREIGN KEY

        REFERENCES Taille (id) ON DELETE CASCADE,


);


CREATE TABLE Enchere

(

    nom VARCHAR(20) not null,

    id INTEGER idENTITY (1,1) not null

        CONSTRAINT PK_Enchere PRIMARY KEY,

    texte VARCHAR(255),

    prix INT,

    idObjet INT

        CONSTRAINT FK_idObjet FOREIGN KEY

        REFERENCES Objet (id) ON DELETE CASCADE,

    idModa INT

        CONSTRAINT FK_idModa FOREIGN KEY

        REFERENCES ModaliteRetrait (id) ON DELETE CASCADE


);


INSERT INTO Coupe

VALUES ('slim', 'Slim');

INSERT INTO Coupe

VALUES ('straight', 'Straight');

INSERT INTO Coupe

VALUES ('mom', 'Mom');

INSERT INTO Coupe

VALUES ('skinny', 'Skinny');


INSERT INTO Coupe

VALUES ('long', 'Long');

INSERT INTO Coupe

VALUES ('midi', 'Midi');

INSERT INTO Coupe

VALUES ('court', 'Court');


INSERT INTO Coupe

VALUES ('oversize', 'Oversize');

INSERT INTO Coupe

VALUES ('court', 'Court');

INSERT INTO Coupe

VALUES ('long', 'Long');

INSERT INTO Coupe

VALUES ('wf', 'Wide-fit');


INSERT INTO Couleur

VALUES ('rose', 'Rose');

INSERT INTO Couleur

VALUES ('jaune', 'Jaune');

INSERT INTO Couleur

VALUES ('blanc', 'Blanc');

INSERT INTO Couleur

VALUES ('noir', 'Noir');

INSERT INTO Couleur

VALUES ('rouge', 'Rouge');

INSERT INTO Couleur

VALUES ('bleu', 'Bleu');


INSERT INTO Type

VALUES ('vehicule', 'Vehicule');

INSERT INTO Type

VALUES ('console', 'Console');

INSERT INTO Type

VALUES ('vet', 'Vetement');

INSERT INTO Type

VALUES ('pb', 'Produit de beaute');

INSERT INTO Type

VALUES ('elec', 'Electromenager');

INSERT INTO Type

VALUES ('ht', 'High-Tech');


INSERT INTO Marque

VALUES ('lv', 'Louis Vuitton', 3);

INSERT INTO Marque

VALUES ('armani', 'Armani', 3);

INSERT INTO Marque

VALUES ('th', 'Tommy Hilfiger', 3);

INSERT INTO Marque

VALUES ('dior', 'Dior', 3);

INSERT INTO Marque

VALUES ('channel', 'Channel', 3);


INSERT INTO Marque

VALUES ('ct', 'Charlotte Tilbury',4);

INSERT INTO Marque

VALUES ('ysl', 'Yves Saint Laurent',4);

INSERT INTO Marque

VALUES ('or', 'Or Rejuvenic',4);

INSERT INTO Marque

VALUES ('lm', 'La Mer',4);


INSERT INTO Marque

VALUES ('lambo', 'Lamborghini',1);

INSERT INTO Marque

VALUES ('bentley', 'Bentley',1);

INSERT INTO Marque

VALUES ('rolls', 'Rolls-Royce',1);

INSERT INTO Marque

VALUES ('aston', 'Aston Martin',1);

INSERT INTO Marque

VALUES ('ferrari', 'Ferrari',1);


INSERT INTO Marque

VALUES ('apple', 'Apple',6);

INSERT INTO Marque

VALUES ('samsung', 'Samsung',6);

INSERT INTO Marque

VALUES ('leica', 'Leica',6);

INSERT INTO Marque

VALUES ('luva', 'Luvaglio',6);

INSERT INTO Marque

VALUES ('alien', 'Alienware',6);


INSERT INTO Marque

VALUES ('nintendo', 'Nintendo',2);

INSERT INTO Marque

VALUES ('sony', 'Sony',2);

INSERT INTO Marque

VALUES ('microsoft', 'Microsoft',2);

INSERT INTO Marque

VALUES ('sega', 'Sega',2);


INSERT INTO Marque

VALUES ('whirlpool', 'Whirlpool',5);

INSERT INTO Marque

VALUES ('smeg', 'SMEG',5);

INSERT INTO Marque

VALUES ('electro', 'Electrolux',5);


INSERT INTO Localisation

VALUES ('bret', 'Bretagne');

INSERT INTO Localisation

VALUES ('pl', 'Pays de la Loire');

INSERT INTO Localisation

VALUES ('na', 'Nouvelle Aquitaine');

INSERT INTO Localisation

VALUES ('occi', 'Occitanie');

INSERT INTO Localisation

VALUES ('prov', 'Provence-Alpes-Cotes-Azur');

INSERT INTO Localisation

VALUES ('corse', 'Corse');

INSERT INTO Localisation

VALUES ('auv', 'Auvergne-Rhone-Alpes');

INSERT INTO Localisation

VALUES ('bourg', 'Bourgogne-Franche-Comte');

INSERT INTO Localisation

VALUES ('centre', 'Centre-Val de Loire');

INSERT INTO Localisation

VALUES ('ile', 'Ile de France');

INSERT INTO Localisation

VALUES ('ge', 'Grand Est');

INSERT INTO Localisation

VALUES ('hf', 'Hauts de France');

INSERT INTO Localisation

VALUES ('norm', 'Normandie');

INSERT INTO Localisation

VALUES ('guad', 'Guadeloupe');

INSERT INTO Localisation

VALUES ('may', 'Mayotte');

INSERT INTO Localisation

VALUES ('mart', 'Martinique');

INSERT INTO Localisation

VALUES ('guy', 'Guyane');

INSERT INTO Localisation

VALUES ('reu', 'La Reunion');


INSERT INTO Energie

VALUES ('diesel', 'Diesel');

INSERT INTO Energie

VALUES ('sp95', 'SP-95');

INSERT INTO Energie

VALUES ('sp98', 'SP-98');

INSERT INTO Energie

VALUES ('hybride', 'Hybride');


INSERT INTO Taille

VALUES ('xs', 'Xs');

INSERT INTO Taille

VALUES ('s', 'S');

INSERT INTO Taille

VALUES ('m', 'M');

INSERT INTO Taille

VALUES ('l', 'L');

INSERT INTO Taille

VALUES ('xl', 'XL');

INSERT INTO Taille

VALUES ('xxl', 'XXL');


INSERT INTO ModaliteRetrait

VALUES ('mp', 'Main propre');

INSERT INTO ModaliteRetrait

VALUES ('rel', 'Point Relais');

INSERT INTO ModaliteRetrait

VALUES ('relay', 'Mondial relay');

INSERT INTO ModaliteRetrait

VALUES ('livre', 'Livraison');


INSERT INTO Objet

VALUES (null, '4', 2010, null, null, '18-02-2022', '18-02-2025', 10, '5 Rue du chateau deau', null, 1, 1, 10, 1, 4, 3,

        null);


INSERT INTO Enchere

VALUES ('lambo', 'rose', 1, 1, 1);