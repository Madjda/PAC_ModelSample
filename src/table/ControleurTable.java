package table;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import père.ControleurPère;

public class ControleurTable {
private AbstractionTable model;
private PrésentationTable vue;
private ControleurPère ctrP;


public ControleurTable(ControleurPère ctrl) {
this.model = new AbstractionTable(0);
this.vue = new PrésentationTable();
this.ctrP = ctrl;
this.vue.setCtrl(this);
}


public void notifyPere(int a) {

//we re not making changement on this table yet to notify the parent
}

public void control(ObservableList<ControleurPère.TemperatureAndModification> data) {
TableColumn modif = new TableColumn("Modification");
modif.setCellValueFactory(new PropertyValueFactory<>("modification"));
TableColumn temperature = new TableColumn("Température");
temperature.setCellValueFactory(new PropertyValueFactory<>("temperature"));
vue.tableauDonnees.setItems(data);
System.out.println(data);
vue.tableauDonnees.getColumns().addAll(modif, temperature);
vue.tableauDonnees.setMaxWidth(170);

}

public PrésentationTable getVue() {
return vue;
}


}
