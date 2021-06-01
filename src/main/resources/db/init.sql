use portfolio;

SET foreign_key_checks = 0;

DELETE
FROM portfolio.User
WHERE id <> 0;
ALTER TABLE portfolio.User
    AUTO_INCREMENT = 1;

INSERT INTO User(dateOfBirth, email, name, password, surname)
VALUES ('1999-06-08', 'dima@mail.ru', 'Dzmitry', '12345', 'Hrabar'),
       ('2003-08-29', 'sasha@mail.ru', 'Sasha', '54321', 'Hrabar'),
       ('2007-03-27', 'olya@mail.ru', 'Olha', '123', 'Hrabar');

DELETE
FROM portfolio.ProductCategory
WHERE id <> 0;
ALTER TABLE portfolio.ProductCategory
    AUTO_INCREMENT = 1;

INSERT INTO ProductCategory(title)
VALUES ('Music'),
       ('Video'),
       ('Game');

DELETE
FROM portfolio.Product
WHERE id <> 0;
ALTER TABLE portfolio.Product
    AUTO_INCREMENT = 1;

INSERT INTO Product(description, title, cartId, productCategoryId)
VALUES ('first product', 'song', null, 1),
       ('second product', 'nature', null, 2),
       ('third product', 'snake', null, 3);