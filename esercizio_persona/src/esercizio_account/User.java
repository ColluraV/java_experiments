package esercizio_account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Un generico account utente univoco, deve invece essere
 *  modellato dalla apposita classe User.
 *  La classe User modella informazioni (String) 
 *  quali idUser, nome, cognome e mail.
 *  La classe User, per gestire l’ordinamento deve
 *   implementare hashCode(), equals() 
 *   e le interfacce Comparator e Comparable 
 * 
 * */

public class User implements Comparable<User>{
	  private String idUser;
	    private String nome;
	    private String cognome;
	    private String indirizzo;
	    private List<String> mails;
	    
	    
		public User(String idUser, String nome, String cognome, String indirizzo) {
			super();
			this.idUser = idUser;
			this.nome = nome;
			this.cognome = cognome;
			this.indirizzo = indirizzo;
			mails=new ArrayList<String>();
		}

		
		public User(String idUser) {
			super();
			this.idUser = idUser;
			mails=new ArrayList<String>();
		}


		/**
		 * @return the nome
		 */
		public String getNome() {
			return nome;
		}
		/**
		 * @param nome the nome to set
		 */
		public void setNome(String nome) {
			this.nome = nome;
		}
		/**
		 * @return the cognome
		 */
		public String getCognome() {
			return cognome;
		}
		/**
		 * @param cognome the cognome to set
		 */
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		/**
		 * @return the indirizzo
		 */
		public String getIndirizzo() {
			return indirizzo;
		}
		/**
		 * @param indirizzo the indirizzo to set
		 */
		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}
		/**
		 * @return the mails
		 */
		public String[] getMails() {
			return (String[]) mails.toArray();
		}
		/**
		 * @param mails the mails to set
		 */
		public void addMail(String mail) {
			mails.add(mail);
		}
		
		public void setIdUser(String idUser) {
			this.idUser = idUser;
		}
		
		/**
		 * @return the idUser
		 */
		public String getIdUser() {
			return idUser;
		}
		@Override
		public int hashCode() {
			return Objects.hash(cognome, idUser, indirizzo, mails, nome);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(cognome, other.cognome) && Objects.equals(idUser, other.idUser)
					&& Objects.equals(indirizzo, other.indirizzo) && Objects.equals(mails, other.mails)
					&& Objects.equals(nome, other.nome);
		}
		
	
		
		@Override
		public String toString() {
			return "User [idUser=" + idUser + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo
					+ ", mails=" + mails + "]";
		}
		@Override
		
		public int compareTo(User o) {
			// TODO Auto-generated method stub
			return 0;
		}

	    

}
