package net.aydini.mom.util.string;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 27, 2021
 */
public class StringUtil
{
    
    public static String toLowerFirstLetter(String string)
    {
        if (string == null ) throw new NullPointerException("empty string");
        else if (string.isEmpty()) return string;
        else if (string.length() == 1) return string.toLowerCase();
        else return Character.toLowerCase(string.charAt(0)) + string.substring(1);
    }
    
    
    public static String toUpperFirstLetter(String string)
    {
        if (string == null ) throw new NullPointerException("empty string");
        else if (string.isEmpty()) return string;
        else if (string.length() == 1) return string.toUpperCase();
        else return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }

}
