create table VIDEO_GAME
(
    ID    int          not null AUTO_INCREMENT,
    TITLE varchar(100) not null,
    PRIMARY KEY (ID)
);
create table PROMOTION
(
    ID           int not null AUTO_INCREMENT,
    VALID_FROM   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRICE        numeric(5, 2),
    VIDEO_GAME_ID int not null,
    PRIMARY KEY (ID),
    CONSTRAINT fk_VIDEO_GAME_ID_PROMOTION
        FOREIGN KEY (VIDEO_GAME_ID)
            REFERENCES VIDEO_GAME (ID)
);


create table STOCK
(
    ID      INT        not null AUTO_INCREMENT,
    AVAILABILITY boolean,
    LAST_UPDATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    VIDEO_GAME_ID int        not null,
    PRIMARY KEY (ID),
    CONSTRAINT fk_VIDEO_GAME_ID_STOCK
        FOREIGN KEY (VIDEO_GAME_ID)
            REFERENCES VIDEO_GAME (ID)
);





