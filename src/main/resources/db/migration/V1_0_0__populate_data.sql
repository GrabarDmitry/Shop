use portfolio;

SET foreign_key_checks = 0;

DELETE FROM portfolio.User WHERE id <> 0;
ALTER TABLE portfolio.User AUTO_INCREMENT = 1;

INSERT INTO User(dateOfBirth, email, name, password, surname)
VALUES ('08.06.1999', 'dima@mail.ru','Dzmitry','12345','Hrabar'),
       ('29.08.2003', 'sasha@mail.ru','Sasha','54321','Hrabar'),
       ('27.03.2007','olya@mail.ru','Olha','123','Hrabar')
