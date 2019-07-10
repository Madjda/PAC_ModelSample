package champsDeSaisie;

public class AbstractionChSaisie {
	
	/**
	 * Model of the text field
	 */
	 private int temperature;
	 
	    public AbstractionChSaisie(int t){
	        this.temperature=t;
	    }

	    public void setTemperature(int temperature) {
	        this.temperature = temperature;
	    }

	    public int getTemperature() {
	        return temperature;
	    }

}
