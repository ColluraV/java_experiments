package Serializzazione_exercize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

public class ManageObjectPersistence{
	String fileName;
	
	ManageObjectPersistence(String fileName){
		this.fileName=fileName;
	}
	
	boolean persistObject(Animale obj) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
			output.writeObject(obj);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
		}
	
	Optional<Animale> getObject() throws ClassNotFoundException {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));

				return Optional.ofNullable((Animale) input.readObject());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
