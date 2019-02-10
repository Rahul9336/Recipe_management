package recipe_lab.dto;
/*
 * This Class Used for Change given String into CamelCase Form 
 * 
 * */
public class CamelCaseString {
	
	public String toCamelCase(final String input) {
	    if (input==null)
	        return null;

	    final StringBuilder ret = new StringBuilder(input.length());

	    for (final String word : input.split(" ")) {
	        if (!word.isEmpty()) {
	            ret.append(word.substring(0, 1).toUpperCase());
	            ret.append(word.substring(1).toLowerCase());
	        }
	        if (!(ret.length()==input.length()))
	            ret.append(" ");
	    }

	    return ret.toString();
	}
}
