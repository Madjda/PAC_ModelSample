package application;

public abstract class ControleurFils {
	
	
	// Pour mettre a jours les autres controlleurs par le pere 
	public abstract void notifyParent(int cas); 
	
	
	// Pour effectuer les differents traitements sur la vue
	public abstract void control(int cas); 
	


}
