package com.example.UnitsConverter.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TimeService {
     private static final Map<String, String>ZONE_MAP=Map.ofEntries(
    		    Map.entry("UTC", "UTC"),
    		    Map.entry("GMT", "Europe/London"),
    		    Map.entry("IST", "Asia/Kolkata"),
    		    Map.entry("EST", "America/New_York"),
    		    Map.entry("EDT", "America/New_York"),
    		    Map.entry("CST_US", "America/Chicago"),
    		    Map.entry("CDT", "America/Chicago"),
    		    Map.entry("MST", "America/Denver"),
    		    Map.entry("MDT", "America/Denver"),
    		    Map.entry("PST", "America/Los_Angeles"),
    		    Map.entry("PDT", "America/Los_Angeles"),
    		    Map.entry("BST", "Europe/London"),
    		    Map.entry("CET", "Europe/Paris"),
    		    Map.entry("CEST", "Europe/Paris"),
    		    Map.entry("EET", "Europe/Bucharest"),
    		    Map.entry("JST", "Asia/Tokyo"),
    		    Map.entry("CST", "Asia/Shanghai"),
    		    Map.entry("SGT", "Asia/Singapore"),
    		    Map.entry("KST", "Asia/Seoul"),
    		    Map.entry("GST", "Asia/Dubai"),
    		    Map.entry("AEST", "Australia/Sydney"),
    		    Map.entry("ACST", "Australia/Adelaide"),
    		    Map.entry("AWST", "Australia/Perth"),
    		    Map.entry("NZST", "Pacific/Auckland"),
    		    Map.entry("ART", "America/Argentina/Buenos_Aires"),
    		    Map.entry("SAST", "Africa/Johannesburg")		 
    );
     public String convert(String from,String to) {
    	 String fr=ZONE_MAP.getOrDefault(from.toUpperCase(), from);
    	 String too=ZONE_MAP.getOrDefault(to.toUpperCase(), to);
    	 ZonedDateTime sourceTime=ZonedDateTime.now(ZoneId.of(fr));
    	 ZonedDateTime targTime=sourceTime.withZoneSameInstant(ZoneId.of(too));
    	 return targTime.toString();
     }
}
