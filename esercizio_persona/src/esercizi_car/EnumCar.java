package esercizi_car;

public enum EnumCar {
	   AUDI("TT", "RS6"),
	   VW(),
	   CITROEN("Ami", "Berlingo", "C3"),
	   FIAT("Panda", "Punto", "500e"),
	   TOYOTA("Supra","Yaris","Gt86","Corolla"),
	   SEAT(),
	   PEUGEOT();
	
	

	   private String[] arModels;
	 


	   EnumCar(String ... models ) {
	       this.arModels = models;
	   }


	    public String[] getNameModels() {
	        return this.arModels;

	    }

	}
