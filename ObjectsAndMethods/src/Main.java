public class Main {

    public static void main(String[] args) {
        Basket basket1 = new Basket();
        Basket basket2 = new Basket();
        Basket basket3 = new Basket();
        basket1.add("Milk", 40,1,1);
        basket1.add("Butter", 12,3,2.3);
        basket1.add("Bread", 23,1,0.4);
        basket2.add("Soda", 55,4,0.7);
        basket2.add("Cola", 148,1,2.3);
        basket2.add("Pepsi", 145,1,0.4);
        basket3.add("Juice", 60,1,1);
        basket3.add("Water", 7,5,2.5);
        basket3.add("Coffee", 23,1,0.4);

        basket1.print("Basket 1");
        basket2.print("Basket 2");
        basket3.print("Basket 3");
        System.out.println(Basket.getTotalItemsInAllBusket());
        System.out.println(Basket.getTotalPriceOfAllBusket());
        System.out.println("Average price of all products: " + Basket.getAverageProductPrice());
        System.out.println("Average price of one basket: " + Basket.getAveragePriceOfOneBasket());
    }
}
