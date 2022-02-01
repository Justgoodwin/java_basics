public class Main {

    public static void main(String[] args) {
//        Basket basket = new Basket();
//        basket.add("Milk", 40,1,1);
//        basket.add("Butter", 12,3,2.3);
//        basket.add("Bread", 23,1,0.4);
//        basket.print("sadasd");
//        basket.getTotalWeight();
//        basket.getTotalPrice();


        Arithmetic test = new Arithmetic(10,12);
        System.out.println("summa of both number: " + test.adder());
        System.out.println("multiplier of both number: " + test.multiplier());
        System.out.println("max of both number: " + test.maxBetweenBoth());
        System.out.println("min of both number: " + test.minBetweenBoth());

    }
}
