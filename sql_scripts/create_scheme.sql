drop table if exists has_roles;
drop table if exists going_on;
drop table if exists events_places_categories;
drop table if exists events;
drop table if exists tours;
drop table if exists tickets;
drop table if exists placecategories;
drop table if exists users;
drop table if exists locations;
drop table if exists roles;
drop table if exists artists;
drop table if exists clients;


create table if not exists clients (
                                      client_id serial,
                                      firstname varchar(255) not null,
                                      lastname varchar(255) not null,
                                      address varchar(255) not null,
                                      primary key (client_id)
);

create table if not exists artists (
                                      artistname varchar(255) not null,
                                      genre varchar (255),
                                      primary key (artistname)
);

create table if not exists roles (
                                    role_id serial,
                                    role_name varchar (255) not null,
                                    rights varchar (255) not null,
                                    primary key (role_id)
);

create table if not exists locations (
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

create table if not exists placecategories (
                                             categoryname varchar (255) not null,
                                             category varchar (255) not null,
                                             price numeric(12,2) not null,
                                             primary key (categoryname)
);

create table if not exists tickets (
                                      ticket_id serial,
                                      ticket_number integer not null,
                                      sold integer not null,
                                      categoryname varchar (255) not null,
                                      client_id integer,
                                      foreign key (categoryname) references placecategories(categoryname),
                                      foreign key (client_id) references clients(client_id),
                                      primary key (ticket_id)
);

create table if not exists tours (
                                    tour_id serial,
                                    description varchar (255),
                                    category varchar (255),
                                    username varchar (255) not null,
                                    foreign key (username) references users(username),
                                    primary key (tour_id)
);

create table if not exists events (
                                     event_id serial,
                                     date date not null,
                                     seat_reservation_possible BOOLEAN not null,
                                     tour_id integer not null,
                                     location_id integer not null,
                                     foreign key (tour_id) references tours(tour_id),
                                     foreign key (location_id) references locations(location_id),
                                     primary key (event_id)
);

create table if not exists has_roles (
                                        has_role_id serial,
                                        role_id integer not null,
                                        username varchar(255) not null,
                                        foreign key (role_id) references roles(role_id),
                                        foreign key (username) references users(username),
                                        primary key (has_role_id)
);

create table if not exists going_on (
                                       going_on_id serial,
                                       tour_id integer not null,
                                       artistname varchar (255) not null,
                                       foreign key (tour_id) references tours(tour_id),
                                       foreign key (artistname) references artists(artistname),
                                       primary key (going_on_id)
);

create table if not exists events_places_categories (
                                                    events_places_categories_id serial,
                                                    event_id integer not null,
                                                    categoryname varchar (255) not null,
                                                    foreign key (event_id) references events(event_id),
                                                    foreign key (categoryname) references placecategories(categoryname),
                                                    primary key (events_places_categories_id)
);