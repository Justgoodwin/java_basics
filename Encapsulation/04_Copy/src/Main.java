public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions();
        CargoStorage cargoStorage = new CargoStorage(dimensions.setDimension(13,14,22),
                343,
                "Berlin",
                false,
                "asdas213",
                false
        );

        System.out.println(cargoStorage);

    }

}
