USE ENCHERES
GO

CREATE TABLE Taille
(
    Nom   VARCHAR(20) not null,
    Id    INT         not null
        CONSTRAINT PK_Taille PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE Energie
(
    Nom   VARCHAR(20) not null,
    Id    INT         not null
        CONSTRAINT PK_Energie PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE Localisation
(
    Nom   VARCHAR(20) not null,
    Id    INT         not null
        CONSTRAINT PK_Localisation PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE Type
(
    Nom   VARCHAR(20) not null,
    Id    INT         not null
        CONSTRAINT PK_Type PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE Marque
(
    Nom   VARCHAR(20) not null,
    Id    INT         not null
        CONSTRAINT PK_Marque PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE Couleur
(
    Nom   VARCHAR(20) not null,
    Id    INT         not null
        CONSTRAINT PK_Couleur PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE Coupe
(
    Nom   VARCHAR(20) not null,
    Id    INT         not null
        CONSTRAINT PK_Coupe PRIMARY KEY,
    Texte VARCHAR(255)
);

CREATE TABLE Enchere
(
    Nom     VARCHAR(20) not null,
    Id      INT         not null
        CONSTRAINT PK_Enchere PRIMARY KEY,
    Texte   VARCHAR(255),
    DateD   DATE,
    DateF   DATE,
    Prix    INT,
    IdObjet INT
        CONSTRAINT FK_IdObjet FOREIGN KEY
            REFERENCES Objet (Id) ON DELETE CASCADE,

);

CREATE TABLE Objet
(
    Energie        CHAR(1),
    Id             INT
        CONSTRAINT PK_Coupe PRIMARY KEY,
    NbRoue         INT,
    Annee          SMALLINT,
    Portable       bit,
    Encastarble    bit,
    IdCoupe        INT
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
            REFERENCES Type (Id) ON DELETE CASCADE,
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

INSERT INTO Coupe VALUES ('slim',1,'Slim');
INSERT INTO Coupe VALUES ('straight',2,'Straight');
INSERT INTO Coupe VALUES ('mom',3,'Mom');
INSERT INTO Coupe VALUES ('skinny',4,'Skinny');

INSERT INTO Coupe VALUES ('long',5,'Long');
INSERT INTO Coupe VALUES ('midi',6,'Midi');
INSERT INTO Coupe VALUES ('court',7,'Court');

INSERT INTO Coupe VALUES ('oversize',8,'Oversize');
INSERT INTO Coupe VALUES ('court',9,'Court');
INSERT INTO Coupe VALUES ('long',10,'Long');
INSERT INTO Coupe VALUES ('wf',11,'Wide-fit');

INSERT INTO Couleur VALUES ('rose',1,'Rose');
INSERT INTO Couleur VALUES ('jaune',2,'Jaune');
INSERT INTO Couleur VALUES ('blanc',3,'Blanc');
INSERT INTO Couleur VALUES ('noir',4,'Noir');
INSERT INTO Couleur VALUES ('rouge',5,'Rouge');
INSERT INTO Couleur VALUES ('bleu',6,'Bleu');

INSERT INTO Marque VALUES ('lv',1,'Louis Vuitton');
INSERT INTO Marque VALUES ('armani',2,'Armani');
INSERT INTO Marque VALUES ('th',3,'Tommy Hilfiger');
INSERT INTO Marque VALUES ('dior',4,'Dior');
INSERT INTO Marque VALUES ('channel',5,'Channel');

INSERT INTO Marque VALUES ('ct',6,'Charlotte Tilbury');
INSERT INTO Marque VALUES ('ysl',7,'Yves Saint Laurent');
INSERT INTO Marque VALUES ('or',8,'Or Rejuvenic');
INSERT INTO Marque VALUES ('lm',9,'La Mer');

INSERT INTO Marque VALUES ('lambo',10,'Lamborghini');
INSERT INTO Marque VALUES ('bentley',11,'Bentley');
INSERT INTO Marque VALUES ('rolls',12,'Rolls-Royce');
INSERT INTO Marque VALUES ('aston',13,'Aston Martin');
INSERT INTO Marque VALUES ('ferrari',14,'Ferrari');

INSERT INTO Marque VALUES ('apple',15,'Apple');
INSERT INTO Marque VALUES ('samsung',16,'Samsung');
INSERT INTO Marque VALUES ('leica',17,'Leica');
INSERT INTO Marque VALUES ('luva',18,'Luvaglio');
INSERT INTO Marque VALUES ('alien',19,'Alienware');

INSERT INTO Marque VALUES ('nintendo',20,'Nintendo');
INSERT INTO Marque VALUES ('sony',21,'Sony');
INSERT INTO Marque VALUES ('microsoft',22,'Microsoft');
INSERT INTO Marque VALUES ('sega',23,'Sega');

INSERT INTO Marque VALUES ('whirlpool',24,'Whirlpool');
INSERT INTO Marque VALUES ('smeg',25,'SMEG');
INSERT INTO Marque VALUES ('electro',26,'Electrolux');

INSERT INTO Type VALUES ('vehicule',1,'Vehicule');
INSERT INTO Type VALUES ('console',2,'Console');
INSERT INTO Type VALUES ('vet',3,'Vetement');
INSERT INTO Type VALUES ('pb',4,'Produit de beaute');
INSERT INTO Type VALUES ('elec',5,'Electromenager');
INSERT INTO Type VALUES ('ht',6,'High-Tech');

INSERT INTO Localisation VALUES ('bret',1,'Bretagne');
INSERT INTO Localisation VALUES ('pl',2,'Pays de la Loire');
INSERT INTO Localisation VALUES ('na',3,'Nouvelle Aquitaine');
INSERT INTO Localisation VALUES ('occi',4,'Occitanie');
INSERT INTO Localisation VALUES ('prov',5,'Provence-Alpes-Cotes-Azur');
INSERT INTO Localisation VALUES ('corse',6,'Corse');
INSERT INTO Localisation VALUES ('auv',7,'Auvergne-Rhone-Alpes');
INSERT INTO Localisation VALUES ('bourg',8,'Bourgogne-Franche-Comte');
INSERT INTO Localisation VALUES ('centre',9,'Centre-Val de Loire');
INSERT INTO Localisation VALUES ('ile',10,'Ile de France');
INSERT INTO Localisation VALUES ('ge',11,'Grand Est');
INSERT INTO Localisation VALUES ('hf',12,'Hauts de France');
INSERT INTO Localisation VALUES ('norm',13,'Normandie');
INSERT INTO Localisation VALUES ('guad',14,'Guadeloupe');
INSERT INTO Localisation VALUES ('may',15,'Mayotte');
INSERT INTO Localisation VALUES ('mart',16,'Martinique');
INSERT INTO Localisation VALUES ('guy',17,'Guyane');
INSERT INTO Localisation VALUES ('reu',18,'La Reunion');

INSERT INTO Energie VALUES ('diesel',1,'Diesel');
INSERT INTO Energie VALUES ('sp95',2,'SP-95');
INSERT INTO Energie VALUES ('sp98',3,'SP-98');
INSERT INTO Energie VALUES ('hybride',4,'Hybride');

INSERT INTO Taille VALUES ('xs',1,'Xs');
INSERT INTO Taille VALUES ('s',2,'S');
INSERT INTO Taille VALUES ('m',3,'M');
INSERT INTO Taille VALUES ('l',4,'L');
INSERT INTO Taille VALUES ('xl',5,'XL');
INSERT INTO Taille VALUES ('xxl',6,'XXL');

INSERT INTO Objet VALUES (null,1,'4',2010,null,null,null,1,10,1,4,3,null);

INSERT INTO Enchere VALUES ('lambo',1,'rose',25/08/2023,25/08/2024,1,1);

