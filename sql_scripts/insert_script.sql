insert into clients (firstname, lastname, address) values ('Patrick', 'Poiger', 'Zuhauseweg 1, Bludenz 6700');
insert into clients (firstname, lastname, address) values ('Lukas', 'Bals', 'Hittisau 3, Wald 6989');
insert into clients (firstname, lastname, address) values ('Vanessa', 'Durig', 'Gaschurnstraße 14, Gaschurn 6793');
insert into clients (firstname, lastname, address) values ('Pia-Maria', 'Weiß', 'Dornbirnstraße 3, Dornbirn 6850');

insert into artists (artistname, genre) values ('Baka Boing', 'Heavy Metal');
insert into artists (artistname, genre) values ('Hofrat Dr.-Med. Dr. DI. BalsiBals', 'Sachvortrag');
insert into artists (artistname, genre) values ('VaniHase', 'Alternative Pop');
insert into artists (artistname, genre) values ('Pia-Maria', 'Poetry Slam');

insert into roles (role_name, rights) values ('admin', 'fullcontroll');

insert into locations (address, room, building) values ('Spielboden 2, Dornbirn 6850', 'Kantine', 'A');
insert into locations (address, room, building) values ('Festspielhaus, Bregenz 6900', 'Festsaal', 'Hauptgebäude');
insert into locations (address, building) values ('Montforthaus, Feltkirch 6600', 'Einhang A');
insert into locations (address, building) values ('Villa K, Bludenz 6700', 'Hauptgebäude');

insert into placecategories (categoryname, category, price, amount) values ('Sitzplatzkategorie A', 'Sitzplatz', 12.50, 30);
insert into placecategories (categoryname, category, price, amount) values ('Sitzplatzkategorie B', 'Sitzplatz', 7.50, 50);
insert into placecategories (categoryname, category, price, amount) values ('Stehplatz', 'Stehplatz', 5.00, 100);

insert into users (username, email) values ('admin', 'ppo7929@students.fhv.at');

insert into tours (tourname, description, category, user_id) values ('V-Tour', 'Vorarlberg Tour', 'Musik', 1);
insert into tours (tourname, description, category, user_id) values ('Ösis', 'Österreich Tour', 'Vortrag', 1);
insert into tours (tourname, description, category, user_id) values ('PPPPPoetry', 'Einmaliger Auftritt in Vorarlberg', 'Poetry Slam', 1);

insert into events (date, seat_reservation_possible, tour_id, location_id) values ('2019-12-23', true, 1, 1);
insert into events (date, seat_reservation_possible, tour_id, location_id) values ('2020-07-15', false , 1, 2);
insert into events (date, seat_reservation_possible, tour_id, location_id) values ('2020-06-28', true, 1, 3);
insert into events (date, seat_reservation_possible, tour_id, location_id) values ('2020-07-27', false , 1, 4);
insert into events (date, seat_reservation_possible, tour_id, location_id) values ('2019-12-23', true, 2, 1);
insert into events (date, seat_reservation_possible, tour_id, location_id) values ('2020-07-15', false , 2, 2);
insert into events (date, seat_reservation_possible, tour_id, location_id) values ('2019-06-28', true, 2, 3);
insert into events (date, seat_reservation_possible, tour_id, location_id) values ('2019-07-27', false , 2, 4);
insert into events (date, seat_reservation_possible, tour_id, location_id) values ('2019-07-27', true , 3, 1);

insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (1, 0, 1, 1, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (2, 0, 1, 1, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (3, 0, 2, 1, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (4, 0, 2, 1, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (5, 0, 3, 2, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (6, 0, 1, 2, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (7, 0, 3, 2, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (8, 0, 2, 2, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (9, 0, 2, 3, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (10, 0, 3, 3, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (11, 0, 3, 3, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (12, 0, 1, 4, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (13, 0, 2, 4, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (14, 0, 3, 4, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (15, 0, 1, 4, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (16, 0, 2, 1, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (17, 0, 1, 1, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (18, 0, 2, 1, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (19, 0, 3, 2, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (20, 0, 3, 2, 1);
insert into tickets (ticket_number, sold, category_id, client_id, event_id) values (21, 0, 1, 2, 1);

insert into events_places_categories (event_id, category_id) values (1, 1);
insert into events_places_categories (event_id, category_id) values (1, 2);
insert into events_places_categories (event_id, category_id) values (1, 3);
insert into events_places_categories (event_id, category_id) values (2, 3);
insert into events_places_categories (event_id, category_id) values (3, 1);
insert into events_places_categories (event_id, category_id) values (3, 3);
insert into events_places_categories (event_id, category_id) values (4, 3);
insert into events_places_categories (event_id, category_id) values (5, 1);
insert into events_places_categories (event_id, category_id) values (6, 1);
insert into events_places_categories (event_id, category_id) values (6, 2);
insert into events_places_categories (event_id, category_id) values (6, 3);
insert into events_places_categories (event_id, category_id) values (7, 3);
insert into events_places_categories (event_id, category_id) values (8, 3);
insert into events_places_categories (event_id, category_id) values (9, 3);

insert into going_on (tour_id, artist_id) values (1, 1);
insert into going_on (tour_id, artist_id) values (2, 3);
insert into going_on (tour_id, artist_id) values (3, 2);

insert into has_roles (role_id, user_id) values (1, 1);