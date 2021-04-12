CREATE TABLE IF NOT EXISTS regions
(
    RegionID serial NOT NULL PRIMARY KEY,
    Region   varchar(255)
);

CREATE TABLE IF NOT EXISTS posts
(
    PostID serial NOT NULL PRIMARY KEY,
    Content varchar(255) NOT NULL,
    Created timestamp NOT NULL,
    Updated timestamp,
    UserID int NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    UserID serial NOT NULL PRIMARY KEY,
    FirstName varchar(255) NOT NULL,
    LastName varchar(255) NOT NULL,
    RegionID int NOT NULL,
    Role varchar(50)
)