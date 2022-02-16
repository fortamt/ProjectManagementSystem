CREATE TABLE  developers
(
	id SERIAL PRIMARY KEY,
	developer_name VARCHAR(30) NOT NULL,
	developer_age INT,
	developer_sex VARCHAR(1) NOT NULL
);

CREATE TABLE skills
(
	id SERIAL PRIMARY KEY,
	language VARCHAR(15) NOT NULL,
	skill_lvl VARCHAR(15) NOT NULL
);

CREATE TABLE projects
(
	id SERIAL PRIMARY KEY,
	project_name VARCHAR(30) NOT NULL,
	project_start_date DATE
);

CREATE TABLE companies
(
	id SERIAL PRIMARY KEY,
	company_name VARCHAR(30) NOT NULL,
	company_address VARCHAR(100) NOT NULL
);

CREATE TABLE customers
(
	id SERIAL PRIMARY KEY,
	customer_name VARCHAR(30) NOT NULL,
	customer_phone VARCHAR(20) NOT NULL
);

CREATE TABLE Developers_Projects_Relation
(
	developer_id INT NOT NULL,
	project_id INT NOT NULL,
	FOREIGN KEY (developer_id) REFERENCES developers (id),
	FOREIGN KEY (project_id) REFERENCES projects (id),
	UNIQUE (developer_id, project_id)
);

CREATE TABLE Developers_Skills_Relation
(
	developer_id INT NOT NULL,
	skill_id INT NOT NULL,
	FOREIGN KEY (developer_id) REFERENCES developers (id),
	FOREIGN KEY (skill_id) REFERENCES skills (id),
	UNIQUE (developer_id, skill_id)
);

CREATE TABLE Companies_Projects_Relation
(
	company_id INT NOT NULL,
	project_id INT NOT NULL,
	FOREIGN KEY (company_id) REFERENCES companies (id),
	FOREIGN KEY (project_id) REFERENCES projects (id),
	UNIQUE (company_id, project_id)
);

CREATE TABLE Customers_Projects_Relation
(
	customer_id INT NOT NULL,
	project_id INT NOT NULL,
	FOREIGN KEY (customer_id) REFERENCES customers (id),
	FOREIGN KEY (project_id) REFERENCES projects (id),
	UNIQUE (customer_id, project_id)
);

