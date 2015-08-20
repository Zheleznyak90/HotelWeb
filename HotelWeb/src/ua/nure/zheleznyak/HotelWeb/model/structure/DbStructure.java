package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbStructure {
	private static DbStructure dbs;
	
	private Map<String, List<String>> database;
	private DbStructure() {
		database = new HashMap<String,List<String>>();
		database.put("role", getClassFields(Role.class));
		database.put("userT", getClassFields(User.class));
		database.put("room_class", getClassFields(ApartmentClass.class));
		database.put("room_pattern", getClassFields(RoomPattern.class));
		database.put("room", getClassFields(Room.class));
		database.put("order_status", getClassFields(OrderStatus.class));
		database.put("meal", getClassFields(Meal.class));
		database.put("request", getClassFields(Request.class));
		database.put("orderT", getClassFields(Order.class));
		database.put("booking_period", getClassFields(BookingPeriod.class));

	}

	public static DbStructure getSigleton() {
		if (dbs == null) {
			dbs = new DbStructure();
		}
		return dbs;
	}
	
	private static List<String> getClassFields(Class<?> clazz){
		List<String> fields = new ArrayList<String>();
		for(Field f:clazz.getDeclaredFields()){
			fields.add(f.toString());
		}
		return fields;
	}
	
	public boolean checkTableName(String tableName){
		return database.get(tableName)!=null;
	}
	
	public boolean checkTableField(String tableName, String fieldName){
		for(String field:database.get(tableName)){
			if(field.equals(fieldName)){
				return true;
			}
		}
		return false;
	}	
}
