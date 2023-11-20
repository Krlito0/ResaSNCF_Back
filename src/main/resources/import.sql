
-- Role :

INSERT INTO role (type) VALUES ('ADMIN');
INSERT INTO role (type) VALUES ('MODERATOR');
INSERT INTO role (type) VALUES ('USER');

-- Maintenance :

INSERT INTO maintenance_type (type, duration_hours, cost) VALUES ('Pas de maintenance', 0, 0);
INSERT INTO maintenance_type (type, duration_hours, cost) VALUES ('Nettoyage véhicule', 4, 200);
INSERT INTO maintenance_type (type, duration_hours, cost) VALUES ('Maintenance préventive', 120, 1000);
INSERT INTO maintenance_type (type, duration_hours, cost) VALUES ('Réparation', 240, 4000);

-- FuelCard :

INSERT INTO fuel_card (card_number,type) VALUES ("S1N2C3F4TOTAL","Diesel");
INSERT INTO fuel_card (card_number,type) VALUES ("S9N8C7F6TOTAL","Essence");
INSERT INTO fuel_card (card_number,type) VALUES ("S0N0C0F7TOTAL","Electrique");
INSERT INTO fuel_card (card_number,type) VALUES ("S7N7C7F7TOTAL","Diesel");
INSERT INTO fuel_card (card_number,type) VALUES ("S9N9C9F9TOTAL","Essence");
INSERT INTO fuel_card (card_number,type) VALUES ("S4N4C4F4TOTAL","Electrique");
INSERT INTO fuel_card (card_number,type) VALUES ("S1N1C1F1TOTAL","Electrique");

-- Car :

INSERT INTO car (immat, type, brand, picture, model, available, kilometers, state, fuel, price_day, fuel_card_id) VALUES ('AB-123-CD', 'Citadine', 'Renault', 'https://live.staticflickr.com/4437/36946177735_dcba840a56_b.jpg', 'Clio', true, 5000, 'Neuve', 'Diesel', 35, 1);
INSERT INTO car (immat, type, brand, picture, model, available, kilometers, state, fuel, price_day, fuel_card_id) VALUES ('AZ-123-QS', 'Citadine', 'Peugeot', 'https://2.bp.blogspot.com/-HQTdCW55Gr0/W-E_8bVhJWI/AAAAAAABT4U/g8rzwV8agewf431KxiDWFfeQXc6hx2CdACLcBGAs/w1200-h630-p-k-no-nu/GF_1812.jpg', '308', true, 5000, 'Neuve', 'Essence', 38, 2);
INSERT INTO car (immat, type, brand, picture, model, available, kilometers, state, fuel, price_day, fuel_card_id) VALUES ('AW-456-QS', 'Citadine', 'Citroen', 'https://www.auto-infos.fr/mediatheque/6/1/4/000271416_600x400_c.JPG', 'C3', true, 5000, 'Neuve', 'Electrique', 38, 3);
INSERT INTO car (immat, type, brand, picture, model, available, kilometers, state, fuel, price_day, fuel_card_id) VALUES ('DC-456-QS', 'Utilitaire', 'Renault', 'https://img.gta5-mods.com/q75/images/renault-trafic-sncf/0ea67a-t1.PNG', 'Trafic', true, 5000, 'Neuve', 'Essence', 40, 5);
INSERT INTO car (immat, type, brand, picture, model, available, kilometers, state, fuel, price_day, fuel_card_id) VALUES ('DC-987-QS', 'Utilitaire', 'Citroen', 'https://www.flotauto.com/wp-content/uploads/2013/10/berlingo-opt-696x522-derived.jpg', 'Jumpy', true, 5000, 'Neuve', 'Diesel', 39, 4);
INSERT INTO car (immat, type, brand, picture, model, available, kilometers, state, fuel, price_day, fuel_card_id) VALUES ('GF-123-QS', 'Utilitaire', 'Man', 'https://www.flotauto.com/wp-content/uploads/2019/03/man-etge-sncf.jpg', 'Etge', true, 5000, 'Neuve', 'Electrique', 45, 6);

-- Operation :

