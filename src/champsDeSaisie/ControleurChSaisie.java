package champsDeSaisie;

import application.ControleurFils;
import père.ControleurPère;

public class ControleurChSaisie extends ControleurFils {
	
	    private  AbstractionChSaisie model;
	    private PrésentationChSaisie vue;
	    private ControleurPère controller;
	    
	    
	    public ControleurChSaisie(ControleurPère ctrl){
	        this.model=new AbstractionChSaisie(0);
	        this.vue=new PrésentationChSaisie("0");
	        this.setController(ctrl);
	        this.vue.setController(this);
	    }

	@Override
	public void notifyParent(int cas) {
		// TODO Auto-generated method stub
		if(vue.getChamp().isFocused()){
	   	    controller.onChangeSaisie();
	      }
		
	}
	 public int getTemperature()
	    {
	    	return model.getTemperature();
	    }
	    

	    public void setTemperature(int temperature) {
	        this.model.setTemperature(temperature);
	    }
	    
	public AbstractionChSaisie getModel() {
		return model;
	}

	public void setModel(AbstractionChSaisie model) {
		this.model = model;
	}

	public PrésentationChSaisie getVue() {
		return vue;
	}

	public void setVue(PrésentationChSaisie vue) {
		this.vue = vue;
	}

	@Override
	public void control(int cas) {
		// TODO Auto-generated method stub
		this.model.setTemperature(Integer.parseInt(vue.getChamp().getText()));
		
	}

	public ControleurPère getController() {
		return controller;
	}

	public void setController(ControleurPère controller) {
		this.controller = controller;
	}

}
