public class Main {

    public static void main(String[] args) {
        final int NEW_SIZE = 300;
        String srcFolder = "C:\\Users\\ddrom\\Desktop\\newFolder";
        String dstFolder = "C:\\Users\\ddrom\\Desktop\\newFolder2";

        CutArray cutArray = new CutArray(srcFolder);
        cutArray.getArraysFile().forEach(files -> new Thread(new ResizeImage(files, NEW_SIZE, dstFolder)).start());
    }
}
