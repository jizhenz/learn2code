/**
 * 
 */
package volume_I.chapter02;

/**
 * @author jizhen
 *
 */
public class Welcom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] greeting = new String[3];
		greeting[0] = "Welcom to Core Java";
		greeting[1] = "by Cay Horsmann";
		greeting[2] = "and Gary Cornell!!";
		
		for (String g : greeting) {
			System.out.println(g);
		}
	}

}
