CREATE TABLE settings (	
	id SERIAL PRIMARY KEY,
	category VARCHAR(50) NULL,
	name VARCHAR(50) NOT NULL,
	value VARCHAR(5000) NOT NULL
);
