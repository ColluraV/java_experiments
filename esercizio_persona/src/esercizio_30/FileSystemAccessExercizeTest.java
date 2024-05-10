package esercizio_30;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class FileSystemAccessExercizeTest {
	static File file= new File("text.txt");
	static FileSystemAccessExercize fsaInvalidpath=new FileSystemAccessExercize("non\\esiste\\questo\\path");
	static FileSystemAccessExercize fsaNamepath=new FileSystemAccessExercize("C:\\Users\\Rubbit\\git\\repository\\esercizio_persona\\test_write.txt");
	static FileSystemAccessExercize fsafile=new FileSystemAccessExercize(file);
	static FileSystemAccessExercize fsDir = new FileSystemAccessExercize("C:\\Users\\Rubbit\\git\\repository\\esercizio_persona");


	@Test
	void testSetFileNamePath() throws FileSystemAccessError {
		String filePath="indirizzo\\non\\valido";
		fsaInvalidpath.setFileNamePath(filePath);
		assertEquals(filePath,fsaInvalidpath.getFilePath());
		
	}

	@Test
	void testGetFileName() {
		assertEquals(fsafile.getFileName(), "text.txt", "text.txt");
		assertNotEquals(fsafile.getFileName(), "text2.txt");

	}

	@Test
	void testGetFilePath() {
		fsaNamepath=new FileSystemAccessExercize("C:\\Users\\Rubbit\\git\\repository\\esercizio_persona\\test_write.txt");
		assertEquals(fsaNamepath.getFilePath(),"C:\\Users\\Rubbit\\git\\repository\\esercizio_persona\\test_write.txt");
	}

	@Test
	void testGetFileCurrent() {
        Optional<File> fileOptional = fsafile.getFileCurrent();
        assertTrue("L'Optional dovrebbe essere pieno", fileOptional.isPresent());
        assertNotNull("Il file restituito non dovrebbe essere null", fileOptional.get());
	}

	@Test
	void testGetFileCurrent2() {
		FileSystemAccessExercize fNull= new FileSystemAccessExercize();
        Optional<File> fileOptional = fNull.getFileCurrent();
        assertEquals(null, fileOptional);
        }

	@Test
	void testIsFile() {
		assertEquals(fsaNamepath.isFile(), true);
		assertEquals(fsDir.isFile(), false);
	}

	@Test
	void testIsDirectory() {
		assertEquals(fsDir.isDirectory(), true);
		assertEquals(fsaNamepath.isDirectory(), false);
	}

	@Test
	void testIsHidden() {
		fail("Not yet implemented");
	}

	@Test
	void testIsWriteble() {
		assertEquals(fsaNamepath.isWriteble(), true);
	}

	@Test
	void testIsReadeble() {
		assertEquals(fsaNamepath.isReadeble(), true);
	}

	@Test
	void testFolderOwner() {
		fail("Not yet implemented");
	}

	@Test
	void testFolderFilesName() {
		fail("Not yet implemented");
	}

	@Test
	void testFileSize() {
		fail("Not yet implemented");
	}

	@Test
	void testFileSizeNested() {
		fail("Not yet implemented");
	}

	@Test
	void testMkDirFile() {
		fail("Not yet implemented");
	}

	@Test
	void testMkDirString() {
		fail("Not yet implemented");
	}

	@Test
	void testExists() {
		assertEquals(fsaNamepath.isWriteble(), true);
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testEmptyDir() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteDir() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteDirFile() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteDirString() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testDirNested() {
		fail("Not yet implemented");
	}

	@Test
	void testDirParents() {
		fail("Not yet implemented");
	}

}
