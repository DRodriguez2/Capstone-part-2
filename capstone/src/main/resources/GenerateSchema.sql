DROP DATABASE IF EXISTS musicstore;

CREATE DATABASE musicstore;
USE musicstore;

CREATE TABLE s_user(
	username varchar(255),
	password varchar(255),
	phone varchar(255),
	user_id int,
	role varchar(255),
	PRIMARY KEY (user_id)
);

CREATE TABLE artist(
	artist_id int,
	PRIMARY KEY (artist_id),
	name varchar(255)
);

CREATE TABLE payment_info(
	payment_info_id int,
	PRIMARY KEY (payment_info_id),
	user_id int,
	FOREIGN KEY (user_id) REFERENCES s_user(user_id),
	card_number varchar(17),
	expiration varchar(7),
	cvv varchar(4),
	address varchar(255)
);

CREATE TABLE genre(
	genre_id int NOT NULL,
	name varchar(255),
	PRIMARY KEY (genre_id)
);

CREATE TABLE category(
	genre_id int,
	category_id int,
	name varchar(255),
	PRIMARY KEY (category_id),
	FOREIGN KEY (genre_id) REFERENCES genre(genre_id)
);

CREATE TABLE product(
	product_id int,
	category_id int,
	price decimal(19, 2),
	PRIMARY KEY (product_id),
	FOREIGN KEY (category_id) REFERENCES category(category_id)
);

/*TODO: Add payment information*/
CREATE TABLE album(
	album_id int NOT NULL,
	product_id int,
	title varchar(255),
	description varchar(255),
	PRIMARY KEY (album_id),
	FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE track(
	track_id int NOT NULL,
	title varchar(255),
	description varchar(255),
	price decimal(19,2),
	album_id int,
	product_id int, 
	artist_id int,
	FOREIGN KEY (artist_id) REFERENCES artist(artist_id),
	FOREIGN KEY (album_id) REFERENCES album(album_id),
	FOREIGN KEY (product_id) REFERENCES product(product_id),
	PRIMARY KEY (track_id)
);

CREATE TABLE cart(
	cart_id int,
	user_id int,
	FOREIGN KEY (user_id) REFERENCES s_user(user_id),
/*This records whether the purchase has been made
--and is set to false for default
--if it has been purchased, there is an object
--in the purchased table pointing to it
--A new cart object will be generated*/
	is_purchased BOOLEAN,
	PRIMARY KEY (cart_id)
);

/*Keeps record of past transactions
--purchased carts are maintained in the
--database for later viewing*/
CREATE TABLE transaction(
	transaction_id int,
	cart_id int,
	FOREIGN KEY (cart_id) REFERENCES cart(cart_id),
	purchased_on date,
	payment_info_id int,
	FOREIGN KEY (payment_info_id) REFERENCES payment_info(payment_info_id)
);

/*This joint table is a design pattern for 
--many-to-many relationships in databases
--Each entry corresponds to one entry of 
--one track object in a track cart. The track_id
--points to the id of the track entry and the
--cart_id points to the id of the cart
--for the entry*/
CREATE TABLE cartproduct(
	cartproduct_id int,
	cart_id int,
	FOREIGN KEY (cart_id) REFERENCES cart(cart_id),
	product_id int,
	FOREIGN KEY (product_id) REFERENCES product(product_id),
	PRIMARY KEY (cartproduct_id)
);
