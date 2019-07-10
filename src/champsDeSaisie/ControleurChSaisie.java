package champsDeSaisie;

import application.ControleurFils;
import p�re.ControleurP�re;

public class ControleurChSaisie extends ControleurFils {
	
	    private  AbstractionChSaisie model;
	    private Pr�sentationChSaisie vue;
	    private ControleurP�re controller;
	    
	    
	    public ControleurChSaisie(ControleurP�re ctrl){
	        this.model=new AbstractionChSaisie(0);
	        this.vue=new Pr�sentationChSaisie("0");
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

	public Pr�sentationChSaisie getVue() {
		return vue;
	}

	public void setVue(Pr�sentationChSaisie vue) {
		this.vue = vue;
	}

	@Override
	public void control(int cas) {
		// TODO Auto-generated method stub
		this.model.setTemperature(Integer.parseInt(vue.getChamp().getText()));
		
	}

	public ControleurP�re getController() {
		return controller;
	}

	public void setController(ControleurP�re controller) {
		this.controller = controller;
	}

}
