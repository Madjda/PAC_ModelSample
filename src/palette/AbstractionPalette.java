package palette;

public class AbstractionPalette {
    private int temperature;

    public AbstractionPalette(int t){
        this.setTemperature(t);
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }



}
