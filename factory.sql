CREATE TABLE factory(
    id SERIAL PRIMARY KEY,
	full_name VARCHAR(100) NOT NULL,
	short_name VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	workers_amount SMALLINT NOT NULL
);

CREATE TABLE production(
    id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	code VARCHAR(50) NOT NULL,
	volume SMALLINT NOT NULL,
	created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP
);


CREATE TABLE batch(
    id SERIAL PRIMARY KEY,
	batch_number INTEGER NOT NULL,
	batch_value SMALLINT NOT NULL,
	batch_date TIMESTAMP NOT NULL,
	production_id INT NOT NULL references production(id),
	factory_id INT NOT NULL references factory(id)
)

INSERT INTO production (name, code, volume)
			VALUES ('Кокур десертный Сурож','1945',700);
INSERT INTO production (name, code, volume)
			VALUES ('Портвейн белый Сурож','1936',700);
INSERT INTO production (name, code, volume)
			VALUES ('Мускат «Царица Феодора»','1945',700);
INSERT INTO production (name, code, volume)
			VALUES ('Бастардо десертное Алушта','2003',700);
INSERT INTO production (name, code, volume)
			VALUES ('Мускатель Массандра белый','2006',700);
INSERT INTO production (name, code, volume)
			VALUES ('Кагор Партенит','1998',700);


INSERT INTO factory (full_name, short_name, city, workers_amount)
			VALUES ('Государственное предприятие "Судак"','ГП"Судак"','Судак',1000);
INSERT INTO factory (full_name, short_name, city, workers_amount)
			VALUES ('Государственное предприятие "Алушта"','ГП"Алушта"','Алушта',1500);
INSERT INTO factory (full_name, short_name, city, workers_amount)
			VALUES ('Государственное предприятие "Приветное"','ГП"Приветное"','Приветное',2000);
INSERT INTO factory (full_name, short_name, city, workers_amount)
			VALUES ('Государственное предприятие "Таврида"','ГП"Таврида"','Кипарисное',1000)


INSERT INTO batch (batch_number,batch_value,batch_date,production_id, factory_id)
            VALUES(11111, 1000, Timestamp '2020-12-07  12:30', 1,2 );
INSERT INTO batch (batch_number,batch_value,batch_date,production_id, factory_id)
            VALUES(22222, 1500, Timestamp '2020-11-07 15:00', 3,4 );
INSERT INTO batch (batch_number,batch_value,batch_date,production_id, factory_id)
            VALUES(33333, 2000, Timestamp '2020-10-07 19:00', 2,1 );
INSERT INTO batch (batch_number,batch_value,batch_date,production_id, factory_id)
            VALUES(44444, 2500, Timestamp '2020-09-07 21:00', 3,3 );