INSERT INTO developers (developer_name, developer_age, developer_sex) VALUES ('Artem', 25, 'M');
INSERT INTO developers (developer_name, developer_age, developer_sex) VALUES ('Andrey', 30, 'M');
INSERT INTO developers (developer_name, developer_age, developer_sex) VALUES ('Kirill', 35, 'M');
INSERT INTO developers (developer_name, developer_age, developer_sex) VALUES ('Misha', 29, 'M');
INSERT INTO developers (developer_name, developer_age, developer_sex) VALUES ('Gosha', 99, 'M');
INSERT INTO developers (developer_name, developer_age, developer_sex) VALUES ('Leha', 33, 'M');
INSERT INTO developers (developer_name, developer_age, developer_sex) VALUES ('Gena', 15, 'M');
INSERT INTO developers (developer_name, developer_age, developer_sex) VALUES ('Lemon', 26, 'M');
INSERT INTO developers (developer_name, developer_age, developer_sex) VALUES ('Lavrentiy', 30, 'M');
INSERT INTO developers (developer_name, developer_age, developer_sex) VALUES ('Biduin', 30, 'M');
INSERT INTO skills (language, skill_lvl) VALUES ('Java', 'Junior');
INSERT INTO skills (language, skill_lvl) VALUES ('Java', 'Middle');
INSERT INTO skills (language, skill_lvl) VALUES ('Java', 'Senior');
INSERT INTO skills (language, skill_lvl) VALUES ('C++', 'Junior');
INSERT INTO skills (language, skill_lvl) VALUES ('C++', 'Middle');
INSERT INTO skills (language, skill_lvl) VALUES ('C++', 'Senior');
INSERT INTO skills (language, skill_lvl) VALUES ('C#', 'Junior');
INSERT INTO skills (language, skill_lvl) VALUES ('C#', 'Middle');
INSERT INTO skills (language, skill_lvl) VALUES ('C#', 'Senior');
INSERT INTO skills (language, skill_lvl) VALUES ('JS', 'Junior');
INSERT INTO skills (language, skill_lvl) VALUES ('JS', 'Middle');
INSERT INTO skills (language, skill_lvl) VALUES ('JS', 'Senior');
INSERT INTO projects (project_name, project_start_date) VALUES ('Virus', '2004-02-04');
INSERT INTO projects (project_name, project_start_date) VALUES ('Puzzle history', '2005-05-18');
INSERT INTO projects (project_name, project_start_date) VALUES ('Chesee', '2006-01-06');
INSERT INTO projects (project_name, project_start_date) VALUES ('Textbroker', '2007-08-08');
INSERT INTO projects (project_name, project_start_date) VALUES ('Texterra', '2008-09-05');
INSERT INTO projects (project_name, project_start_date) VALUES ('Magictext', '2009-01-01');
INSERT INTO projects (project_name, project_start_date) VALUES ('World money', '2010-02-25');
INSERT INTO projects (project_name, project_start_date) VALUES ('Dogsearcher', '2011-09-11');
INSERT INTO projects (project_name, project_start_date) VALUES ('Catkiller', '2012-11-02');
INSERT INTO companies (company_name, company_address) VALUES ('Facebook', '1 Hacker Way Menlo Park, CA 94025');
INSERT INTO companies (company_name, company_address) VALUES ('Google', '1101 New York Avenue, N.W.');
INSERT INTO companies (company_name, company_address) VALUES ('Amazon', '440 Terry Avenue North Seattle, WA 98109 USA');
INSERT INTO customers (customer_name, customer_phone) VALUES ('Volodymyr Zelenskyi', '+380502392762');
INSERT INTO customers (customer_name, customer_phone) VALUES ('Volodymyr Putin', '84956253581');
INSERT INTO customers (customer_name, customer_phone) VALUES ('Joseph Biden', '202-456-2121');
INSERT INTO developers_projects_relation VALUES (1, 2);
INSERT INTO developers_projects_relation VALUES (2, 3);
INSERT INTO developers_projects_relation VALUES (2, 4);
INSERT INTO developers_projects_relation VALUES (3, 5);
INSERT INTO developers_projects_relation VALUES (3, 6);
INSERT INTO developers_projects_relation VALUES (4, 7);
INSERT INTO developers_projects_relation VALUES (4, 8);
INSERT INTO developers_projects_relation VALUES (5, 9);
INSERT INTO developers_projects_relation VALUES (6, 1);
INSERT INTO developers_projects_relation VALUES (6, 2);
INSERT INTO developers_projects_relation VALUES (7, 3);
INSERT INTO developers_projects_relation VALUES (7, 4);
INSERT INTO developers_projects_relation VALUES (8, 5);
INSERT INTO developers_projects_relation VALUES (8, 6);
INSERT INTO developers_projects_relation VALUES (9, 7);
INSERT INTO developers_projects_relation VALUES (9, 8);
INSERT INTO developers_projects_relation VALUES (10, 9);
INSERT INTO developers_skills_relation VALUES(1,1);
INSERT INTO developers_skills_relation VALUES(1,4);
INSERT INTO developers_skills_relation VALUES(2,2);
INSERT INTO developers_skills_relation VALUES(2,5);
INSERT INTO developers_skills_relation VALUES(3,3);
INSERT INTO developers_skills_relation VALUES(3,6);

ALTER TABLE developers
ADD COLUMN salary INT;

UPDATE developers SET salary = 2400 WHERE id = 1;
UPDATE developers SET salary = 2800 WHERE id = 2;
UPDATE developers SET salary = 7500 WHERE id = 3;
UPDATE developers SET salary = 6500 WHERE id = 4;
UPDATE developers SET salary = 9800 WHERE id = 5;
UPDATE developers SET salary = 3100 WHERE id = 6;
UPDATE developers SET salary = 4600 WHERE id = 7;
UPDATE developers SET salary = 6300 WHERE id = 8;
UPDATE developers SET salary = 2900 WHERE id = 9;
UPDATE developers SET salary = 900 WHERE id = 10;

ALTER TABLE projects
ADD COLUMN cost INT;
UPDATE projects p1
SET cost = (SELECT SUM(d.salary) FROM projects p2
			JOIN developers_projects_relation dpl ON p2.id = dpl.project_id
			JOIN developers d ON d.id = dpl.developer_id
WHERE p1.id = p2.id);















