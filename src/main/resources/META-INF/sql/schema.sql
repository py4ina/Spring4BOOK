CREATE TABLE CONTACT (
  id INT NOT NULL  AUTO_INCREMENT,
  first_name VARCHAR(60) NOT NULL ,
  last_name VARCHAR (40) NOT NULL ,
  birth_date DATE ,
  UNIQUE UQ_CONTACT_1 (first_name, last_name),
  PRIMARY KEY (id)
);

CREATE TABLE HOBBY (
  hobby_id VARCHAR(20) NOT NULL
  , PRIMARY KEY (hobby_id)
);

CREATE TABLE CONTACT_TEL_DETAIL (
  id INT NOT NULL AUTO_INCREMENT
, contact_id INT NOT NULL
, tel_type VARCHAR(20) NOT NULL
, tel_number VARCHAR(20) NOT NULL
, UNIQUE UQ_CONTACT_TEL_DETAIL_1 (contact_id, tel_type)
, PRIMARY KEY (id)
, CONSTRAINT FK_CONTACT_TEL_DETAIL_l FOREIGN KEY (contact_id)
  REFERENCES CONTACT (id));

CREATE TABLE CONTACT_HOBBY_DETAIL (
  contact_id INT NOT NULL
  , hobby_id VARCHAR(20) NOT NULL
  , PRIMARY KEY (contact_id, hobby_id)
  , CONSTRAINT fk_contact_hobby_detail_1 FOREIGN KEY (contact_id)
    REFERENCES CONTACT (id) ON DELETE CASCADE
  , CONSTRAINT fk_contact_hobby_detail_2 FOREIGN KEY (hobby_id)
  REFERENCES HOBBY (hobby_id)
);

