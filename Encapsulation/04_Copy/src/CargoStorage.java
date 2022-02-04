public class CargoStorage {
    private final Dimensions dimensions;
    private final double cargoMass;
    private final String cargoDestination;
    private final boolean cargoCanFlip;
    private final String cargoRegistrationNumber;//can contain letters
    private final boolean cargoIsFragile;

    public CargoStorage() {
        dimensions = new Dimensions();
        cargoMass = 0;
        cargoDestination = "N/A";
        cargoCanFlip = false;
        cargoRegistrationNumber = "N/A";
        cargoIsFragile = false;
    }

    public CargoStorage(
            Dimensions dimensions,
            double cargoMass,
            String cargoDestination,
            boolean cargoCanFlip,
            String cargoRegistrationNumber,
            boolean cargoIsFragile) {
        this.dimensions = dimensions;
        this.cargoMass = cargoMass;
        this.cargoDestination = cargoDestination;
        this.cargoCanFlip = cargoCanFlip;
        this.cargoRegistrationNumber = cargoRegistrationNumber;
        this.cargoIsFragile = cargoIsFragile;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getCargoMass() {
        return cargoMass;
    }

    public String getCargoDestination() {
        return cargoDestination;
    }

    public boolean getIsCargoCanFlip() {
        return cargoCanFlip;
    }

    public String getCargoRegistrationNumber() {
        return cargoRegistrationNumber;
    }

    public boolean getIsCargoIsFragile() {
        return cargoIsFragile;
    }
    public CargoStorage setDestination(String cargoDestination){
        return new CargoStorage(dimensions,
                cargoMass,
                cargoDestination,
                cargoCanFlip,
                cargoRegistrationNumber,
                cargoIsFragile);
    }
    public CargoStorage setMass(double cargoMass){
        return new CargoStorage(dimensions,
                cargoMass,
                cargoDestination,
                cargoCanFlip,
                cargoRegistrationNumber,
                cargoIsFragile);
    }
    public String toString(){
        return "Габариты: " + "\n"
                + "Высота: " + dimensions.getHeight() + "\n"
                + "Ширина: " + dimensions.getWidth() + "\n"
                + "Длина: " + dimensions.getLength() + "\n"
                + "Масса: " + cargoMass + "\n"
                + "Пункт назначения: " + cargoDestination + "\n"
                + "Вертикальная траспортировка: " + cargoCanFlip + "\n"
                + "Регистрационный номер: " + cargoRegistrationNumber + "\n"
                + "Хрупкий груз: " + cargoIsFragile + "\n"
                + "Общий обьём: " + dimensions.canculateVolume();
    }
}
