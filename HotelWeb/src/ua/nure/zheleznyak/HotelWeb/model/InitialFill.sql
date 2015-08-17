use HotelDB;

INSERT INTO role(role) VALUES
("client"),
("manager"),
("admin");

INSERT INTO userT(role_id, email, password) VALUES
("1", "user1@mail.ru","1111"),
("1", "user2@mail.ru","2222"),
("2", "manager@mail.ru","3333"),
("3", "admin@mail.ru","4444");

INSERT INTO room_class(class) VALUES
("poor"),
("middle"),
("lux");

INSERT INTO room_pattern(class_id, size, price, name) VALUES
("1","7","15","poor1"),
("2","2","50","middle1"),
("2","3","70","middle2"),
("3","2","200","lux1");

INSERT INTO room(room_pattern, number, floor) VALUES
("1","12","1"),
("1","13","1"),
("2","21","2"),
("2","23","2"),
("2","25","2"),
("3","22","2"),
("3","24","2"),
("3","26","2"),
("3","28","2"),
("3","20","2"),
("4","30","3");

INSERT INTO meal(meal, price) VALUES 
("breakfast included", "0"),
("half-board", "7"),
("all-inclusive", "16");

INSERT INTO order_status(status) VALUES 
("unconfirmed"),
("confirmed"),
("canceled");

