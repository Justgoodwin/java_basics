public class Engine {

    private String engineType;//diesel,gasoline
    private double engineCapacity;// liters
    private double engineCompressionDegree; // kg/cm^2
    private int engineCylinders;

    public boolean getEngineTurbine() {
        return engineTurbine;
    }

    public void setEngineTurbine(boolean engineTurbine) {
        this.engineTurbine = engineTurbine;
    }

    private boolean engineTurbine = false;


    public Engine(String engineType) {
        this.engineType = engineType;
    }

    public String getEngineType(){
        return engineType;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public double getEngineCompressionDegree() {
        return engineCompressionDegree;
    }

    public void setEngineCompressionDegree(double engineCompressionDegree) {
        this.engineCompressionDegree = engineCompressionDegree;
    }

    public int getEngineCylinders() {
        return engineCylinders;
    }

    public void setEngineCylinders(int engineCylinders) {
        this.engineCylinders = engineCylinders;
    }


}
