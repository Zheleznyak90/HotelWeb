use HotelDB;

INSERT INTO role(role) VALUES
("client"),
("manager"),
("admin");


INSERT INTO room_class(class) VALUES
("3 stars"),
("4 stars"),
("5 stars");

INSERT INTO room_pattern(class_id, size, price, name, description) VALUES
("1","4","15","poor1","Cheap room for one night staying."),
("2","2","50","middle1","In HotelWeb, even the rooms that we define as standard offer 5 star comfort. Single, double or family... Everyone lives this comfort and unique luxury. What are the things that make a room comfortable? Bathroom with a bathtub, central air conditioner, direct phone line, blow dryer, satellite broadcasting plasma TV, info and music channels, internet access, minibar, safe and balcony... And it is in the ideal size for families... After all of these opportunities, the only thing you have to do is to enjoy your perfect room and holiday."),
("2","3","70","middle2","In HotelWeb, even the rooms that we define as standard offer 5 star comfort. Single, double or family... Everyone lives this comfort and unique luxury. What are the things that make a room comfortable? Bathroom with a bathtub, central air conditioner, direct phone line, blow dryer, satellite broadcasting plasma TV, info and music channels, internet access, minibar, safe and balcony... And it is in the ideal size for families... After all of these opportunities, the only thing you have to do is to enjoy your perfect room and holiday. "),
("3","2","200","lux1","Things you can only experience in a dream are in HotelWeb, because we were inspired from your dreams. That's why it is so unique and unequalled. 1 living room 1 Bedroom 1 Bathtub Central air conditioner Direct phone line Blow dryer Satellite broadcasting plasma TV Info and music channels Internet access Minibar Safe Balcony A sofa for third person Viewing either the sea or the golf field... To offer you the maximum comfort... ");

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
("pending"),
("unconfirmed"),
("confirmed"),
("waiting_for_cancel"),
("canceled");


SET GLOBAL event_scheduler = ON;

CREATE EVENT request_clean
ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL 1 DAY
ON COMPLETION PRESERVE
DO
      DELETE FROM orderT WHERE created < DATE_SUB(NOW(), INTERVAL 2 DAY)
      AND order_status IN(1,2);
      
