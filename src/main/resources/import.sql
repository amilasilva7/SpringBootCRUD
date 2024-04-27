INSERT INTO continent (id, continent, area, pop) VALUES (1, "Europe", 10530000, "746m");
INSERT INTO continent (id, continent, area, pop) VALUES (2, "Asia", 44580000 , "4.561b");
INSERT INTO continent (id, continent, area, pop) VALUES (3, "North America", 24710000 , "579m");

INSERT INTO country (id, country, continent_fk, head_of_state) VALUES (100, "Ireland", 1, "President Michael D. Higgins");
INSERT INTO country (id, country, continent_fk, head_of_state) VALUES (101, "France", 1, "President Emmanuel Macron");
INSERT INTO country (id, country, continent_fk, head_of_state) VALUES (102, "Germany", 1, "President Frank-Walter Steinmeier");
INSERT INTO country (id, country, continent_fk, head_of_state) VALUES (103, "Japan", 2, "Emperor Naruhito");
INSERT INTO country (id, country, continent_fk, head_of_state) VALUES (104, "China", 2, "President Xi Jinping");
INSERT INTO country (id, country, continent_fk, head_of_state) VALUES (105, "North Korea", 2, "President Kim Jong Un");
INSERT INTO country (id, country, continent_fk, head_of_state) VALUES (106, "India", 2, "President Droupadi Murmu");
INSERT INTO country (id, country, continent_fk, head_of_state) VALUES (107, "United States of America", 3, "President Joe Biden");
INSERT INTO country (id, country, continent_fk, head_of_state) VALUES (108, "Canada", 3, "King Charles III");

INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (200, "Dublin", 1, 100, 544107);
INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (201, "Cork", 0, 100, 124391);
INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (202, "Galway", 0, 100, 79934);
INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (203, "Paris", 1, 101, 2161000);
INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (204, "Toulouse", 0, 101, 471941);
INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (205, "Bonn", 0, 102, 327258);
INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (206, "Frankfurt", 0, 102, 753056);
INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (207, "Tokyo", 1, 103, 13960000);
INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (208, "Kyoto", 0, 102, 1475000);
INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (209, "Washington D.C", 1, 107, 712816);
INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (210, "Boston", 0, 107, 654776);
INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (211, "Los Angeles", 0, 107, 3849000);
INSERT INTO city (id, city, is_capital, country_fk, population) VALUES (212, "Dallas", 0, 107, 1288000);

