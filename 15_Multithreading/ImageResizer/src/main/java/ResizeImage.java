import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ResizeImage implements Runnable {
    private final File[] files;
    private final int maxSideSize;
    private final String dstFolder;


    public ResizeImage(File[] files, int maxSideSize, String dstFolder) {
        this.files = files;
        this.maxSideSize = maxSideSize;
        this.dstFolder = dstFolder;
    }

    @Override
    public void run() {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }
                BufferedImage newImage = Scalr.resize(image, maxSideSize);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
