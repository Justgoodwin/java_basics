public class Main {
    public static void main(String[] args) {
        Country country = new Country("SADA");
        System.out.println("Country name: " + country.getCountryName());
        country.setCountryArea(12345.22);
        System.out.println("Country area: " + country.getCountryArea());
        country.setCountryPopulation(140000);
        System.out.println("Population: " + country.getCountryPopulation());
        country.setCountryCapitalName("QAZ");
        System.out.println("Country capital name: " + country.getCountryCapitalName());
        System.out.println("Country sea border: " + country.getCountrySeaBorder());

    }
}
