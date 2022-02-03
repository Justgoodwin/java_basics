public class Main {
    public static void main(String[] args) {

        Book book = new Book("qwe","qaz",250,12312312);
        Product product = new Product("tgh",213213);
        System.out.println("book");
        System.out.println(book.getBookAuthor());
        System.out.println(book.getBookName());
        System.out.println(book.getBookPages());
        System.out.println("product");
        System.out.println(product.getName());
        System.out.println(product.getBarCode());
        System.out.println(product.getPrice());
        product.setPrice(21321);
        System.out.println(product.getPrice());





    }
}
