USE SPRING_4_BOOK;

INSERT INTO CONTACT (first_name, last_name, birth_date) VALUES
  ('Chris', 'Schaefer', '1981-05-03');
INSERT INTO CONTACT (first_name, last_name, birth_date) VALUES
  ('Scott', 'Tiger', '1990-11-02');
INSERT INTO CONTACT (first_name, last_name, birth_date) VALUES
  ('John', 'Smith', '1964-02-28');

INSERT INTO CONTACT_TEL_DETAIL (contact_id, tel_type, tel_number) VALUES
  (1, 'Mobile', '1234567890');
INSERT INTO CONTACT_TEL_DETAIL (contact_id, tel_type, tel_number) VALUES
  (1, 'Home', '1234567890');
INSERT INTO CONTACT_TEL_DETAIL (contact_id, tel_type, tel_number) VALUES
  (2, 'Home', '1234567890');

INSERT INTO HOBBY (hobby_id) VALUES ('Swimming');
INSERT INTO HOBBY (hobby_id) VALUES ('Jogging');
INSERT INTO HOBBY (hobby_id) VALUES ('Programming');
INSERT INTO HOBBY (hobby_id) VALUES ('Movies');
INSERT INTO HOBBY (hobby_id) VALUES ('Reading');

INSERT INTO CONTACT_HOBBY_DETAIL (contact_id, hobby_id) VALUES (1, 'Swimming');
INSERT INTO CONTACT_HOBBY_DETAIL (contact_id, hobby_id) VALUES (1, 'Movies');
INSERT INTO CONTACT_HOBBY_DETAIL (contact_id, hobby_id) VALUES (2, 'Swimming');
