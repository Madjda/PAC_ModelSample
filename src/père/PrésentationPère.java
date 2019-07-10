package père;

import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PrésentationPère {
	public StackPane pane;
    public BorderPane border;
    public LineChart  lineChart;
    public NumberAxis xAxis;
    public NumberAxis yAxis;
    public TableView tableauDonnees = new TableView();
    public StackPane paneTableauDeDonnees;

    private ControleurPère ctrlFenPrin;

    
    public void setCtrl(ControleurPère  ctrl)
    {
    	this.ctrlFenPrin = ctrl;
    }

    

    public void setInterface ()
    {
        Button augmenter=this.ctrlFenPrin.getPresentationPalette().getAugmenter();
        Button diminuer=this.ctrlFenPrin.getPresentationPalette().getDiminuer();
        Button miseAzero=this.ctrlFenPrin.getPresentationPalette().getMiseAzero();
        Button affichertableau=this.ctrlFenPrin.getPresentationPalette().getAfficherTableau();
        
        VBox.setMargin(augmenter, new Insets(10,20,0,0));
        VBox.setMargin(diminuer, new Insets(0,20,0,0));
        VBox.setMargin(miseAzero, new Insets(0,20,0,0));


        TextField champSaisie = this.ctrlFenPrin.getPresentationCh().getChamp();
       // champSaisie.setStyle("-fx-width: 50 px ;-fx-height: 50 px; -fx-font-size:20px");
        champSaisie.setPrefWidth(50);
        champSaisie.setPrefHeight(50);;
        champSaisie.setEditable(false);
        Label lab = this.ctrlFenPrin.getPresentationCh().getLabel();


      
        HBox.setMargin(champSaisie, new Insets(10,0,20, 190));

        VBox vboxP = new VBox(20);
        augmenter.setStyle("-fx-background-color :red  ; -fx-text-color: white;  -fx-base : red;-fx-pref-width: 100px ");
        diminuer.setStyle("-fx-text-color: white;  -fx-base : blue;-fx-pref-width: 100px");
        miseAzero.setStyle("-fx-pref-width: 100px");
        affichertableau.setStyle("-fx-pref-width: 100px");
        vboxP.getChildren().addAll(lab,champSaisie,augmenter, diminuer, miseAzero,affichertableau);

        border = new BorderPane();border.setPadding(new Insets(10,10,10,10));
        border.setRight(vboxP);
        //Defining X axis
        xAxis = new NumberAxis(0, 20, 1);
        xAxis.setLabel("Modifications");

        //Defining y axis
        yAxis = new NumberAxis(0, 500, 10);
        yAxis.setLabel("Températures");
        LineChart linechart = new LineChart(xAxis, yAxis);
        linechart.setTitle("TP PAC");


        pane = new StackPane();
        pane.getChildren().add(linechart);
        border.setCenter(pane);


        tableauDonnees.setEditable(true);

    }

}
