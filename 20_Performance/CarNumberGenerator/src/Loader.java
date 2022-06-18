import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int regions = 100;
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //PrintWriter writer = new PrintWriter("res/numbers.txt");

        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};


        for (int regionCode = 1; regionCode < regions; regionCode++) {
//            int finalRegionCode = regionCode;
//            PrintWriter writer = null;
//            try {
//                writer = new PrintWriter("res/numbers" + finalRegionCode + ".txt");
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//
//            StringBuilder builder = new StringBuilder();
//            for (int number = 1; number < 1000; number++) {
//                for (char firstLetter : letters) {
//                    for (char secondLetter : letters) {
//                        for (char thirdLetter : letters) {
//                            builder.append(firstLetter);
//                            builder.append(padNumber(number, 3));
//                            builder.append(secondLetter);
//                            builder.append(thirdLetter);
//                            builder.append(padNumber(finalRegionCode, 2));
//                            builder.append("\n");
//                        }
//                    }
//                }
//            }
//            writer.write(builder.toString());
//            writer.flush();
//            writer.close();
//        }


            int finalRegionCode = regionCode;
            executor.execute(() -> {
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter("res/numbers" + finalRegionCode + ".txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                StringBuilder builder = new StringBuilder();
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                builder.append(firstLetter);
                                builder.append(padNumber(number, 3));
                                builder.append(secondLetter);
                                builder.append(thirdLetter);
                                builder.append(padNumber(finalRegionCode, 2));
                                builder.append("\n");
                            }
                        }
                    }
                }
                writer.write(builder.toString());
                writer.flush();
                writer.close();
            });
        }
        executor.shutdown();
        if (executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
            System.out.println((System.currentTimeMillis() - start) + " ms");
        }
//        System.out.println((System.currentTimeMillis() - start) + " ms");
    }



    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }
        return numberStr;
    }
}
