/**
 * 
 */
package nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Jizhen Zhao
 *
 */
public class TestPath {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Path f = Paths.get("C:/Users/u343266/Documents/tmp/MCR-7059-DBDeploy/SqlScript_Rel_148/RUN_1/MARS/010_HuanhuaPan_MCR-6535_RS_Changes.sql");
		System.out.println(f.getFileName());
		System.out.println(f.getName(f.getNameCount()-1));
		System.out.println(f.getFileSystem());
		System.out.println(f.getParent());
		System.out.println(f.getRoot());
	}

}
