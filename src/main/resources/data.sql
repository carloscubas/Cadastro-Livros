INSERT INTO USER (username, password) VALUES ('admin','$2a$10$AEXR8rqsVjUNZVNrbci8g.5cAUEIWy6xkAS42dBcSkT08l0qenpfS');
INSERT INTO USER (username, password) VALUES ('teste','$2a$10$0tj2U9QgTprZrdd3hpypeeknvH6JObL2Gc0EAoR90aCdLgl..ZvjS');

INSERT INTO ROLE (ID, ROLE) VALUES (1, 'ROLE_BASIC');
INSERT INTO ROLE (ID, ROLE) VALUES (2, 'ROLE_ADMIN');

INSERT INTO USER_ROLES (USER_USERNAME, ROLES_ID) VALUES ('admin', 1);
INSERT INTO USER_ROLES (USER_USERNAME, ROLES_ID) VALUES ('admin', 2);
INSERT INTO USER_ROLES (USER_USERNAME, ROLES_ID) VALUES ('teste', 1);

INSERT INTO  LIVRO ( ID, NOME, QUANTIDADE_PAGINAS ) VALUES ( 1,' Use a cabeça Java',300 );
INSERT INTO  LIVRO ( ID, NOME, QUANTIDADE_PAGINAS ) VALUES ( 2,' Java como programar',500 );
INSERT INTO  LIVRO ( ID, NOME, QUANTIDADE_PAGINAS ) VALUES ( 3,' Spring boot',200 );

INSERT INTO AUTOR (ID, NOME) VALUES (1, 'Manoel Bandeira');
INSERT INTO AUTOR (ID, NOME) VALUES (2, 'Gracilianos Ramos');

