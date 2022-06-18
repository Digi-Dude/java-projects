import java.io.IOException;

public class Main {

    final static String url = "https://lenta.ru";

    public static void main(String[] args) throws IOException {
        DownloadImageByUrl dibu = new DownloadImageByUrl(url);
        dibu.getUrlImages();
        dibu.downloadImages();

    }

}
