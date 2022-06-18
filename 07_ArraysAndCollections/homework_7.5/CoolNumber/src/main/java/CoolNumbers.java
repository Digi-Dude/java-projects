import java.util.*;

public class CoolNumbers {
    static List<String> numbers = new ArrayList<>();
    static int n = 0;
    static int region  = 1;
    static List<String> wordOfNumbers =  new ArrayList<>(Arrays.asList("А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"));
    static String x = wordOfNumbers.get(0);
    static String y = wordOfNumbers.get(0);
    static String z = wordOfNumbers.get(0);
    static String number = "";

    public static List<String> generateCoolNumbers() {
        for (long i = 0; i < 2000000; i++) {
            if (region > 199) {
                continue;
            }
            if (n == 9) {
                n = 0;
                z = wordOfNumbers.get(wordOfNumbers.indexOf(z) + 1);

            }
            else {
                n++;
            }
            if (x.equals(wordOfNumbers.get(wordOfNumbers.size() - 1))) {
                x = wordOfNumbers.get(0);
                region++;
            }
            if(y.equals(wordOfNumbers.get(wordOfNumbers.size() - 1))) {
                y = wordOfNumbers.get(0);
                x = wordOfNumbers.get(wordOfNumbers.indexOf(x) + 1);
            }
            if(z.equals(wordOfNumbers.get(wordOfNumbers.size() - 1))) {
                z = wordOfNumbers.get(0);
                y = wordOfNumbers.get(wordOfNumbers.indexOf(y) + 1);
            }
            number = x + n + n + n + y + z + String.format("%02d", region);
            numbers.add(number);
        }

        return numbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        long min = 0;
        long max = sortedList.size() - 1;
        while (min <= max) {
            long mid = (max + min) / 2;
            if(sortedList.get((int)mid).equals(number)) {
                return true;
            }
            else if(sortedList.get((int)mid).compareTo(number) < 0) {
                min = mid + 1;
            }
            else if(sortedList.get((int)mid).compareTo(number) > 0) {
                max = mid -1;
            }

        }
        return false;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
          return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
