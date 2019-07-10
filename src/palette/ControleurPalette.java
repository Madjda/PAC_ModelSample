package palette;

import application.ControleurFils;
import père.ControleurPère;


public class ControleurPalette extends ControleurFils {
 
	
	private AbstractionPalette model;
	private PrésentationPalette vue;
	private ControleurPère controller;

	
	@Override
	public void notifyParent(int cas) {
		// TODO Auto-generated method stub
		switch (cas)
    	{
    		case 1 :
    			controller.augmenter();
    		break;
    		case 2 : 
    			controller.diminuer();
    		break;
    		case 3 :
    			controller.remiseZero();
    		break;
    		case 4 :
    			controller.afficherTable();
    		break;
    	}
	}

	@Override
	public void control(int cas) {
		// TODO Auto-generated method stub
		 switch (cas)
	        {
	            case 1:augmenter();
	                break;
	            case 2:diminuer();
	                break;
	            case 3:remiseAzero();
	                break;
	        }
	}
	


    public PrésentationPalette getVue() {
		return vue;
	}

	public void setVue(PrésentationPalette vue) {
		this.vue = vue;
	}

	public ControleurPère getController() {
		return controller;
	}

	public void setController(ControleurPère controller) {
		this.controller = controller;
	}

	public  ControleurPalette(ControleurPère ctrl){
        this.model=new AbstractionPalette(0);
        this.vue=new PrésentationPalette();
        this.controller = ctrl;
        this.vue.setController(this);
    }
    
   


    public void remiseAzero() {
        this.model.setTemperature(0);
    }
    private void diminuer() {
        this.model.setTemperature(this.model.getTemperature()-10);
    }
    private void augmenter() {
        this.model.setTemperature(this.model.getTemperature()+10);
    }
    
    
    public void setTemperature(int a)
    {
    	this.model.setTemperature(a);
    }
    
    public int getTemperature()
    {
    	return this.model.getTemperature();
    }

    
}
