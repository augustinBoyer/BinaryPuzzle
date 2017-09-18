DROP TABLE Statistic;
DROP TABLE Player;
DROP SEQUENCE seq_PlayerId;
--
CREATE TABLE Player
(
	Id number(8) NOT NULL,
	FirstName varchar2(25) NOT NULL,
	LastName varchar2(25) NOT NULL
);

CREATE TABLE Statistic
(
	Id number(8) NOT NULL,
	NbPlayed number(6) NOT NULL,
	NbResolved number(6) NOT NULL
);

ALTER TABLE Player ADD
(
    CONSTRAINT PK_PlayerId PRIMARY KEY (Id)
);

ALTER TABLE Statistic ADD
(
    CONSTRAINT PK_StatisticId PRIMARY KEY (Id),
    CONSTRAINT FK_Id FOREIGN KEY (Id) REFERENCES Player (Id)
);

CREATE SEQUENCE seq_PlayerId START WITH 1;

INSERT INTO Player (Id, FirstName, LastName) VALUES (seq_PlayerId.nextval, 'Alexandre', 'Ribeiro');
INSERT INTO Statistic (Id, NbPlayed, NbResolved) VALUES (1, 100, 50);

INSERT INTO Player (Id, FirstName, LastName) VALUES (seq_PlayerId.nextval, 'Augustin', 'Boyer');
INSERT INTO Statistic (Id, NbPlayed, NbResolved) VALUES (2, 100, 100);