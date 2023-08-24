USE ENCHERES
GO
CREATE TABLE Roles
(
    Pseudo VARCHAR(255) NOT NULL,
    Role   VARCHAR(50)  NOT NULL,


)

ALTER TABLE Roles
    ADD constraint PK_ROLE PRIMARY KEY (Pseudo, Role)

CREATE TABLE Taille
(
    Nom   VARCHAR(20)            not null,
    Id    INTEGER IDENTITY (1,1) not null
        CONSTRAINT PK_Taille PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE Energie
(
    Nom   VARCHAR(20)            not null,
    Id    INTEGER IDENTITY (1,1) not null
        CONSTRAINT PK_Energie PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE Localisation
(
    Nom   VARCHAR(20)            not null,
    Id    INTEGER IDENTITY (1,1) not null
        CONSTRAINT PK_Localisation PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE Type
(
    Nom   VARCHAR(20)            not null,
    Id    INTEGER IDENTITY (1,1) not null
        CONSTRAINT PK_Type PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE Marque
(
    Nom    VARCHAR(20)            not null,
    Id     INTEGER IDENTITY (1,1) not null
        CONSTRAINT PK_Marque PRIMARY KEY,
    Texte  VARCHAR(255),
    IdType INT
        CONSTRAINT FK_IdTypeMarque FOREIGN KEY
        REFERENCES Type (Id) ON DELETE CASCADE,
);

CREATE TABLE Couleur
(
    Nom   VARCHAR(20)            not null,
    Id    INTEGER IDENTITY (1,1) not null
        CONSTRAINT PK_Couleur PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE Coupe
(
    Nom   VARCHAR(20)            not null,
    Id    INTEGER IDENTITY (1,1) not null
        CONSTRAINT PK_Coupe PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE ModaliteRetrait
(
    Nom   VARCHAR(20)            not null,
    Id    INTEGER IDENTITY (1,1) not null
        CONSTRAINT PK_Moda PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE UTILISATEURS
(

    Id      INTEGER IDENTITY (1,1) NOT NULL,
    pseudo  VARCHAR(30)            NOT NULL,
    nom     VARCHAR(30)            NOT NULL,
    prenom  VARCHAR(30)            NOT NULL,
    email   VARCHAR(20)            NOT NULL,
    tel     VARCHAR(15),
    adresse VARCHAR(50)            NOT NULL,
    mdp     VARCHAR(255)           NOT NULL,
    credit  INTEGER                NOT NULL,
    admin   bit                    NOT NULL
)
ALTER TABLE UTILISATEURS
    ADD constraint utilisateur_pk PRIMARY KEY (Id)


CREATE TABLE Objet
(
    Energie        CHAR(1),
    Id             INTEGER IDENTITY (1,1)
        CONSTRAINT PK_Objet PRIMARY KEY,
    NbRoue         INT,
    Annee          SMALLINT,
    Portable       bit,
    Encastarble    bit,
    DateD          DATE,
    DateF          DATE,
    prixD          int,
    Adresse        VARCHAR(255) not null,
    nom            VARCHAR(255),
    description    VARCHAR(255),
    iDUtilisateur  int
        CONSTRAINT FK_iDUtilisateur FOREIGN KEY
        REFERENCES UTILISATEURS (Id) ON DELETE CASCADE,
    idRetrait      INT
        CONSTRAINT FK_idRetrait FOREIGN KEY
        REFERENCES ModaliteRetrait (Id) ON DELETE CASCADE,

    idCoupe        INT
        CONSTRAINT FK_IdCoupe FOREIGN KEY
        REFERENCES Coupe (Id) ON DELETE CASCADE,
    IdCouleur      INT
        CONSTRAINT FK_IdCouleur FOREIGN KEY
        REFERENCES Couleur (Id) ON DELETE CASCADE,
    IdMarque       INT
        CONSTRAINT FK_IdMarque FOREIGN KEY
        REFERENCES Marque (Id) ON DELETE CASCADE,
    IdType         INT
        CONSTRAINT FK_IdType FOREIGN KEY
        REFERENCES Type (Id) ON DELETE NO ACTION,
    IdLocalisation INT
        CONSTRAINT FK_IdLocalisation FOREIGN KEY
        REFERENCES Localisation (Id) ON DELETE CASCADE,
    IdEnergie      INT
        CONSTRAINT FK_IdEnergie FOREIGN KEY
        REFERENCES Energie (Id) ON DELETE CASCADE,
    IdTaille       INT
        CONSTRAINT FK_IdTaille FOREIGN KEY
        REFERENCES Taille (Id) ON DELETE CASCADE,

);

CREATE TABLE Enchere
(
    Id      INTEGER IDENTITY (1,1) not null
        CONSTRAINT PK_Enchere PRIMARY KEY,
    Prix    INT,
    IdObjet INT
        CONSTRAINT FK_IdObjet FOREIGN KEY
        REFERENCES Objet (Id) ON DELETE CASCADE,


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
INSERT INTO Type
VALUES ('serv', 'Service');

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
VALUES ('ct', 'Charlotte Tilbury', 4);
INSERT INTO Marque
VALUES ('ysl', 'Yves Saint Laurent', 4);
INSERT INTO Marque
VALUES ('or', 'Or Rejuvenic', 4);
INSERT INTO Marque
VALUES ('lm', 'La Mer', 4);

INSERT INTO Marque
VALUES ('lambo', 'Lamborghini', 1);
INSERT INTO Marque
VALUES ('bentley', 'Bentley', 1);
INSERT INTO Marque
VALUES ('rolls', 'Rolls-Royce', 1);
INSERT INTO Marque
VALUES ('aston', 'Aston Martin', 1);
INSERT INTO Marque
VALUES ('ferrari', 'Ferrari', 1);

INSERT INTO Marque
VALUES ('apple', 'Apple', 6);
INSERT INTO Marque
VALUES ('samsung', 'Samsung', 6);
INSERT INTO Marque
VALUES ('leica', 'Leica', 6);
INSERT INTO Marque
VALUES ('luva', 'Luvaglio', 6);
INSERT INTO Marque
VALUES ('alien', 'Alienware', 6);

INSERT INTO Marque
VALUES ('nintendo', 'Nintendo', 2);
INSERT INTO Marque
VALUES ('sony', 'Sony', 2);
INSERT INTO Marque
VALUES ('microsoft', 'Microsoft', 2);
INSERT INTO Marque
VALUES ('sega', 'Sega', 2);

INSERT INTO Marque
VALUES ('whirlpool', 'Whirlpool', 5);
INSERT INTO Marque
VALUES ('smeg', 'SMEG', 5);
INSERT INTO Marque
VALUES ('electro', 'Electrolux', 5);

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
VALUES (null, '4', 2010, null, null, '18-02-2022', '18-02-2025', 10, '5 Rue du chateau deau', 'Lambo' , 'aventador',  null, 1,null, 1, 10, 1, 4, 3,
        null);


INSERT INTO Objet
VALUES (null, '4', 2010, null, null, '18-02-2022', '18-02-2021', 10, '5 Rue du chateau deau', 'Lambo','Rose' , null, 1,null, 1, 10, 1, 4, 3,
        null);
INSERT INTO Objet
VALUES (null, '4', 2010, null, null, '18-02-2022', '18-02-2021', 10, '5 Rue du chateau deau', 'lambo', 'pas rose', null, 1,null, 1, 10, 1, 4, 3,
        null);
INSERT INTO Objet
VALUES (null, '4', 2010, null, null, '18-02-2022', '18-02-2025', 10, '5 Rue du chateau deau', 'lambo' , 'test',  null, 1,null, 1, 10, 1, 4, 3,
        null);

INSERT INTO Enchere
VALUES (1, 1);