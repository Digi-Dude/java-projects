import java.io.*;
import java.nio.file.*;

public class FileUtils {
    private static File source;
    private static File target;


    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        source = new File(sourceDirectory);
        target = new File(destinationDirectory);
        enterDir(new File(sourceDirectory));


    }

    private static void enterDir(File directory){
        File[] files = directory.listFiles();
        assert files != null;
        for (File file: files) {
            if (file.isFile()) {
                copyFile(file);
            }
            else {
                copyFile(file);
                enterDir(file);
            }
        }
    }



    private static void copyFile(File file){
        Path copyFile = file.toPath();
        Path targetFile = Paths.get(target.getPath(), source.toPath().relativize(file.toPath()).toString());
        try {
            Files.copy(copyFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}







