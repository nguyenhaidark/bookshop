package com.example.bookshop.myfunction;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateNow {
	public static String getDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String dateNow = simpleDateFormat.format(date);
		return dateNow;
	}
}
