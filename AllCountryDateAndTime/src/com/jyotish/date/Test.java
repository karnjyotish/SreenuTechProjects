package com.jyotish.date;

import java.awt.List;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;

public class Test {
	private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";

    public static void main(String[] args) {

        String dateInString = "31-1-2019 10:15:55 AM";
        LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));

        ZoneId singaporeZoneId = ZoneId.of("Asia/Singapore");
        System.out.println("TimeZone : " + singaporeZoneId);
        
        //LocalDateTime + ZoneId = ZonedDateTime
        ZonedDateTime asiaZonedDateTime = ldt.atZone(singaporeZoneId);
       
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
        /*System.out.println(format.format(asiaZonedDateTime));
*/
		
        ArrayList<String> ids=new ArrayList<>();
        ids=GetZones("US");
		System.out.println(ids);
		
		for(String i:ids)
		{
			
			ZoneId asiaall=ZoneId.of(i);
			System.out.println(asiaall);
			 ZonedDateTime asiaZonedDateTimeall = ldt.atZone(asiaall);
			 DateTimeFormatter formatall = DateTimeFormatter.ofPattern(DATE_FORMAT);
			 System.out.println(format.format(asiaZonedDateTimeall));
			
			
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
