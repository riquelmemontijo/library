-------------------------------------- DATA OF GENRES ----------------------------------------------

INSERT INTO GENRE(id, name) VALUES('c2db861f-366b-4793-a7ad-6acd0729e13a', 'Drama');
INSERT INTO GENRE(id, name) VALUES('e6b30090-c63e-4c92-9f5f-8e0d3883d3e6', 'Fantasia');
INSERT INTO GENRE(id, name) VALUES('fe2992c4-a2cc-468e-85b1-fc986c7eac6e', 'Romance');
INSERT INTO GENRE(id, name) VALUES('6e728dd9-1f03-49ef-be91-85af85f0b68d', 'Terror');
INSERT INTO GENRE(id, name) VALUES('3243eebf-94ad-448f-9060-89ed2ea3b069', 'Comédia');
INSERT INTO GENRE(id, name) VALUES('fa07dae6-e64d-4aa2-aba5-cfa16ac2260f', 'Suspense');
INSERT INTO GENRE(id, name) VALUES('d34eaabb-21e1-4d30-a1a1-22e8d12345d9', 'Comédia-Romântica');
INSERT INTO GENRE(id, name) VALUES('3089df01-1f61-45e1-8e80-0b178215be93', 'Ficção Científica');
INSERT INTO GENRE(id, name) VALUES('ef0068a6-1166-4ffe-9497-a259d2dca843', 'Biografia');
INSERT INTO GENRE(id, name) VALUES('02692ec9-d624-4b48-b7f8-4be5ee695bc1', 'Didático');
INSERT INTO GENRE(id, name) VALUES('154296c9-ad94-4c13-b33a-264dcf2d19ab', 'História');
INSERT INTO GENRE(id, name) VALUES('8a53c5a3-f2bc-4ce3-81fa-b903af23b096', 'Filosofia');
INSERT INTO GENRE(id, name) VALUES('60c941b6-a55b-4f9b-88a7-ae6256745244', 'Sociologia');
INSERT INTO GENRE(id, name) VALUES('7ed5b51f-cbf0-4e85-b9f6-cf037b6597ce', 'Matemática');
INSERT INTO GENRE(id, name) VALUES('76707d29-04c2-4d4f-9976-6659d53b01e8', 'Português');
INSERT INTO GENRE(id, name) VALUES('39710937-0339-4c40-94ef-438efd51ef2a', 'Língua Estrangeira');
INSERT INTO GENRE(id, name) VALUES('56614631-6723-4651-b7ba-0251d9cd348b', 'Infantil');
INSERT INTO GENRE(id, name) VALUES('9ffde590-e62d-4899-a95b-67242bcd759c', 'Religioso');
INSERT INTO GENRE(id, name) VALUES('44cb4a17-6526-4d78-bf03-323703dfe9d4', 'Teologia');

--------------------------------------- DATA OF AUTHORS ---------------------------------------------

INSERT INTO AUTHOR(id, name) VALUES('3c3f1f46-4f1f-49d9-984c-d61ad1d6e074', 'J.R.R. Tolkien');
INSERT INTO AUTHOR(id, name) VALUES('773b5f87-63d8-4af4-8e42-db7518a8edf6', 'C.S. Lewis');
INSERT INTO AUTHOR(id, name) VALUES('150bca82-d9c9-4093-b290-0221e7adfb87', 'Aristóteles');
INSERT INTO AUTHOR(id, name) VALUES('3509efa2-119c-4f7b-8269-072585a62ba7', 'Platão');
INSERT INTO AUTHOR(id, name) VALUES('513380f1-bdf5-471a-b9a5-0b786ef52bc2', 'Monteiro Lobato');
INSERT INTO AUTHOR(id, name) VALUES('6531bf12-da59-4914-bc9c-43129222b279', 'Giovanni Reale');
INSERT INTO AUTHOR(id, name) VALUES('5ffa9999-d819-47b7-8010-de52f9cd69ca', 'Mario Ferreira dos Santos');
INSERT INTO AUTHOR(id, name) VALUES('49271974-971b-41c7-b406-b66cb9b8858f', 'Olavo de Carvalho');
INSERT INTO AUTHOR(id, name) VALUES('63e4cb8e-8934-4126-9305-4e1775b700ba', 'Arquimedes');
INSERT INTO AUTHOR(id, name) VALUES('5b1669de-3ecc-4585-a9c7-138f7576e647', 'Napoleão Mendes de Almeira');
INSERT INTO AUTHOR(id, name) VALUES('53a53f3b-1a6d-4d8c-9eb7-f9a50c6a0176', 'Daniel Rops');
INSERT INTO AUTHOR(id, name) VALUES('4b204302-ed48-4616-85d3-3de0ad8627dd', 'Arthur Conan Doyle');
INSERT INTO AUTHOR(id, name) VALUES('c3c8c50d-259d-4511-8f95-2e55ba8356c2', 'Ortega y Gasset');
INSERT INTO AUTHOR(id, name) VALUES('56b6ee59-9076-40eb-bd37-7c7a1719b28d', 'A. D. Sertillanges');
INSERT INTO AUTHOR(id, name) VALUES('a3e0d5b0-908b-45a4-93bf-111a7279466a', 'Tomás de Aquino');
INSERT INTO AUTHOR(id, name) VALUES('116a458f-29a5-4722-b995-d9387ea46f0b', 'Santo Afonso de Ligório');
INSERT INTO AUTHOR(id, name) VALUES('9cdc3293-cca3-45fd-8d3e-bba6e986cb34', 'Irmãos Grimm');

