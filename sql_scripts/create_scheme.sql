drop table if exists has_roles;
drop table if exists going_on;
drop table if exists events_places_categories;
drop table if exists tickets;
drop table if exists placecategories;
drop table if exists events;
drop table if exists tours;
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
									  artist_id serial,
                                      artistname varchar(255) not null,
                                      genre varchar (255),
                                      primary key (artist_id)
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
                                        primary key (location_id)
);

create table if not exists users (
                                     user_id serial,
                                     username varchar (255) not null,
                                     email varchar (255) not null,
                                     unique(username),
								  	 unique(username, email),
                                     primary key (user_id)
);

create table if not exists placecategories (
                                             category_id serial,
                                             categoryname varchar (255) not null,
                                             category varchar (255) not null,
                                             price numeric(12,2) not null,
                                             amount integer not null,
                                             primary key (category_id)
);

create table if not exists tours (
                                    tour_id serial,
                                    tourname varchar(255) not null,
                                    description varchar (255),
                                    category varchar (255),
                                    user_id integer not null,
                                    foreign key (user_id) references users(user_id),
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

create table if not exists tickets (
                                      ticket_id serial,
                                      sold integer not null,
                                      category_id integer not null,
                                      event_id integer not null,
                                      client_id integer,
                                      ticket_number integer,
                                      foreign key (category_id) references placecategories(category_id),
                                      foreign key (client_id) references clients(client_id),
                                      foreign key (event_id) references events(event_id),
                                      unique (category_id, event_id, ticket_number),
                                      primary key (ticket_id)
);

create table if not exists has_roles (
                                        has_role_id serial,
                                        role_id integer not null,
                                        user_id integer not null,
                                        foreign key (role_id) references roles(role_id),
                                        foreign key (user_id) references users(user_id),
                                        primary key (has_role_id)
);

create table if not exists going_on (
                                       going_on_id serial,
                                       tour_id integer not null,
                                       artist_id integer not null,
                                       foreign key (tour_id) references tours(tour_id),
                                       foreign key (artist_id) references artists(artist_id),
                                       primary key (going_on_id)
);

create table if not exists events_places_categories (
                                                    events_places_categories_id serial,
                                                    event_id integer not null,
                                                    category_id integer not null,
                                                    foreign key (event_id) references events(event_id),
                                                    foreign key (category_id) references placecategories(category_id),
                                                    primary key (events_places_categories_id)
);