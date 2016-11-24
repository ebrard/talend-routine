package routines;

import routines.StringHandling ;
import java.util.Arrays ; 

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
public class StringHandlingExtended {

    /**
     * RemoveParentheses: String return value, remove parentheses in String
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("(world)") input: The string need processed.
     * 
     * {example} RemoveParentheses("(world)") # world
     */
    public static String RemoveParentheses(String message) {
        if (message == null) {
            message = null ; 
        }
        else {
        	message = StringHandling.TRIM( message.replace("(","").replace(")", "") ) ;
        }
        return message ;
    }

    /**
     * CountElementInStringList: int return value, count number of element in string list
     * 
     * 
     * {talendTypes} int
     * 
     * {Category} User Defined
     * 
     * {param} string("1;2;3") input: The string needing processing
     * 
     * {example} CountElementInStringList("1;2;3") # 3
     */
    public static int CountElementInStringList(String field, String separator) {

        return (Arrays.asList(field.split(separator))).size() ;
        
     }

    /**
     * SortSeparatedField: String return value, Order String list with a separator
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("2;1") input: The string need processed.
     * 
     * {example} SortSeparatedField("2;1") # "1;2"
     */
    public static String SortSeparatedField(String field, String separator) {
    	  
  	String[] ArrayField = field.split(separator) ;
      	Arrays.sort(ArrayField) ;
      	return String.join(separator, ArrayField) ; 
    }
    
    /**
     * ReplaceMissing: String return value, replace missing value for string field by missing_value_string
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("a field example") input: The string need to be processed.
     * 
     * {example} ReplaceMissing(" ", "missing") # "missing"
     */   
    public static String ReplaceMissing(String field, String missing_value_string) {    	    
    	    if (field == null) { 
    	      field = missing_value_string ; 
    	    } 
    	    else if (!field.matches(".*\\S.*") ) {
    	      field = missing_value_string ;
    	    }
    	    else if ( RemoveParentheses(field).equals("not set")) {
    	    	field = missing_value_string ; 
    	    }
    	    else if ( field.equals( "(not set)" ) ) {
    	    	field = missing_value_string ;
    	    }
    	    
    	 return field.trim() ;   
    }

    /**
     * ReplaceMissing: String return value, replace missing value for string field by "not set"
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("a field example") input: The string need to be processed.
     * 
     * {example} ReplaceMissing(" ") # "not set"
     */ 
    public static String ReplaceMissing(String field) {
    	return ReplaceMissing(field, "not set") ;
    }
    
}
