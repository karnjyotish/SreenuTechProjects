package com.jyotish.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

public class ConvertTimeAndDate {
	private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a z";
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

	public static void main(String[] args) {

		Map<String, String> dateTime = new HashMap<>();
		ArrayList<String> ids = new ArrayList<>();
		ids = GetZones("US");
		ZoneId fromTimeZone = ZoneId.of("Asia/Kolkata");// Source timezone
		LocalDateTime today = LocalDateTime.now(); // Current time

		// Zoned date time at source timezone
		ZonedDateTime currentISTime = today.atZone(fromTimeZone);
		System.out.println(fromTimeZone);
		System.out.println(formatter.format(currentISTime));

		for (String i : ids) {

			ZoneId toTimeZone = ZoneId.of(i); // Target timezone

			// Zoned date time at target timezone
			ZonedDateTime currentETime = currentISTime.withZoneSameInstant(toTimeZone);

			// Format date time - optional

			dateTime.put(i, String.valueOf(formatter.format(currentETime)));
		}
		Collection c = dateTime.values();
		Set s1 = dateTime.entrySet();
		Iterator itr = s1.iterator();
		while (itr.hasNext()) {
			Map.Entry m1 = (Map.Entry) itr.next();
			System.out.println(m1.getKey());
			System.out.println(m1.getValue());
		}

	}

	public static ArrayList<String> GetZones(String country) {
		ArrayList zones = new ArrayList<>();

		for (String i : TimeZone.getAvailableIDs()) {
			if (i.startsWith(country)) {
				zones.add(i);
			}
		}
		return zones;
	}

}
