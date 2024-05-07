package io_reader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteDataOutputStream {

	public static void main(String[] args) throws IOException {
		writer();
		reader();
	}

	static void writer() throws IOException {
		double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
		int[] units = { 12, 8, 13, 29, 50 };
		String[] descs = { "T-shirt", "Mug", "Duke", "Pin", "Key-Chain" };
		DataOutputStream out = new DataOutputStream(new FileOutputStream("fatturaNonChar.dat"));

		for (int i = 0; i < descs.length; i++) {
			out.writeDouble(prices[i]);
			out.writeInt(units[i]);
			out.writeChars(descs[i]);
			out.writeChars(System.getProperty("line.separator"));

		}
		out.flush();
		out.close();
	}

	static void reader() throws IOException {
		double price;
		int unit;
		char sChar;
		String separator = System.getProperty("line.separator");

		try (DataInputStream ds = new DataInputStream(new FileInputStream("fatturaNonChar.dat"))) {
			while (ds.available() > 0) {
				StringBuilder sb = new StringBuilder();
				price = ds.readDouble();
				unit = ds.readInt();

				while ((sChar = ds.readChar()) != separator.charAt(0)) {
					sb.append(sChar);
				}

				if (separator.length() > 1) {
					ds.readChar();
				}
				ds.close();
				System.out.println("prezzo:"+price + " quantità" + unit + " articolo:" + sb.toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
