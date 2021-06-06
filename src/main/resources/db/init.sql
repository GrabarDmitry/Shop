use portfolio;

SET foreign_key_checks = 0;

DELETE
FROM portfolio.role
WHERE id <> 0;
ALTER TABLE portfolio.role
    AUTO_INCREMENT = 1;

INSERT INTO role(title)
VALUES ('ADMIN'),
       ('USER');

DELETE
FROM portfolio.User
WHERE id <> 0;
ALTER TABLE portfolio.User
    AUTO_INCREMENT = 1;

INSERT INTO User(dateOfBirth, email, name, password, surname, roleId)
VALUES ('1999-06-08', 'dima@mail.ru', 'Dzmitry', '$2y$12$quuqPBHIonyg9rs1nhxwe.bSNC5YXgk1KCOBTg3rASl.SfuIzUgCu',
        'Hrabar', 1),
       ('2003-08-29', 'sasha@mail.ru', 'Sasha', '$2y$12$quuqPBHIonyg9rs1nhxwe.bSNC5YXgk1KCOBTg3rASl.SfuIzUgCu',
        'Hrabar', 2),
       ('2007-03-27', 'olya@mail.ru', 'Olha', '$2y$12$quuqPBHIonyg9rs1nhxwe.bSNC5YXgk1KCOBTg3rASl.SfuIzUgCu', 'Hrabar',
        2);

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

INSERT INTO Product(description, title, cartId, productCategoryId, productImageId)
VALUES ('first product', 'song', null, 1, 1),
       ('second product', 'nature', null, 2, 2),
       ('third product', 'snake', null, 3, 2);

DELETE
FROM portfolio.productimage
WHERE id <> 0;
ALTER TABLE portfolio.productimage
    AUTO_INCREMENT = 1;

INSERT INTO productimage(path)
VALUES ('default'),
       ('first'),
       ('second')


