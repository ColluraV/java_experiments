package esempiVari.scanner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScanFileNamesTest {
	ScanFileNames sfs = new ScanFileNames();
	
	@Test
	void fileRight() {
		assertTrue(sfs.solution("1998-08-29 956 system.zip").equals("NO FILES"));
	}

	@Test
	void filesFormallyRight() {
		String s  = "1998-08-29 956 system.zip " 
				  + "1995-10-12 245760 old-photos.tgz " 
				  + "1994-12-01 845 very-long-filename.rar " 
                  ;
		assertTrue(sfs.solution(s).equals("2"));
	}

	@Test
	void fileWrongDataAbsent() {
		assertTrue(sfs.solution("956 system.zip").equals("INPUT INVALID"));
	}

	@Test
	void fileWrongDataYear() {
		assertTrue(sfs.solution("1A98-08-29 956 system.zip").equals("INPUT INVALID"));
	}

	@Test
	void fileWrongDataMonth() {
		assertTrue(sfs.solution("1998-A8-29 956 system.zip").equals("INPUT INVALID"));
	}

	@Test
	void fileWrongDataDay() {
		assertTrue(sfs.solution("1998-08-DD 956 system.zip").equals("INPUT INVALID"));
	}

	@Test
	void fileWrongSize() {
		assertTrue(sfs.solution("1998-08-29 9A6 system.zip").equals("INPUT INVALID"));
	}

	@Test
	void fileRightExt() {
		assertTrue(sfs.solution("1998-08-29 956 system.zip").equals("NO FILES"));
		assertTrue(sfs.solution("1998-08-29 956 system.tgz").equals("NO FILES"));
		assertTrue(sfs.solution("1998-08-29 956 system.rar").equals("NO FILES"));
	}

	@Test
	void fileWrongExt() {
		assertTrue(sfs.solution("1998-08-29 956 system.txt").equals("INPUT INVALID"));
		assertTrue(sfs.solution("1998-08-29 956 system.zip.txt").equals("INPUT INVALID"));
	}

	@Test
	void noInputFiles() {
		assertTrue(sfs.solution("").equals("NO FILES"));
	}

}
