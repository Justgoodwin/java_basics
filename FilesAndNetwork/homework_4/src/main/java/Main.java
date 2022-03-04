import java.util.List;

public class Main {
    public static void main(String[] args) {
        HtmlParser htmlParser = new HtmlParser("https://lenta.ru");
        List<String> list = htmlParser.htmlCodeReader();
//        for (String str : list) {
//            System.out.println(str);
//        }
        htmlParser.downloadImageFromSite();
    }
}
