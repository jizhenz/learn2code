/**
 * 
 */
package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jizhen Zhao
 *
 */
public class RegEx {
	
	public static boolean hasWhiteSpace(String s) {
		Pattern pattern = Pattern.compile("[\\s]+");
		Matcher m = pattern.matcher(s);
		return m.find();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(hasWhiteSpace("C:\\Program  Files\\Microsoft SQL Server\\110\\Tools\\Binn\\SQLCMD.EXE"));
		System.out.println(hasWhiteSpace("C:\\ProgramFiles\\MicrosoftSQLServer\\110\\Tools\\Binn\\SQLCMD.EXE"));
	}

}
