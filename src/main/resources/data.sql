INSERT INTO types (id, name)
VALUES (1, 'Настольный компьютер');

INSERT INTO types (id, name)
VALUES (2, 'Ноутбук');

INSERT INTO types (id, name)
VALUES (3, 'Монитор');

INSERT INTO types (id, name)
VALUES (4, 'Жесткий диск');



INSERT INTO properties (id, name, type_id)
VALUES (1, 'Форм-фактор', 1);

INSERT INTO properties (id, name, type_id)
VALUES (2, 'Размер', 2);

INSERT INTO properties (id, name, type_id)
VALUES (3, 'Диагональ', 3);

INSERT INTO properties (id, name, type_id)
VALUES (4, 'Объем', 4);


INSERT INTO property_values (id, prop_value, property_id)
VALUES (1, 'Desktop', 1);

INSERT INTO property_values (id, prop_value, property_id)
VALUES (2, 'Nettop', 1);

INSERT INTO property_values (id, prop_value, property_id)
VALUES (3, 'Monoblock', 1);


INSERT INTO property_values (id, prop_value, property_id)
VALUES (4, '13', 2);

INSERT INTO property_values (id, prop_value, property_id)
VALUES (5, '14', 2);

INSERT INTO property_values (id, prop_value, property_id)
VALUES (6, '15', 2);

INSERT INTO property_values (id, prop_value, property_id)
VALUES (7, '17', 2);


INSERT INTO property_values (id, prop_value, property_id)
VALUES (8, '15', 3);

INSERT INTO property_values (id, prop_value, property_id)
VALUES (9, '20', 3);

INSERT INTO property_values (id, prop_value, property_id)
VALUES (10, '25', 3);


INSERT INTO property_values (id, prop_value, property_id)
VALUES (11, '120', 4);

INSERT INTO property_values (id, prop_value, property_id)
VALUES (12, '250', 4);

INSERT INTO property_values (id, prop_value, property_id)
VALUES (13, '500', 4);