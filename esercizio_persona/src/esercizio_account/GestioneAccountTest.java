package esercizio_account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import esercizio_ReadAndSort.SortWordsDaFile;

class GestioneAccountTest {

	static GestioneAccount gAcc;
	@Test
	void GestioneAccount() {
		gAcc =new GestioneAccount("accounts.txt");
		System.out.println("stop");
		}
		
	@Test
	void existsUserTest() {
		gAcc =new GestioneAccount("accounts.txt");
		gAcc.existsUser("U001");
		
	}
	

}
