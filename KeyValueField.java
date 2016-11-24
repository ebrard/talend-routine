package routines;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static java.util.stream.Collectors.*;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class KeyValueField {

    /**
     * KeyValueField: Compute and Map structure to be able to retrieve a key
     * 
     * 
     * {talendTypes} Map
     * 
     * {Category} User Defined
     * 
     * {param} string("field") input: The string need to be parsed and key extracted.
     * 
     * {example} KeyValueField("FACEBOOK|GO=ROMI|CH=Facebook Ads").get("CH") # Facebook Ads
     */

    public static Map<String, String> ParseKeyValueField(String field, String separator, String assignSymbol) {
        if (field == null || field == " " || field == "") {
            return Collections.emptyMap() ; 
        }
        else if (field.indexOf("|") == -1) {
        	return Collections.emptyMap() ;
        }
        else
        {        
          // Remove n-le separators (example: |||)
          field = field.replaceAll("\\|{2,10}", "|") ;
          
          // Remove leading separator
          if ( field.charAt(0) == '|' ) {
          field = field.substring(1) ;
          }         
                    
          Map<String, String> KeyValueMap = Arrays.stream(field.split(separator))
            	.filter(s -> s.indexOf(assignSymbol) != -1 ) // We skip string without the assignSymbol
                .map(s -> s.split(assignSymbol))
                .collect(toMap(
                    a -> a[0].trim(),  // key
                    a -> a[1].trim(), // value
                    (p1, p2) -> p2 // If duplicates take last
                ));    
          return KeyValueMap ;
        }   
    }

}
