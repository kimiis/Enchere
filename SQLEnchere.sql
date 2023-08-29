
USE ENCHERES
GO
CREATE TABLE UTILISATEURS
(
    Id      INTEGER IDENTITY (1,1) NOT NULL constraint utilisateur_pk PRIMARY KEY (Id),
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
CREATE TABLE Roles
(
    Pseudo VARCHAR(30) NOT NULL,
    Role   VARCHAR(50)  NOT NULL,
    PRIMARY KEY (Pseudo, Role),

)

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
    idAcheteur int
        CONSTRAINT FK_idAcheteur FOREIGN KEY
        REFERENCES UTILISATEURS (Id) ,
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



INSERT INTO ENCHERES.dbo.UTILISATEURS (pseudo, nom, prenom, email, tel, adresse, mdp, credit, admin) VALUES ( N'omaiki', N'', N'', N'kimi.0208@outlook.fr', N'', N'', N'{bcrypt}$2a$10$mQUaZaE8Xdq6eGJa.y8tnOCVjeD0AW0pVw1WkV.FtpwrECzagFRdm', 500000, 0);
INSERT INTO ENCHERES.dbo.UTILISATEURS (pseudo, nom, prenom, email, tel, adresse, mdp, credit, admin) VALUES ( N'erb', N'Kim', N'ISABELLE', N'kimi.0208@outlook.fr', N'0631255117', N'7 rue du zambeze', N'{bcrypt}$2a$10$PRix.wleDcc1NFEhAvQdb.GxQ/W9daMIHd2AcUPSAZEhLMgSNjSg.', 500000, 0);

INSERT INTO ENCHERES.dbo.Objet (Energie, NbRoue, Annee, Portable, Encastarble, DateD, DateF, prixD, Adresse, nom, description, iDUtilisateur, idRetrait, idCoupe, IdCouleur, IdMarque, IdType, IdLocalisation, IdEnergie, IdTaille) VALUES (null, 4, 2010, null, 1, N'2022-02-18', N'2025-02-18', 10, N'5 Rue du chateau deau', N'Lambo', N'aventador', 1, 1, null, 1, 10, 1, 4, 3, null);
INSERT INTO ENCHERES.dbo.Objet (Energie, NbRoue, Annee, Portable, Encastarble, DateD, DateF, prixD, Adresse, nom, description, iDUtilisateur, idRetrait, idCoupe, IdCouleur, IdMarque, IdType, IdLocalisation, IdEnergie, IdTaille) VALUES (null, 4, 2010, null, null, N'2022-02-18', N'2021-02-18', 10, N'5 Rue du chateau deau', N'Lambo', N'Rose', 1, 1, null, 1, 10, 1, 4, 3, null);
INSERT INTO ENCHERES.dbo.Objet (Energie, NbRoue, Annee, Portable, Encastarble, DateD, DateF, prixD, Adresse, nom, description, iDUtilisateur, idRetrait, idCoupe, IdCouleur, IdMarque, IdType, IdLocalisation, IdEnergie, IdTaille) VALUES (null, 4, 2010, null, null, N'2022-02-18', N'2021-02-18', 10, N'5 Rue du chateau deau', N'lambo', N'pas rose', 1, 1, null, 1, 10, 1, 4, 3, null);
INSERT INTO ENCHERES.dbo.Objet (Energie, NbRoue, Annee, Portable, Encastarble, DateD, DateF, prixD, Adresse, nom, description, iDUtilisateur, idRetrait, idCoupe, IdCouleur, IdMarque, IdType, IdLocalisation, IdEnergie, IdTaille) VALUES (null, 4, 2010, null, null, N'2022-02-18', N'2025-02-18', 10, N'5 Rue du chateau deau', N'lambo', N'test', 1, 1, null, 1, 10, 1, 4, 3, null);
INSERT INTO ENCHERES.dbo.Objet (Energie, NbRoue, Annee, Portable, Encastarble, DateD, DateF, prixD, Adresse, nom, description, iDUtilisateur, idRetrait, idCoupe, IdCouleur, IdMarque, IdType, IdLocalisation, IdEnergie, IdTaille) VALUES (N'a', 3, 2019, 1, 1, N'2023-08-25', N'2023-08-27', 2, N'', N'Dacia', N'Sandero', 1, 4, 9, 1, 19, 3, 15, 4, 3);
INSERT INTO ENCHERES.dbo.Objet (Energie, NbRoue, Annee, Portable, Encastarble, DateD, DateF, prixD, Adresse, nom, description, iDUtilisateur, idRetrait, idCoupe, IdCouleur, IdMarque, IdType, IdLocalisation, IdEnergie, IdTaille) VALUES (N'b', 5, 1900, 1, 1, N'2023-08-27', N'2024-01-01', 5000, N'', N'bentley', N'miniature', 1, 3, 11, 6, 4, 1, 18, 1, 6);
INSERT INTO ENCHERES.dbo.Objet (Energie, NbRoue, Annee, Portable, Encastarble, DateD, DateF, prixD, Adresse, nom, description, iDUtilisateur, idRetrait, idCoupe, IdCouleur, IdMarque, IdType, IdLocalisation, IdEnergie, IdTaille) VALUES (N'b', 5, 1900, 1, 1, N'2023-08-27', N'2024-01-01', 5000, N'', N'bentley', N'miniature', 1, 3, 11, 6, 4, 1, 18, 1, 6);
INSERT INTO ENCHERES.dbo.Objet (Energie, NbRoue, Annee, Portable, Encastarble, DateD, DateF, prixD, Adresse, nom, description, iDUtilisateur, idRetrait, idCoupe, IdCouleur, IdMarque, IdType, IdLocalisation, IdEnergie, IdTaille) VALUES (N'd', 12, 2020, 0, 0, N'2023-08-27', N'2023-12-27', 1, N'', N'licorne', N'pas cher', 1, 1, 8, 3, 14, 1, 5, 2, 3);
INSERT INTO ENCHERES.dbo.Objet (Energie, NbRoue, Annee, Portable, Encastarble, DateD, DateF, prixD, Adresse, nom, description, iDUtilisateur, idRetrait, idCoupe, IdCouleur, IdMarque, IdType, IdLocalisation, IdEnergie, IdTaille) VALUES (N'f', 4, 2010, 1, 0, N'2023-08-27', N'2025-06-27', 100000, N'', N'poussin', N'qui attend', 1, 4, 9, 4, 5, 1, 7, 4, 4);
INSERT INTO ENCHERES.dbo.Enchere ( Prix, IdObjet, idAcheteur) VALUES ( 1, 1, 1);
INSERT INTO ENCHERES.dbo.Enchere ( Prix, IdObjet, idAcheteur) VALUES ( 2, 2, 1);
INSERT INTO ENCHERES.dbo.Enchere ( Prix, IdObjet, idAcheteur) VALUES ( 3, 1, 1);
INSERT INTO ENCHERES.dbo.Enchere ( Prix, IdObjet, idAcheteur) VALUES ( 11, 1, 2);
INSERT INTO ENCHERES.dbo.Enchere ( Prix, IdObjet, idAcheteur) VALUES ( 12, 1, 1);
INSERT INTO ENCHERES.dbo.Enchere ( Prix, IdObjet, idAcheteur) VALUES ( 15, 1, 2);

Insert Into Roles(Pseudo, Role) VALUES ('omaiki', 'ROLE_CLIENT')
    Insert Into Roles(Pseudo, Role) VALUES ('erb', 'ROLE_CLIENT')