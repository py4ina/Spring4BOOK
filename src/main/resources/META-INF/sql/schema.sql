use SPRING_4_BOOK;
CREATE TABLE if not exists contact (
  id INT NOT NULL  AUTO_INCREMENT,
  first_name VARCHAR(60) NOT NULL ,
  last_name VARCHAR (40) NOT NULL ,
  birth_date DATE ,
  version INT NOT NULL DEFAULT 0,
  UNIQUE uq_contact_1 (first_name, last_name),
  PRIMARY KEY (id)
);

CREATE TABLE if not exists hobby (
  hobby_id VARCHAR(20) NOT NULL
  , PRIMARY KEY (hobby_id)
);

CREATE TABLE if not exists contact_tel_detail (
  id INT NOT NULL AUTO_INCREMENT
, contact_id INT NOT NULL
, tel_type VARCHAR(20) NOT NULL
, tel_number VARCHAR(20) NOT NULL
, UNIQUE uq_contact_tel_detail_1 (contact_id, tel_type)
, PRIMARY KEY (id)
, CONSTRAINT fk_contact_tel_detail_1 FOREIGN KEY (contact_id)
  REFERENCES contact (id));

CREATE TABLE if not exists contact_hobby_detail (
  contact_id INT NOT NULL
  , hobby_id VARCHAR(20) NOT NULL
  , PRIMARY KEY (contact_id, hobby_id)
  , CONSTRAINT fk_contact_hobby_detail_1 FOREIGN KEY (contact_id)
    REFERENCES contact (id) ON DELETE CASCADE
  , CONSTRAINT fk_contact_hobby_detail_2 FOREIGN KEY (hobby_id)
  REFERENCES hobby (hobby_id)
);

CREATE TABLE if not exists  contact_audit (
  id                 INT         NOT NULL AUTO_INCREMENT,
  first_name         VARCHAR(60) NOT NULL,
  last_name          VARCHAR(40) NOT NULL,
  birth_date         DATE,
  version            INT         NOT NULL DEFAULT 0,

  created_by         VARCHAR(20),
  created_date       TIMESTAMP,
  last_modified_by   VARCHAR(20),
  last_modified_date TIMESTAMP NULL DEFAULT NULL,
  UNIQUE uq_contact_audit_1 (first_name, last_name),
  PRIMARY KEY (id)
);

CREATE TABLE if not exists  contact_audit_h (
  id                 INT         NOT NULL AUTO_INCREMENT,
  first_name         VARCHAR(60) NOT NULL,
  last_name          VARCHAR(40) NOT NULL,
  birth_date         DATE,
  version            INT         NOT NULL DEFAULT 0,

  created_by         VARCHAR(20),
  created_date       TIMESTAMP,
  last_modified_by   VARCHAR(20),
  last_modified_date TIMESTAMP NULL DEFAULT NULL,

  audit_revision      INT NOT NULL ,
  action_type         INT,
  audit_revision_end  INT,
  audit_revision_end_ts  TIMESTAMP  NULL,
  UNIQUE uq_contact_audit_1 (first_name, last_name),
  PRIMARY KEY (id, audit_revision)
);

CREATE TABLE if not exists  revinfo (
  revtstmp BIGINT NOT NULL,
  rev INT NOT NULL AUTO_INCREMENT,
  primary key (rev)
);

