package p�re;

import application.ControleurP�re;
import champsDeSaisie.ControleurChSaisie;
import champsDeSaisie.Pr�sentationChSaisie;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.StackPane;
import palette.ControleurPalette;
import palette.Pr�sentationPalette;
import table.ControleurTable;
import table.Pr�sentationTable;

public class ControleurP�re extends ControleurP�re {
	
	private AbstractionP�re model;
    private Pr�sentationP�re vue;

    private ControleurChSaisie control_ChampSaisie;
    private ControleurPalette control_PaletteOutils;
    private ControleurTable control_Table;



    private Series series;
    
    private ObservableList<TemperatureAndModification> data =
            FXCollections.observableArrayList(new TemperatureAndModification("0","0") );

    
    
    

    /* Le constructeur */
    public ControleurP�re(AbstractionP�re model, Pr�sentationP�re vue ){
        this.model = model;
        this.vue = vue;
        this.series=new XYChart.Series();
        this.series.setName("temp�rature apr�s modification");

    }
    
    
    public Pr�sentationChSaisie getPresentationCh()
    {
    	return control_ChampSaisie.getVue();
    }
    
    
    public Pr�sentationPalette getPresentationPalette()
    {
    	return control_PaletteOutils.getVue();
    }
    
    public Pr�sentationTable getPresentationPTable()
    {
    return control_Table.getVue();
    }
    
    private void update(){
    	 model.setTemperature(control_PaletteOutils.getTemperature());//lors du changement on notifie l'agent pere qui est ici le model
         control_ChampSaisie.setTemperature(model.getTemperature());//et le model notifie les autre agents
         this.getPresentationCh().setChamp(String.valueOf(model.getTemperature()));//On met à jour notre vue à partir de son model associé
    	  System.out.println(series.getData());
          vue.lineChart = new LineChart(vue.xAxis,vue.yAxis);
          vue.lineChart.getData().add(series);
          series.getData().add(new XYChart.Data(series.getData().size(), model.getTemperature()));
          System.out.println(series.getData());
          vue.lineChart.setTitle("TP PAC");
          
        vue.pane = new StackPane();
        vue.pane.getChildren().add(vue.lineChart);
        vue.border.setCenter(vue.pane);

        data.add(new TemperatureAndModification(String.valueOf(model.getTemperature()),String.valueOf(series.getData().size())));
    }


	@Override
	public void control() {
	
		        control_ChampSaisie=new ControleurChSaisie(this);
		        control_PaletteOutils=new ControleurPalette(this);
		        control_Table=new table.ControleurTable(this);
		        control_PaletteOutils.control(3);
		        
		        
		        this.getPresentationCh().getChamp().setDisable(false);
		      this.getPresentationCh().getChamp().textProperty().addListener(new ChangeListener<String>() {
		        
		            @Override
		            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		                if(control_ChampSaisie.getVue().getChamp().isFocused()){


		                }

		            }
		        });

		   
		
	}
	
	public AbstractionP�re getModel() {
		return model;
	}


	public void setModel(AbstractionP�re model) {
		this.model = model;
	}


	public ObservableList<TemperatureAndModification> getData() {
		return data;
	}


	public void setData(ObservableList<TemperatureAndModification> data) {
		this.data = data;
	}


	public void augmenter()
    {
    	control_PaletteOutils.control(1);//L'opération 1:Augmenter la température
       


         update();
    }
    
    public void diminuer()
    {
        control_PaletteOutils.control(2);//L'opération 2:Diminuer la température
        
         update();
    }
    
    
    public void remiseZero()
    {
        control_PaletteOutils.control(3);//L'opération 3:Mettre à 0 la température
       
        update();
    }

	public Pr�sentationP�re getVue() {
		return vue;
	}

	public void setVue(Pr�sentationP�re vue) {
		this.vue = vue;
	}

	public ControleurChSaisie getControl_ChampSaisie() {
		return control_ChampSaisie;
	}

	public void setControl_ChampSaisie(ControleurChSaisie control_ChampSaisie) {
		this.control_ChampSaisie = control_ChampSaisie;
	}

	public ControleurPalette getControl_PaletteOutils() {
		return control_PaletteOutils;
	}

	public void setControl_PaletteOutils(ControleurPalette control_PaletteOutils) {
		this.control_PaletteOutils = control_PaletteOutils;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}
	
	
	 public static class TemperatureAndModification{
		 
	        private final SimpleStringProperty temperature;
	        private final SimpleStringProperty modification;
	        private TemperatureAndModification(String T, String M) {
	            this.temperature = new SimpleStringProperty(T);
	            this.modification = new SimpleStringProperty(M);
	        }


	        public String getTemperature() {
	            return temperature.get();
	        }

	        public String getModification() {
	            return modification.get();
	        }
	   }
	 
	  
	    public void onChangeSaisie()
	    {
	    	 control_ChampSaisie.control(0);//n prend la valeur de la Temperature depuis la vue et on la met dans le model
	         model.setTemperature(control_ChampSaisie.getTemperature());//On notifie le père de l'agent (le model de la fenêtre principale)
	         control_PaletteOutils.setTemperature(model.getTemperature());//et le model àson tour notifie les autres agents

	         vue.lineChart=new LineChart(vue.xAxis,vue.yAxis);
	         System.out.println(series.getData());
	         series.getData().add(new XYChart.Data(series.getData().size(), model.getTemperature()));
	         System.out.println(series.getData());
	         vue.lineChart.getData().add(series);
	         vue.lineChart.setTitle("TP PAC");
	         vue.pane = new StackPane();
	         vue.pane.getChildren().add(vue.lineChart);
	         vue.border.setCenter(vue.pane);
	         data.add(new TemperatureAndModification(String.valueOf(model.getTemperature()),String.valueOf(series.getData().size())));
	    }
	    
	    public void afficherTable()
	    {
		control_Table.control(data);
	    vue.paneTableauDeDonnees = new StackPane();
	    vue.paneTableauDeDonnees.getChildren().add(getPresentationPTable().tableauDonnees);
	    vue.border.setLeft(vue.paneTableauDeDonnees);
	    }

}
