public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40,1,1);
        basket.add("Butter", 12,3,2.3);
        basket.add("Bread", 23,1,0.4);
        basket.print("sadasd");
        basket.getTotalWeight();
        basket.getTotalPrice();

    }
}
