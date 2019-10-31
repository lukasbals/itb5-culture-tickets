insert into client (firstname, lastname, address) values ('Patrick', 'Poiger', 'Zuhauseweg 1, Bludenz 6700');
insert into client (firstname, lastname, address) values ('Lukas', 'Bals', 'Hittisau 3, Wald 6989');
insert into client (firstname, lastname, address) values ('Vanessa', 'Durig', 'Gaschurnstraße 14, Gaschurn 6793');
insert into client (firstname, lastname, address) values ('Pia-Maria', 'Weiß', 'Dornbirnstraße 3, Dornbirn 6850');

insert into artist (artistname, genre) values ('Baka Boing', 'Heavy Metal');
insert into artist (artistname, genre) values ('Hofrat Dr.-Med. Dr. DI. BalsiBals', 'Sachvortrag');
insert into artist (artistname, genre) values ('VaniHase', 'Alternative Pop');
insert into artist (artistname, genre) values ('Pia-Maria', 'Poetry Slam');

insert into role (role_name, rights) values ('admin', 'fullcontroll');

insert into location (address, room, building, seats, standing_places) values ('Spielboden 2, Dornbirn 6850', 'Kantine', 'A', 30, 50);
insert into location (address, room, building, seats, standing_places) values ('Festspielhaus, Bregenz 6900', 'Festsaal', 'Hauptgebäude', 150, 100);
insert into location (address, building, seats, standing_places) values ('Montforthaus, Feltkirch 6600', 'Einhang A', 100, 50);
insert into location (address, building, seats, standing_places) values ('Villa K, Bludenz 6700', 'Hauptgebäude', 20, 30);

insert into placecategory (categoryname, category, price) values ('Sitzplatzkategorie A', 'Sitzplatz', 12.50);
insert into placecategory (categoryname, category, price) values ('Sitzplatzkategorie B', 'Sitzplatz', 7.50);
insert into placecategory (categoryname, category, price) values ('Stehplatz', 'Stehplatz', 5.00);

insert into ticket (ticket_number, sold, categoryname, client_id) values (1, 0, 'Sitzplatz', 1);
insert into ticket (ticket_number, sold, categoryname, client_id) values (2, 0, 'Sitzplatz', 1);
insert into ticket (ticket_number, sold, categoryname, client_id) values (3, 0, 'Sitzplatz', 1);
insert into ticket (ticket_number, sold, categoryname, client_id) values (4, 0, 'Sitzplatz', 1);
insert into ticket (ticket_number, sold, categoryname, client_id) values (5, 0, 'Sitzplatz', 2);
insert into ticket (ticket_number, sold, categoryname, client_id) values (6, 0, 'Sitzplatz', 2);
insert into ticket (ticket_number, sold, categoryname, client_id) values (7, 0, 'Sitzplatz', 2);
insert into ticket (ticket_number, sold, categoryname, client_id) values (8, 0, 'Sitzplatz', 2);
insert into ticket (ticket_number, sold, categoryname, client_id) values (9, 0, 'Sitzplatz', 3);
insert into ticket (ticket_number, sold, categoryname, client_id) values (10, 0, 'Sitzplatz', 3);
insert into ticket (ticket_number, sold, categoryname, client_id) values (11, 0, 'Sitzplatz', 3);
insert into ticket (ticket_number, sold, categoryname, client_id) values (12, 0, 'Sitzplatz', 4);
insert into ticket (ticket_number, sold, categoryname, client_id) values (13, 0, 'Stehplatz', 4);
insert into ticket (ticket_number, sold, categoryname, client_id) values (14, 0, 'Stehplatz', 4);
insert into ticket (ticket_number, sold, categoryname, client_id) values (15, 0, 'Stehplatz', 4);
insert into ticket (ticket_number, sold, categoryname, client_id) values (16, 0, 'Stehplatz', 1);
insert into ticket (ticket_number, sold, categoryname, client_id) values (17, 0, 'Stehplatz', 1);
insert into ticket (ticket_number, sold, categoryname, client_id) values (18, 0, 'Stehplatz', 1);
insert into ticket (ticket_number, sold, categoryname, client_id) values (19, 0, 'Stehplatz', 2);
insert into ticket (ticket_number, sold, categoryname, client_id) values (20, 0, 'Stehplatz', 2);
insert into ticket (ticket_number, sold, categoryname, client_id) values (21, 0, 'Stehplatz', 2);

insert into users (username, password, address) values ('admin', 'WS2019+fhv', 'Hauptstraße 1, 6700 Bludenz');

insert into tour (description, category, username) values ('Vorarlberg Tour', 'Musik', 'admin');
insert into tour (description, category, username) values ('Österreich Tour', 'Vortrag', 'admin');
insert into tour (description, category, username) values ('Einmaliger Auftritt in Vorarlberg', 'Poetry Slam', 'admin');

insert into event (date, seat_reservation_possible, tour_id, location_id) values ('2019-12-23', true, 1, 1);
insert into event (date, seat_reservation_possible, tour_id, location_id) values ('2019-07-15', false , 1, 2);
insert into event (date, seat_reservation_possible, tour_id, location_id) values ('2019-06-28', true, 1, 3);
insert into event (date, seat_reservation_possible, tour_id, location_id) values ('2019-07-27', false , 1, 4);
insert into event (date, seat_reservation_possible, tour_id, location_id) values ('2019-12-23', true, 2, 1);
insert into event (date, seat_reservation_possible, tour_id, location_id) values ('2019-07-15', false , 2, 2);
insert into event (date, seat_reservation_possible, tour_id, location_id) values ('2019-06-28', true, 2, 3);
insert into event (date, seat_reservation_possible, tour_id, location_id) values ('2019-07-27', false , 2, 4);
insert into event (date, seat_reservation_possible, tour_id, location_id) values ('2019-07-27', true , 3, 1);

insert into event_place_category (event_id, categoryname) values (1, 'Sitzplatzkategorie A');
insert into event_place_category (event_id, categoryname) values (1, 'Sitzplatzkategorie B');
insert into event_place_category (event_id, categoryname) values (1, 'Stehplatz');
insert into event_place_category (event_id, categoryname) values (2, 'Stehplatz');
insert into event_place_category (event_id, categoryname) values (3, 'Sitzplatzkategorie A');
insert into event_place_category (event_id, categoryname) values (3, 'Stehplatz');
insert into event_place_category (event_id, categoryname) values (4, 'Stehplatz');
insert into event_place_category (event_id, categoryname) values (5, 'Sitzplatzkategorie A');
insert into event_place_category (event_id, categoryname) values (6, 'Sitzplatzkategorie A');
insert into event_place_category (event_id, categoryname) values (6, 'Sitzplatzkategorie B');
insert into event_place_category (event_id, categoryname) values (6, 'Stehplatz');

insert into goes_on (tour_id, artistname) values (1, 'Baka Boing');
insert into goes_on (tour_id, artistname) values (2, 'VaniHase');
insert into goes_on (tour_id, artistname) values (3, 'Hofrat Dr.-Med. Dr. DI. BalsiBals');

insert into has_role (role_id, username) values (1, 'admin');