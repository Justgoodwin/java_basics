public class Main {
    public static void main(String[] args) {
//        Country country = new Country("SADA");
//        System.out.println("Country name: " + country.getCountryName());
//        country.setCountryArea(12345.22);
//        System.out.println("Country area: " + country.getCountryArea());
//        country.setCountryPopulation(140000);
//        System.out.println("Population: " + country.getCountryPopulation());
//        country.setCountryCapitalName("QAZ");
//        System.out.println("Country capital name: " + country.getCountryCapitalName());
//        System.out.println("Country sea border: " + country.getCountrySeaBorder());


        Engine engine = new Engine("Diesel");
        System.out.println("Engine type is: " + engine.getEngineType());
        engine.setEngineCompressionDegree(23);
        System.out.println("Compression degree equals: " + engine.getEngineCompressionDegree() + " kg/cm^2");
        engine.setEngineCapacity(2.2);
        System.out.println("Engine capacity: " + engine.getEngineCapacity() + " litres");
        engine.setEngineCylinders(4);
        System.out.println("Cylinders: " + engine.getEngineCylinders());
        engine.setEngineTurbine(true);
        System.out.println("Turbine: " + engine.getEngineTurbine());
    }
}
