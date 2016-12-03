# talend-routine
A collection of Talend "routines" in Java 8.

## DateTransformations
A collection of additional functions to handle dates with Talend.

* ChangeTimeZone : Transform date from UTC to a specific time zone.

## StringHandlingExtended
A collection of functions to transform string (VARCHAR) type input variables/fields.

* RemoveParentheses: remove opening and closing parentheses from input string.
* CountElementInStringList: count the number of elements in a List string such as: "a;g;b;h;" -> 4 (useful for bridge table creation).
* SortSeparatedField: sort elements in a List string such as: "1,2,5,4,0" -> "0,1,2,4,5" (useful for bridge table creation).
* ReplaceMissing: Replace missing value in a field String by the specified value. Replace NULL type, blank, whitespace-filled string field and "not set" value.

## KeyValueField
A class contained set of functions to handle key value parsing from string variables/fields.

* ParseKeyValueField: Parse the content of a key values input String variable/field. Return a Map type variable. This Map can be used with the standard Java .get() method. In case of multiple identical keys, the last value is kept. e.g.: ParseKeyValueField("My field|CH=Online","|","=").get("CH") -> Online
