package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import père.AbstractionPère;
import père.ControleurPère;
import père.PrésentationPère;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class PAC extends Application {

    @Override
    public void start(Stage primaryStage) {

        PrésentationPère view =  new PrésentationPère() ;
        AbstractionPère abstraction_PAC = new AbstractionPère(0);
        ControleurPère control_PAC = new ControleurPère(abstraction_PAC, view);
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
