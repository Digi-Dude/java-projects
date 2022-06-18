import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CutArray {
    private final List<File[]> arraysFile = new ArrayList<>();
    private final String srcFolder;
    private final int cpuAmount = Runtime.getRuntime().availableProcessors();

    public CutArray(String srcFolder) {this.srcFolder = srcFolder;}

    public List<File[]> getArraysFile() {
    File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        int filesCount = 0;

        for (int i = 0; i < cpuAmount; i++) {
            int filesStep = files.length / cpuAmount;
            if (i == cpuAmount - 1) {
                arraysFile.add(new File[files.length - 1 - filesCount]);
                System.arraycopy(files, filesCount, arraysFile.get(i), 0, files.length - 1 - filesCount);
                continue;
            }
            arraysFile.add(new File[filesStep]);
            System.arraycopy(files, filesCount, arraysFile.get(i), 0, filesStep);
            filesCount += filesStep;

        }
        return arraysFile;
    }
}
