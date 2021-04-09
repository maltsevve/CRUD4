CREATE TABLE IF NOT EXISTS posts
(
    PostID serial NOT NULL PRIMARY KEY,
    Content varchar(255) NOT NULL,
    Created timestamp NOT NULL,
    Updated timestamp,
    UserID int NOT NULL
)