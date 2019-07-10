
package table;

import javafx.scene.control.TableView;

public class PrésentationTable {

public TableView tableauDonnees ;
private ControleurTable ctrl;

public PrésentationTable() {

tableauDonnees = new TableView();

}




public void setCtrl(ControleurTable ctrl) {
this.ctrl = ctrl;
}
}


