public class Country {

    private String countryName = "";
    private String countryCapitalName = "";
    private double countryPopulation = 0;
    private double countryArea = 0; // km^2
    private boolean countrySeaBorder = false;

    public Country(String countryName) {
        this.countryName = countryName;
    }
    public String getCountryCapitalName() {
        return countryCapitalName;
    }
    public String getCountryName(){
        return countryName;
    }

    public void setCountryCapitalName(String countryCapitalName) {
        this.countryCapitalName = countryCapitalName;
    }

    public double getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(double countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public double getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(double countryArea) {
        this.countryArea = countryArea;
    }

    public boolean getCountrySeaBorder() {
        return countrySeaBorder;
    }

    public void setCountrySeaBorder(boolean countrySeaBorder) {
        this.countrySeaBorder = countrySeaBorder;
    }

}
