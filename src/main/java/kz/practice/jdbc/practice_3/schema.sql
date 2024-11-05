CREATE TABLE books
(
    id        SERIAL PRIMARY KEY,
    title     VARCHAR(100),
    author    VARCHAR(100),
    year      INT,
    available BOOLEAN
);

CREATE TABLE readers
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(50),
    email VARCHAR(50)
);

CREATE TABLE loans
(
    id          SERIAL PRIMARY KEY,
    book_id     INT REFERENCES books (id),
    reader_id   INT REFERENCES readers (id),
    loan_date   DATE,
    return_date DATE
);