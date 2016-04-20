package io.fourfinanceit.homework.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static int FROM = 0;
	private static int TO = 6;

	public static boolean isNight() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int t = calendar.get(Calendar.HOUR_OF_DAY) * 100 + calendar.get(Calendar.MINUTE);
		return (t >= FROM && t <= TO);
	}

}