---------------------------------------- DATA OF HALLS ----------------------------------------------

INSERT INTO HALL(id, alias) VALUES('46e716bf-926f-4340-b818-2a788ed6dda8', 'HALL A');
INSERT INTO HALL(id, alias) VALUES('dab1fec9-e377-491f-a563-bbcb4ae45c71', 'HALL B');
INSERT INTO HALL(id, alias) VALUES('c190c873-c7a9-4418-a030-9a9a82da5779', 'HALL C');
INSERT INTO HALL(id, alias) VALUES('3e48ba35-ec8f-48be-9efe-d56f36180a8e', 'HALL D');
INSERT INTO HALL(id, alias) VALUES('432db29c-6fe7-411a-9295-50fc5f590e6a', 'HALL E');

--------------------------------------- DATA OF BOOKCASE --------------------------------------------

-- HALL A
INSERT INTO BOOKCASE(id, alias, fk_hall) VALUES('b41e7cf2-08e3-445d-9572-afd3112c0f7b', 'BOOKCASE 1', '46e716bf-926f-4340-b818-2a788ed6dda8');
INSERT INTO BOOKCASE(id, alias, fk_hall) VALUES('f9a20762-6d20-4471-946b-90a26ca0b30a', 'BOOKCASE 2', '46e716bf-926f-4340-b818-2a788ed6dda8');

-- HALL B
INSERT INTO BOOKCASE(id, alias, fk_hall) VALUES('96b19ccc-0d09-4cdb-9b30-2cacb3a94726', 'BOOKCASE 1', 'dab1fec9-e377-491f-a563-bbcb4ae45c71');
INSERT INTO BOOKCASE(id, alias, fk_hall) VALUES('6a8381a9-9acf-4b6c-8192-5d7532b32fd5', 'BOOKCASE 2', 'dab1fec9-e377-491f-a563-bbcb4ae45c71');

-- HALL C
INSERT INTO BOOKCASE(id, alias, fk_hall) VALUES('8ce81f89-6ca9-4e3b-a8b3-ae725e33ad18', 'BOOKCASE 1', 'c190c873-c7a9-4418-a030-9a9a82da5779');
INSERT INTO BOOKCASE(id, alias, fk_hall) VALUES('d0d68eb2-1383-46a7-b893-88b4f886819d', 'BOOKCASE 2', 'c190c873-c7a9-4418-a030-9a9a82da5779');

-- HALL D
INSERT INTO BOOKCASE(id, alias, fk_hall) VALUES('6eb25cd7-46e8-4392-a4bd-60b5e997686d', 'BOOKCASE 1', '3e48ba35-ec8f-48be-9efe-d56f36180a8e');
INSERT INTO BOOKCASE(id, alias, fk_hall) VALUES('7a6729ba-b975-4472-8ff4-85edb8a8dc86', 'BOOKCASE 2', '3e48ba35-ec8f-48be-9efe-d56f36180a8e');

-- HALL E
INSERT INTO BOOKCASE(id, alias, fk_hall) VALUES('00b4fa35-5df7-433d-8f5b-62267f599450', 'BOOKCASE 1', '432db29c-6fe7-411a-9295-50fc5f590e6a');
INSERT INTO BOOKCASE(id, alias, fk_hall) VALUES('b2ea762d-e81f-4a92-8822-ba5692088abb', 'BOOKCASE 2', '432db29c-6fe7-411a-9295-50fc5f590e6a');

