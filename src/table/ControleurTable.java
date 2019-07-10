package table;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import p�re.ControleurP�re;

public class ControleurTable {
private AbstractionTable model;
private Pr�sentationTable vue;
private ControleurP�re ctrP;


public ControleurTable(ControleurP�re ctrl) {
this.model = new AbstractionTable(0);
this.vue = new Pr�sentationTable();
this.ctrP = ctrl;
this.vue.setCtrl(this);
}


public void notifyPere(int a) {

//we re not making changement on this table yet to notify the parent
}

public void control(ObservableList<ControleurP�re.TemperatureAndModification> data) {
TableColumn modif = new TableColumn("Modification");
modif.setCellValueFactory(new PropertyValueFactory<>("modification"));
TableColumn temperature = new TableColumn("Temp�rature");
temperature.setCellValueFactory(new PropertyValueFactory<>("temperature"));
vue.tableauDonnees.setItems(data);
System.out.println(data);
vue.tableauDonnees.getColumns().addAll(modif, temperature);
vue.tableauDonnees.setMaxWidth(170);

}

public Pr�sentationTable getVue() {
return vue;
}


}
