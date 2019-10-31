drop table if exists has_role;
drop table if exists goes_on;
drop table if exists event_place_category;
drop table if exists event;
drop table if exists tour;
drop table if exists ticket;
drop table if exists placecategory;
drop table if exists users;
drop table if exists location;
drop table if exists role;
drop table if exists artist;
drop table if exists client;


create table if not exists client (
                                      client_id serial,
                                      firstname varchar(255) not null,
                                      lastname varchar(255) not null,
                                      address varchar(255) not null,
                                      primary key (client_id)
);

create table if not exists artist (
                                      artistname varchar(255) not null,
                                      genre varchar (255),
                                      primary key (artistname)
);

create table if not exists role (
                                    role_id serial,
                                    role_name varchar (255) not null,
                                    rights varchar (255) not null,
                                    primary key (role_id)
);

create table if not exists location (
                                        location_id serial,
                                        address varchar (255) not null,
                                        room varchar (255),
                                        building varchar (255),
                                        seats integer not null,
                                        standing_places integer not null,
                                        primary key (location_id)
);

create table if not exists users (
                                     username varchar (255) not null,
                                     password varchar (255) not null,
                                     address varchar (255),
                                     mobile varchar (255),
                                     email varchar (255),
                                     primary key (username)
);

create table if not exists placecategory (
                                             categoryname varchar (255) not null,
                                             category varchar (255) not null,
                                             price numeric(12,2) not null,
                                             primary key (categoryname)
);

create table if not exists ticket (
                                      ticket_id serial,
                                      ticket_number integer not null,
                                      sold integer not null,
                                      categoryname varchar (255) not null,
                                      client_id integer,
                                      foreign key (categoryname) references placecategory(categoryname),
                                      foreign key (client_id) references client(client_id),
                                      primary key (ticket_id)
);

create table if not exists tour (
                                    tour_id serial,
                                    description varchar (255),
                                    category varchar (255),
                                    username varchar (255) not null,
                                    foreign key (username) references users(username),
                                    primary key (tour_id)
);

create table if not exists event (
                                     event_id serial,
                                     date date not null,
                                     seat_reservation_possible BOOLEAN not null,
                                     tour_id integer not null,
                                     location_id integer not null,
                                     foreign key (tour_id) references tour(tour_id),
                                     foreign key (location_id) references location(location_id),
                                     primary key (event_id)
);

create table if not exists has_role (
                                        has_role_id serial,
                                        role_id integer not null,
                                        username varchar(255) not null,
                                        foreign key (role_id) references role(role_id),
                                        foreign key (username) references users(username),
                                        primary key (has_role_id)
);

create table if not exists goes_on (
                                       goes_on_id serial,
                                       tour_id integer not null,
                                       artistname varchar (255) not null,
                                       foreign key (tour_id) references tour(tour_id),
                                       foreign key (artistname) references artist(artistname),
                                       primary key (goes_on_id)
);

create table if not exists event_place_category (
                                                    event_place_category_id serial,
                                                    event_id integer not null,
                                                    categoryname varchar (255) not null,
                                                    foreign key (event_id) references event(event_id),
                                                    foreign key (categoryname) references placecategory(categoryname),
                                                    primary key (event_place_category_id)
);