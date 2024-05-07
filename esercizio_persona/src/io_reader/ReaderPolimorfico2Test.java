package io_reader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReaderPolimorfico2Test {
	static ReaderPolimorfico2 rp2;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		rp2 = new ReaderPolimorfico2();
	}

	@Test
	void test() throws IOException {
		rp2.run();;
	}

}
