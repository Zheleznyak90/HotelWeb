use HotelDB;

INSERT INTO role(role) VALUES
("client"),
("manager"),
("admin");

INSERT INTO userT(role_id, email, password) VALUES
("1", "user1@mail.ru","пїЅ_0пїЅ,пїЅпїЅE/9пїЅVпїЅ3пїЅB"),
("1", "user2@mail.ru","пїЅпїЅпїЅWпїЅj*DпїЅпїЅФµ5пїЅ^'пїЅпїЅ=пїЅ"),
("2", "manager@mail.ru","пїЅmcQпїЅqпїЅпїЅЮѕпїЅпїЅ5%пїЅ 6z"),
("3", "admin@mail.ru","пїЅпїЅпїЅ$fпїЅпїЅHпїЅпїЅ<I#yпїЅ");

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

INSERT INTO meal(name, price) VALUES 
("breakfast included", "0"),
("half-board", "7"),
("all-inclusive", "16");

INSERT INTO order_status(status) VALUES 
("unconfirmed"),
("confirmed"),
("canceled");


SET GLOBAL event_scheduler = ON;

CREATE EVENT request_clean
ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL 1 DAY
ON COMPLETION PRESERVE
DO
      DELETE FROM orderT WHERE created < DATE_SUB(NOW(), INTERVAL 2 DAY)
      AND order_status = 1;
      
