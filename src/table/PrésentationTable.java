
package table;

import javafx.scene.control.TableView;

public class Pr�sentationTable {

public TableView tableauDonnees ;
private ControleurTable ctrl;

public Pr�sentationTable() {

tableauDonnees = new TableView();

}




public void setCtrl(ControleurTable ctrl) {
this.ctrl = ctrl;
}
}


