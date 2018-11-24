CREATE TABLE account(
id_account SERIAL NOT NULL,
username VARCHAR,
passwd_hash VARCHAR,
salt VARCHAR,
name VARCHAR,
surname VARCHAR,
email VARCHAR,
role VARCHAR,
PRIMARY KEY (id_account));

CREATE TABLE quest(
id_quest SERIAL NOT NULL,
name VARCHAR,
description VARCHAR,
amount FLOAT,
quest_type INTEGER,
PRIMARY KEY (id_quest));

CREATE TABLE class(
id_class SERIAL NOT NULL,
name VARCHAR,
PRIMARY KEY (id_class));

CREATE TABLE teacher(
id_teacher SERIAL NOT NULL,
id_account SERIAL REFERENCES account(id_account),
PRIMARY KEY (id_teacher));

CREATE TABLE sessions(
id_session SERIAL NOT NULL,
session_id VARCHAR,
id_account SERIAL REFERENCES account(id_account),
expiration_date DATE,
PRIMARY KEY (id_session));


CREATE TABLE student(
id_student SERIAL NOT NULL,
id_account SERIAL REFERENCES account(id_account),
id_class SERIAL REFERENCES class(id_class),
PRIMARY KEY (id_student));

CREATE TABLE done_quests(
id_done_quest SERIAL NOT NULL,
id_quest SERIAL REFERENCES quest(id_quest),
id_student SERIAL REFERENCES student(id_student),
is_complete BOOLEAN,
PRIMARY KEY (id_done_quest));

CREATE TABLE team(
id_student_group SERIAL NOT NULL,
name VARCHAR,
id_quest SERIAL REFERENCES quest(id_quest),
PRIMARY KEY (id_student_group));

CREATE TABLE team_member(
id_team_member SERIAL NOT NULL,
id_student SERIAL REFERENCES student(id_student),
PRIMARY KEY (id_team_member));

CREATE TABLE reward(
id_reward SERIAL NOT NULL,
name VARCHAR,
description VARCHAR,
prince FLOAT,
PRIMARY KEY (id_reward));

CREATE TABLE student_reward(
id_student_reward SERIAL NOT NULL,
id_student SERIAL REFERENCES student(id_student),
id_reward SERIAL REFERENCES reward(id_reward),
PRIMARY KEY (id_student_reward));

