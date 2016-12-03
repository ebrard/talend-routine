package routines;

import java.util.Date ;
import java.time.ZoneId;
import java.time.ZonedDateTime ;
import java.time.format.DateTimeFormatter ;

public class DateTransformations {

    /**
     * ChangeTimeZone: Date, Convert date string between UTC and a specific timezone
     * 
     * 
     * {talendTypes} Date
     * 
     * {Category} User Defined
     * 
     * {param} string("Date") input: The date as String that needs to be converted.
     * 
     * {example} ChangeTimeZone("2016-11-10 23:00", "yyyy-MM-dd HH:mm", "Europe/Zurich") # hello world !.
     */
	   public static Date ChangeTimeZone(String DateAsString, String DateFormat, String TimeZoneOutput) {
		   DateTimeFormatter formatter =
	               DateTimeFormatter.ofPattern(DateFormat);
		   
		   ZonedDateTime VarDate = ZonedDateTime.parse(DateAsString, formatter);
		            
	       return Date.from(  ( VarDate.withZoneSameInstant( ZoneId.of(TimeZoneOutput)) ).toInstant() );  	   
	   }    
}
