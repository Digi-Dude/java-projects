import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    private static final double KILOBYTE = 1024;
    private static final double MEGABYTE = 1024 * 1024 ;
    private static final double GIGABYTE = 1024 * 1024 * 1024 ;
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        try {
            Path path = Paths.get(line);
            if (Files.exists(path)) {
                double allSizeSystem = (double) FileUtils.calculateFolderSize(line);
                if (allSizeSystem < MEGABYTE)
                    System.out.println("Размер папки " + line + " " + String.format("%.2f",(allSizeSystem / KILOBYTE)) + " Килобайт(ов)");
                if (allSizeSystem < GIGABYTE && allSizeSystem > MEGABYTE)
                    System.out.println("Размер папки " + line + " " + String.format("%.2f",(allSizeSystem /  MEGABYTE)) + " Мегабайта(ов)");
                if (allSizeSystem > GIGABYTE)
                    System.out.println("Размер папки " + line + " " + String.format("%.2f",(allSizeSystem /  GIGABYTE)) + " Гигабайта(ов)");
            }
            else {
                System.out.println("веден не верный путь");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }



    }
}
