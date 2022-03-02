import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizes = new String[] {"B", "KB", "MB", "GB", "TB"};
        String readablePrint = "";
        try {
            String path = scanner.nextLine();
            long size = FileUtils.calculateFolderSize(path);
            for (int i = 0; i < sizes.length; i++) {
                if (size / Math.pow(1024, i+1) < 1 || i == sizes.length -1) {
                    readablePrint += ((double) Math.round((double) size * 10/ Math.pow(1024,i))) / 10
                            + " " + sizes[i];
                    break;
                }
            }
            System.out.println(readablePrint);

        } catch (Exception ex) {
            ex.getStackTrace();
        }

    }
}
