import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Path sourceDir;
        Path targetDir;
        while (true) {
            System.out.println("Введите путь директроии, которую требуется скопировать");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            sourceDir = Paths.get(userInput);
            if (!sourceDir.toFile().exists()) {
                System.out.println("ВВеден не действительный путь");
                continue;
            }
            System.out.println("Введите путь директроии, которую требуется скопировать");
            userInput = scanner.nextLine();
            targetDir = Paths.get(userInput);
            while (!targetDir.toFile().exists()) {
                System.out.println("ВВеден не действительный путь");
                userInput = scanner.nextLine();
                targetDir = Paths.get(userInput);
            }
            FileUtils.copyFolder(sourceDir.toString(),targetDir.toString());
            System.out.println("Файлы успешно скопированы");

        }

    }
}