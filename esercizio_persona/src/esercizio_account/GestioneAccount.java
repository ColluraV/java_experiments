package esercizio_account;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import esercizio_ReadAndSort.EnumSortType;

public class GestioneAccount implements Account<User> {
	File file;
	Scanner scnLine;
	Scanner scnString;
	String line;
	String stringScan;
	List<String> strings;
	Map<String, User> mapAccounts = new HashMap<String, User>();
	Set<String> eMails = new HashSet<String>();
	Set<String> orderedUsers;
	List<String> wrongRows;
	List<String> rightRows;
	GestioneAccount(String fileName) {
		//User user = new User();
		file = new File(fileName);
		try {
			scnLine = new Scanner(file);
			strings = new ArrayList<String>();

			// leggo la riga
			while (scnLine.hasNextLine()) {
				stringScan = scnLine.nextLine();
				scnString = new Scanner(stringScan);
				int stringCounter = 1;
				
				// leggo la stringa
				String userId = "";
				while (scnString.hasNext()) {
					stringCounter++;
					
					// salvo le stringhe
					String singString = scnString.next();
					strings.add(singString);

					userId = singString;
					//user.setIdUser(userId);

					if (stringCounter == 2 && singString.contains("@")) {
						eMails.add(singString);
						//user.addMail(singString);
					} else {
						singString = scnString.next();
						//user.setNome(singString);
					}
					stringCounter=0;
				}
				// mapAccounts.put(userId,User);
				System.out.println(mapAccounts);
				strings.clear();
			}
			// scnLine.nextLine();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean addUser(String idUser, String nome, String Cognome, String indirizzo) {
		
		return false;
	}

	@Override
	public boolean addMail(String idUser, String mail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsUser(String idUser) {
		
		if (mapAccounts.containsKey(idUser)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean userHasMail(String idUser) {
		// TODO Auto-generated method 
		if (existsUser(idUser) && userMails(idUser).length!=0) {
			return true;
		}
		return false;
	}

	@Override
	public Optional<User> user(String idUser) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public String[] userMails(String idUser) {
		

		return null;
	}

	@Override
	public User[] users(EnumSortType sortType) {
		
		Set<String> arUser = mapAccounts.keySet();
		
		if (sortType==EnumSortType.SORT_ASCENDING) {
			
			orderedUsers= new TreeSet<String>(arUser);
		}else {
//			orderedUsers=new TreeSet<String>(Comparator.reverseOrder());
			orderedUsers=new TreeSet<String>((o1, o2) -> o2.compareTo(o1));
		}
		return null;
	}

	@Override
	public User firstUser() {
		return users(EnumSortType.SORT_ASCENDING)[0];
	}

	@Override
	public User lastUser() {
		return  users(EnumSortType.SORT_ASCENDING)[0];
	}

	@Override
	public String[] discardedRows() {
		return (String[]) wrongRows.toArray();
	}

	@Override
	public String[] allMails() {
		return null;
	}

	@Override
	public User[] firstUsers(int numUsers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User[] lastUsers(int numUsers) {
		// TODO Auto-generated method stub
		return null;
	}

}
