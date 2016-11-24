package routines;

import java.util.Date ;
import java.time.ZoneId;
import java.time.ZonedDateTime ;
import java.time.format.DateTimeFormatter ;

public class DateTransformations {

    /**
     * ChangeTimeZone: Date, Convert date string between time zones
     * 
     * 
     * {talendTypes} Date
     * 
     * {Category} User Defined
     * 
     * {param} string("Date") input: The string date need to be converted.
     * 
     * {example} helloExemple("world") # hello world !.
     */
	   public static Date ChangeTimeZone(String DateAsString, String DateFormat, String TimeZoneOutput) {
		   DateTimeFormatter formatter =
	               DateTimeFormatter.ofPattern(DateFormat);
		   
		   ZonedDateTime VarDate = ZonedDateTime.parse(DateAsString, formatter);
		            
	       return Date.from(  ( VarDate.withZoneSameInstant( ZoneId.of(TimeZoneOutput)) ).toInstant() );  
		   
	   }
   
    
}
