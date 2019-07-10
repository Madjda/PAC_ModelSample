package champsDeSaisie;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

	public class PrésentationChSaisie {
		
	    private TextField champ;
	    private Label label ;
	    private ControleurChSaisie controller;
	    
	    public ControleurChSaisie getController() {
			return controller;
		}

		public void setController(ControleurChSaisie controller) {
			this.controller = controller;
		}

		PrésentationChSaisie(String t){
	    	
	       this.champ = new TextField(t);
	       this.setLabel(new Label("Température (Celsius)"));
	       this.champ.textProperty().addListener(new ChangeListener<String>() {
	           
	           @Override
	           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	        	   
	        	   //mettre le parent au courant
	        	   controller.notifyParent(0);
	           }
	       });
	    }

		public TextField getChamp() {
			return champ;
		}

		public void setChamp(String string) {
			this.champ.setText(string);
		}

		public Label getLabel() {
			return label;
		}

		public void setLabel(Label label) {
			this.label = label;
		}

	   
	}