INSERT INTO operation (description, date, maintenance_type_id, car_id) VALUES ("Rien à Déclarer","2023-11-04T15:30:00.000Z", 1, 1),("Visite de Retour","2023-11-13T13:00:00.000Z", 2, 1),("Véhicule accidentée","2022-11-13T18:30:00.000Z", 4 , 1), ("Visite des 5000 Km","2022-11-30T8:30:00.000Z", 3 , 1);
INSERT INTO operation (description, date, maintenance_type_id, car_id) VALUES ("Rien à Déclarer","2023-11-14T15:30:00.000Z", 1, 2),("Visite de Retour","2023-11-10T13:00:00.000Z", 2, 2),("Véhicule accidentée","2022-07-13T9:30:00.000Z", 4 , 2), ("Visite des 5000 Km","2022-12-01T8:30:00.000Z", 3 , 2);
INSERT INTO operation (description, date, maintenance_type_id, car_id) VALUES ("Rien à Déclarer","2023-11-10T15:30:00.000Z", 1, 3),("Visite de Retour","2023-11-13T13:30:00.000Z", 2, 3),("Véhicule accidentée","2022-05-13T10:30:00.000Z", 4 , 3), ("Visite des 5000 Km","2022-12-02T8:30:00.000Z", 3 , 3);
INSERT INTO operation (description, date, maintenance_type_id, car_id) VALUES ("Rien à Déclarer","2023-11-14T15:30:00.000Z", 1, 4),("Visite de Retour","2023-11-11T13:00:00.000Z", 2, 4),("Véhicule accidentée","2022-09-13T18:00:00.000Z", 4 , 4), ("Visite des 5000 Km","2022-12-03T8:30:00.000Z", 3 , 4);
INSERT INTO operation (description, date, maintenance_type_id, car_id) VALUES ("Rien à Déclarer","2023-11-10T09:30:00.000Z", 1, 5),("Visite de Retour","2023-11-17T13:30:00.000Z", 2, 5),("Véhicule accidentée","2022-12-13T10:30:00.000Z", 4 , 5), ("Visite des 5000 Km","2022-12-10T8:30:00.000Z", 3 , 5);
INSERT INTO operation (description, date, maintenance_type_id, car_id) VALUES ("Rien à Déclarer","2023-11-14T10:30:00.000Z", 1, 6),("Visite de Retour","2023-11-20T13:00:00.000Z", 2, 6),("Véhicule accidentée","2022-06-13T18:00:00.000Z", 4 , 6), ("Visite des 5000 Km","2022-12-14T8:30:00.000Z", 3 , 6);

--Opinion :

INSERT INTO opinion (opinion_rank, comments) VALUES (4, 'Très bon service, voiture propre.');
INSERT INTO opinion (opinion_rank, comments) VALUES (3, 'La voiture avait une odeur désagréable.');
INSERT INTO opinion (opinion_rank, comments) VALUES (5, 'Excellent service, voiture en bon état.');
INSERT INTO opinion (opinion_rank, comments) VALUES (4, 'Pas de problème avec la voiture.');
INSERT INTO opinion (opinion_rank, comments) VALUES (2, 'La voiture avait des problèmes mécaniques.');
INSERT INTO opinion (opinion_rank, comments) VALUES (5, 'Service rapide et efficace.');
INSERT INTO opinion (opinion_rank, comments) VALUES (3, "La voiture n'était pas très propre.");
INSERT INTO opinion (opinion_rank, comments) VALUES (4, 'Bonne expérience globale.');
INSERT INTO opinion (opinion_rank, comments) VALUES (1, 'La voiture avait un problème de freinage.');
INSERT INTO opinion (opinion_rank, comments) VALUES (5, 'Service exceptionnel, voiture en excellent état.');
INSERT INTO opinion (opinion_rank, comments) VALUES (3, 'La voiture était sale à la prise en charge.');
INSERT INTO opinion (opinion_rank, comments) VALUES (4, 'Pas de problème majeur avec la voiture.');
INSERT INTO opinion (opinion_rank, comments) VALUES (2, 'La voiture était en panne au milieu du trajet.');
INSERT INTO opinion (opinion_rank, comments) VALUES (4, 'Service professionnel.');
INSERT INTO opinion (opinion_rank, comments) VALUES (5, 'La voiture était propre et bien entretenue.');
INSERT INTO opinion (opinion_rank, comments) VALUES (3, 'Le service client pourrait être amélioré.');
INSERT INTO opinion (opinion_rank, comments) VALUES (4, 'Aucun problème avec la voiture.');
INSERT INTO opinion (opinion_rank, comments) VALUES (5, 'Expérience de location agréable.');

--Reservation :

INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (150, true, 1, 1, NULL, "20.11.2023 8:00:00", "20.11.2023 12:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (200, true, 1, 2, NULL, "25.11.2023 14:00:00", "25.11.2023 16:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (180, true, 1, 3, NULL, "28.11.2023 13:00:00", "28.11.2023 15:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (300, true, 3, 4, NULL, "12.12.2023 8:00:00", "12.12.2023 12:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (180, true, 3, 5, NULL, "20.12.2023 10:00:00", "20.12.2023 12:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (300, true, 3, 6, NULL, "22.12.2023 15:00:00", "22.12.2023 17:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (100, true, 2, 7, NULL, "25.11.2023 8:00:00", "25.11.2023 10:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (120, true, 2, 8, NULL, "10.12.2023 9:00:00", "10.12.2023 11:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (250, true, 2, 9, NULL, "15.12.2023 14:00:00", "15.12.2023 18:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (200, true, 4, 10, NULL, "27.11.2023 8:00:00", "27.11.2023 12:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (150, true, 4, 11, NULL, "05.12.2023 8:00:00", "05.12.2023 12:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (200, true, 4, 12, NULL, "08.12.2023 14:00:00", "08.12.2023 18:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (250, true, 5, 13, NULL, "29.11.2023 10:00:00", "29.11.2023 12:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (250, true, 5, 14, NULL, "18.12.2023 16:00:00", "18.12.2023 18:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (300, true, 5, 15, NULL, "20.12.2023 10:00:00", "20.12.2023 12:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (150, true, 6, 16, NULL, "02.12.2023 9:00:00", "02.12.2023 11:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (120, true, 6, 17, NULL, "07.12.2023 9:00:00", "07.12.2023 11:00:00");
INSERT INTO reservation (cost_reservation, status_reservation, car_id, opinion_id, user_id, start_date, end_date) VALUES (180, true, 6, 18, NULL, "10.12.2023 13:00:00", "10.12.2023 15:00:00");

