import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    private static int newWidth = 300;
    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\Nikita\\IdeaProjects\\java_basics\\Multithreading\\ImageResizer\\data\\src";
        String dstFolder = "C:\\Users\\Nikita\\IdeaProjects\\java_basics\\Multithreading\\ImageResizer\\data\\dst";

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();

        int cores = Runtime.getRuntime().availableProcessors();

        for (int core = 1; core <= cores; core++) {
            File[] files1 = new File[files.length / core];
            System.arraycopy(files,0,files1,0,files1.length);
            ImageResizer resizer = new ImageResizer(files1, newWidth, dstFolder);
            new Thread(resizer).start();
        }
    }
}
