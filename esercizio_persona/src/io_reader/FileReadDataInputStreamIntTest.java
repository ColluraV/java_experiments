package io_reader;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Frame;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileReadDataInputStreamIntTest {
	static FileReadDataInputStreamInt fR;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		fR=new FileReadDataInputStreamInt();
	}


	@Test
	void testDataPrinter() throws IOException {
		fR.dataPrinter();
	}

}
