use portfolio;

DELETE
FROM portfolio.User
WHERE id <> 0;

INSERT INTO User(dateOfBirth, email, name, password, surname)
VALUES ('1999-06-08', 'dima@mail.ru', 'Dzmitry', '12345', 'Hrabar'),
       ('2003-08-29', 'sasha@mail.ru', 'Sasha', '54321', 'Hrabar'),
       ('2007-03-27', 'olya@mail.ru', 'Olha', '123', 'Hrabar')
