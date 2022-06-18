import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileUtils {
    private static File currentFile = null;

    public static long calculateFolderSize(String path) {
        try {
            Path folder = Paths.get(path);
            return Files.walk(folder)
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .mapToLong(File::length)
                    .sum();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
}


