package palette;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class PrésentationPalette {

	private Button diminuer;
    private Button augmenter;
    private Button miseAzero;
    private Button afficherTableau;
    
    public Button getAfficherTableau() {
		return afficherTableau;
	}

	public void setAfficherTableau(Button afficherTableau) {
		this.afficherTableau = afficherTableau;
	}

	private ControleurPalette controller;
    
    public PrésentationPalette(){
        this.diminuer = new Button("Diminuer");
        this.augmenter = new Button("Augmenter");
        this.miseAzero = new Button("Mise a zero");
        this.afficherTableau = new Button("Afficher Tableau");
        
              
        this.augmenter.setOnAction(new EventHandler<ActionEvent>() {
          	 @Override
               public void handle(ActionEvent e) {
                 
          		controller.notifyParent(1);
          	 }
        }
          );
        
        
        
        this.diminuer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e)
            {
            	controller.notifyParent(2);
            }

        } );
        
        this.miseAzero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e)
            {
            	controller.notifyParent(3);
            }

        });
        
        this.afficherTableau.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        	controller.notifyParent(4);
        	}

        });
    }

	public Button getDiminuer() {
		return diminuer;
	}

	public void setDiminuer(Button diminuer) {
		this.diminuer = diminuer;
	}

	public Button getAugmenter() {
		return augmenter;
	}

	public void setAugmenter(Button augmenter) {
		this.augmenter = augmenter;
	}

	public Button getMiseAzero() {
		return miseAzero;
	}

	public void setMiseAzero(Button miseAzero) {
		this.miseAzero = miseAzero;
	}

	public ControleurPalette getController() {
		return controller;
	}

	public void setController(ControleurPalette controller) {
		this.controller = controller;
	}
   }
