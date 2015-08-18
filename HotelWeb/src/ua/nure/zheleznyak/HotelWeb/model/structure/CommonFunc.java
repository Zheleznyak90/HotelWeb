package ua.nure.zheleznyak.HotelWeb.model.structure;

public class CommonFunc {
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
