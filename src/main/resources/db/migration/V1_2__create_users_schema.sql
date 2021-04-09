CREATE TABLE IF NOT EXISTS users
(
    UserID serial NOT NULL PRIMARY KEY,
    FirstName varchar(255) NOT NULL,
    LastName varchar(255) NOT NULL,
    RegionID int NOT NULL,
    Role varchar(50)
)