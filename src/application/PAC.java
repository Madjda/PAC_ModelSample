package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import p�re.AbstractionP�re;
import p�re.ControleurP�re;
import p�re.Pr�sentationP�re;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class PAC extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pr�sentationP�re view =  new Pr�sentationP�re() ;
        AbstractionP�re abstraction_PAC = new AbstractionP�re(0);
        ControleurP�re control_PAC = new ControleurP�re(abstraction_PAC, view);
        view.setCtrl(control_PAC);
        
        control_PAC.control();
        view.setInterface();
        Scene scene = new Scene(view.border, 1000,500);

        primaryStage.setTitle("TP_PAC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
