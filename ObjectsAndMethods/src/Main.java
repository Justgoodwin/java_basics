public class Main {

    public static void main(String[] args) {
//        Basket basket = new Basket();
//        basket.add("Milk", 40,1,1);
//        basket.add("Butter", 12,3,2.3);
//        basket.add("Bread", 23,1,0.4);
//        basket.print("sadasd");
//        basket.getTotalWeight();
//        basket.getTotalPrice();


//        Arithmetic arithmetic = new Arithmetic(10,12);
//        System.out.println("summa of both number: " + arithmetic.adder());
//        System.out.println("multiplier of both number: " + arithmetic.multiplier());
//        System.out.println("max of both number: " + arithmetic.maxBetweenBoth());
//        System.out.println("min of both number: " + arithmetic.minBetweenBoth());

        Printer printer = new Printer();

        printer.append("asdd","qazxsw",15);
        printer.append("asdd","qazxsw",15);
        printer.append("asdd","qazxsw");
        System.out.println("Pages added to print queue: " + printer.getPendingPagesCount());
        printer.print();
        System.out.println("Pages witch was printed: " + printer.getAllPrintedPages());



    }
}
