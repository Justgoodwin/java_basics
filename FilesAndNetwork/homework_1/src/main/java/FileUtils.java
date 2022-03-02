import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long size = 0;
        try{
            Path folder = Paths.get(path);
            size = Files.walk(folder)
                    .filter(p -> p.toFile().isFile())
                    .mapToLong(p -> p.toFile().length())
                    .sum();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return size;
    }
}
