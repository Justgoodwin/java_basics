public class Book {

    private final String bookName;
    private final String bookAuthor;
    private final int bookPages;
    private final int bookIsbnNumber;

    public Book(String bookName, String bookAuthor, int bookPages, int bookIsbnNumber) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPages = bookPages;
        this.bookIsbnNumber = bookIsbnNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getBookPages() {
        return bookPages;
    }

    public int getBookIsbnNumber() {
        return bookIsbnNumber;
    }
}