--------------------------------------- DATA OF BOOK --------------------------------------------
-- SILMARILLION
INSERT INTO BOOK(id, title, units, available_units) VALUES('5ec2a2ef-363c-4d97-91b9-4ff3aec796ab', 'Silmarillion', 10, 10);
INSERT INTO BOOK_GENRES(id_book, id_genre) VALUES('5ec2a2ef-363c-4d97-91b9-4ff3aec796ab', 'e6b30090-c63e-4c92-9f5f-8e0d3883d3e6');
INSERT INTO BOOKCASE_BOOKS(id_book, id_bookcase) VALUES('5ec2a2ef-363c-4d97-91b9-4ff3aec796ab','b41e7cf2-08e3-445d-9572-afd3112c0f7b');
INSERT INTO AUTHOR_BOOKS(id_book, id_author) VALUES('5ec2a2ef-363c-4d97-91b9-4ff3aec796ab','3c3f1f46-4f1f-49d9-984c-d61ad1d6e074');

-- O SABER DOS ANTIGOS
INSERT INTO BOOK(id, title, units, available_units) VALUES('d3a93493-e561-42a6-81b2-412cec083258', 'O Saber dos Antigos', 7, 7);
INSERT INTO BOOK_GENRES(id_book, id_genre) VALUES('d3a93493-e561-42a6-81b2-412cec083258', '8a53c5a3-f2bc-4ce3-81fa-b903af23b096');
INSERT INTO BOOKCASE_BOOKS(id_book, id_bookcase) VALUES('d3a93493-e561-42a6-81b2-412cec083258','f9a20762-6d20-4471-946b-90a26ca0b30a');
INSERT INTO AUTHOR_BOOKS(id_book, id_author) VALUES('d3a93493-e561-42a6-81b2-412cec083258','6531bf12-da59-4914-bc9c-43129222b279');

-- SUMA TEOLÓGICA
INSERT INTO BOOK(id, title, units, available_units) VALUES('0cd9bfb7-70ce-49ee-9fa6-7dfbbb8c990f', 'Suma Teológica I', 14, 14);
INSERT INTO BOOK_GENRES(id_book, id_genre) VALUES('0cd9bfb7-70ce-49ee-9fa6-7dfbbb8c990f','44cb4a17-6526-4d78-bf03-323703dfe9d4');
INSERT INTO BOOK_GENRES(id_book, id_genre) VALUES('0cd9bfb7-70ce-49ee-9fa6-7dfbbb8c990f','9ffde590-e62d-4899-a95b-67242bcd759c');
INSERT INTO BOOK_GENRES(id_book, id_genre) VALUES('0cd9bfb7-70ce-49ee-9fa6-7dfbbb8c990f','8a53c5a3-f2bc-4ce3-81fa-b903af23b096');
INSERT INTO BOOKCASE_BOOKS(id_book, id_bookcase) VALUES('0cd9bfb7-70ce-49ee-9fa6-7dfbbb8c990f', '96b19ccc-0d09-4cdb-9b30-2cacb3a94726');
INSERT INTO AUTHOR_BOOKS(id_book, id_author) VALUES('0cd9bfb7-70ce-49ee-9fa6-7dfbbb8c990f','a3e0d5b0-908b-45a4-93bf-111a7279466a');

--------------------------------------- DATA OF STUDENT -----------------------------------------

INSERT INTO STUDENT(id, name, date_of_birth, email, phone_number) VALUES('733d4957-99b5-4b3d-a387-fd895ea610d6', 'José Carlos Mariano', '2020-10-11', 'jose.mariano@email.com', '(11)11111-1111');
INSERT INTO STUDENT(id, name, date_of_birth, email, phone_number) VALUES('ad708577-66d4-476c-a7d2-03b32ae86b1f', 'Mariana Augusta Ferreira', '2005-10-01', 'mariana.ferreira@email.com', '(22)22222-2222');
INSERT INTO STUDENT(id, name, date_of_birth, email, phone_number) VALUES('931996d0-e60d-4a55-8ea6-1551d90470c1', 'Cecília Ferreira Almeida', '2000-04-20', 'cecilia.almeida', '(33)33333-3333');
INSERT INTO STUDENT(id, name, date_of_birth, email, phone_number) VALUES('b2a2f58d-dce6-4876-bf1c-c53fdc94e49f', 'Heloísa Marconi dos Santos', '1998-03-03', 'heloisa.santos', '(44)44444-4444');