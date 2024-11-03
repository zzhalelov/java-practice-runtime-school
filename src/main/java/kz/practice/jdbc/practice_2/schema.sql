CREATE TABLE cat
(
    id    SERIAL PRIMARY KEY,
    name  TEXT,
    color TEXT
);

INSERT INTO cat (name, color)
VALUES ('Alvin', 'Brown'),
       ('Casper', 'Gray'),
       ('Bella', 'Cream'),
       ('Dana', 'White'),
       ('Aron', 'Tortoiseshell');