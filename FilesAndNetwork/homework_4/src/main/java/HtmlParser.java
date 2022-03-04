import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {
        private static String absolutePath;
        List<String> imagePathFromHtml = new ArrayList<>();

    public HtmlParser(String path) {
        absolutePath = path;
    }

    public List<String> htmlCodeReader(){

        try{
            Document doc = Jsoup.connect(absolutePath).get();
            Elements linksElements = doc.select("img");
            for (Element element : linksElements) {
                imagePathFromHtml.add(element.attr("abs:src"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePathFromHtml;
    }

    public void downloadImageFromSite(){
        try{
            for(String url : imagePathFromHtml) {
                URL imgUrl = new URL(url);
                InputStream in = imgUrl.openStream();

                byte[] buffer = new byte[4096];
                int n;

                OutputStream os = new FileOutputStream("C:\\Users\\Nikita\\IdeaProjects\\java_basics\\"
                        + "FilesAndNetwork\\homework_4\\downloadedData" + "/"
                        + url.substring(url.lastIndexOf("/") + 1));
                Pattern pattern = Pattern.compile("\\.(jp)(e)?(g)");
                Matcher matcher = pattern.matcher(url.substring(url.lastIndexOf("/") + 1));
                matcher.find();
                if (url.substring(url.lastIndexOf("/") + 1).equals(matcher.group())) {
                    continue;
                }
                while ((n = in.read(buffer)) != -1 && url.substring(url.lastIndexOf("/") + 1).equals(matcher.group())) {
                    os.write(buffer, 0 , n);
                }
                os.close();
                System.out.println("Save: " + url.substring(url.lastIndexOf("/") + 1)
                        + ", from: " + url);
                System.out.println("Image saved");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
