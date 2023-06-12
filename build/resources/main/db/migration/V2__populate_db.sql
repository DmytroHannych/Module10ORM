INSERT INTO client (name) VALUES
   ('Igor'),
   ('Alex'),
   ('Bruno'),
   ('Fill'),
   ('Alex2'),
   ('Petro'),
   ('Ivan'),
   ('Dmytro'),
   ('Ruslan'),
   ('Pavel');

INSERT INTO planet (id, name) VALUES
        ('MERCURY','MERCURY'),
          ('VENUS','VENUS'),
          ('EARTH','EARTH'),
          ('MARS','MARS'),
          ('JUPITER','JUPITER');

   INSERT INTO ticket (created_at, client_id,from_planet_id,to_planet_id) VALUES
   ('2022-05-10',1,'VENUS','MARS'),
   ('2021-05-18',2,'EARTH','MERCURY'),
   ('2018-10-15',3,'MARS','MERCURY'),
   ('2020-01-18',4,'JUPITER','MERCURY'),
   ('2021-02-14',5,'MERCURY','VENUS'),
   ('2022-12-25',6,'VENUS','EARTH'),
   ('2023-10-20',7,'MARS','EARTH'),
   ('2020-08-15',8,'JUPITER','EARTH'),
   ('2019-09-05',9,'EARTH','JUPITER'),
   ('2021-07-01',10,'EARTH','JUPITER');

