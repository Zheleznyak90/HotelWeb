DROP DATABASE HotelDB;

CREATE DATABASE HotelDB;

use HotelDB;

CREATE TABLE role(
	id INT NOT NULL AUTO_INCREMENT,
	role VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (role)
);

CREATE TABLE userT(
	id INT NOT NULL AUTO_INCREMENT,
	role_id INT NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	fullName VARCHAR(50),
	phoneNumber VARCHAR(20),
	PRIMARY KEY (id),
	FOREIGN KEY (role_id) REFERENCES role(id) 
	ON DELETE RESTRICT,
	UNIQUE (email)
);


CREATE TABLE room_class(
	id INT NOT NULL AUTO_INCREMENT,
	class VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (class)

);

CREATE TABLE room_pattern(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	class_id INT NOT NULL,
	size INT NOT NULL,
	price DOUBLE NOT NULL ,
	description TEXT,
	rating DECIMAL DEFAULT 0,
	PRIMARY KEY (id),
	FOREIGN KEY (class_id) REFERENCES room_class(id) 
	ON DELETE RESTRICT,
	UNIQUE(name)
);

CREATE TABLE room(
	id INT NOT NULL AUTO_INCREMENT,
	room_pattern INT NOT NULL,
	number INT NOT NULL,
	floor INT ,
	isMaintained BOOLEAN NOT NULL DEFAULT FALSE,
	PRIMARY KEY (id),
	FOREIGN KEY (room_pattern) REFERENCES room_pattern(id) 
	ON DELETE RESTRICT,
	UNIQUE (number)
);

CREATE TABLE order_status(
	id INT NOT NULL AUTO_INCREMENT,
	status VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (status)
);

CREATE TABLE meal(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	price DOUBLE NOT NULL,
	description TEXT,
	isActive BOOLEAN NOT NULL DEFAULT TRUE,
	PRIMARY KEY (id),
	UNIQUE (name)
);

CREATE TABLE booking_period(
	id INT NOT NULL AUTO_INCREMENT,
	checkIn_date DATE NOT NULL,
	checkOut_date DATE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE request(
	id INT NOT NULL AUTO_INCREMENT,
	client_id INT NOT NULL,
	manager_id INT,
	number_of_person INT NOT NULL,
	booking_period INT NOT NULL,
	created DATETIME NOT NULL,
	isServed BOOLEAN NOT NULL DEFAULT FALSE,
	PRIMARY KEY (id),
	FOREIGN KEY (booking_period) REFERENCES booking_period(id) 
	ON DELETE RESTRICT,
	FOREIGN KEY (client_id) REFERENCES userT(id) 
	ON DELETE RESTRICT,
	FOREIGN KEY (manager_id) REFERENCES userT(id) 
	ON DELETE SET NULL
);

CREATE TABLE orderT(
	id INT NOT NULL AUTO_INCREMENT,
	room_id INT NOT NULL,
	client_id INT NOT NULL,
	meal_id INT NOT NULL,
	manager_id INT,
	order_status INT NOT NULL,
	created DATE NOT NULL,
	booking_period INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (room_id) REFERENCES room(id) 
	ON DELETE RESTRICT,
	FOREIGN KEY (client_id) REFERENCES userT(id) 
	ON DELETE RESTRICT,
	FOREIGN KEY (meal_id) REFERENCES meal(id) 
	ON DELETE RESTRICT,
	FOREIGN KEY (manager_id) REFERENCES userT(id) 
	ON DELETE SET NULL,
	FOREIGN KEY (order_status) REFERENCES order_status(id) 
	ON DELETE RESTRICT,
	FOREIGN KEY (booking_period) REFERENCES booking_period(id) 
	ON DELETE RESTRICT
	
);
