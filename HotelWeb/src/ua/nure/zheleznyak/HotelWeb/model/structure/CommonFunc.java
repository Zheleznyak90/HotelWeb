package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonFunc {
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static String hashPass(String password) {
		String res = "";
		try {
			MessageDigest digest;
			digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			byte[] input = digest.digest(password.getBytes("UTF-8"));
			res = new String(input, "UTF-8"); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
	    PrintStream out = new PrintStream(System.out, true, "UTF-8");
	    out.println(hashPass("1111"));
	    out.println(hashPass("2222"));
	    out.println(hashPass("3333"));
	    out.println(hashPass("4444"));
	}
}
