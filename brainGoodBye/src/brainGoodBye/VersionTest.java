package brainGoodBye;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

/**
 * @author Joey Hunt
 *
 * Tests the Version class for proper functionality.
 */
public class VersionTest {

	/**
	 * Test method for {@link brainGoodBye.Version#setVersion()}.
	 */
	@Test
	public void testSetVersion() {
		StringBuilder version1 = new StringBuilder();
		
		File file = new File("version.txt");
		try {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				version1.append(scanner.nextLine());
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Version.setVersion();
		
		String version2 = Version.getVersion();
		
		assertEquals("The file version.txt was not read correctly!", version1.toString(), version2);
	}

}
