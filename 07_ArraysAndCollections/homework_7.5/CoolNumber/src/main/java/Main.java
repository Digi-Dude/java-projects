import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        //String dd = "А111ВМ01";
        List<String> numbers = CoolNumbers.generateCoolNumbers();
        HashSet<String> setNumbers = new HashSet<String>(numbers);
        TreeSet<String> treeSetNumbers = new TreeSet<String>(numbers);

        /////////////////////////////////////////////////////////////////////////
        Collections.sort(numbers);
        String ee = numbers.get(numbers.size() -5);
        long beginBruteForceSearch = System.nanoTime();
        if (CoolNumbers.bruteForceSearchInList(numbers,ee)) {
            String searchResult = "Найден";
            long finishBruteForceSearch = System.nanoTime();
            long timeOfSearch = finishBruteForceSearch - beginBruteForceSearch;
            System.out.println("Поиск перебором: номер " + searchResult + ", поиск занял " + timeOfSearch + " нс");
        }
        else {
            String searchResult = "не найден";
            long finishBruteForceSearch = System.nanoTime();
            long timeOfSearch = finishBruteForceSearch - beginBruteForceSearch;
            System.out.println("Поиск перебором: номер " + searchResult + ", поиск занял " + timeOfSearch + " нс");
        }

        /////////////////////////////////////////////////////////////////////////



        long beginBinarySearch = System.nanoTime();
        if (CoolNumbers.binarySearchInList(numbers,ee)) {
            String searchResult = "найден";
            long finishBinarySearch = System.nanoTime();
            long timeOfSearch = finishBinarySearch - beginBinarySearch;
            System.out.println("Бинарный поиск: номер " + searchResult + ", поиск занял " + timeOfSearch + " нс");
        }
        else {
            String searchResult = "не найден";
            long finishBinarySearch = System.nanoTime();
            long timeOfSearch = finishBinarySearch - beginBinarySearch;
            System.out.println("Бинарный поиск: номер " + searchResult + ", поиск занял " + timeOfSearch + " нс");
        }

        /////////////////////////////////////////////////////////////////////////

        long beginSearchInHashSet = System.nanoTime();
        if (CoolNumbers.searchInHashSet(setNumbers,ee)) {
            String searchResult = "найден";
            long finishSearchInHashSet = System.nanoTime();
            long timeOfSearch = finishSearchInHashSet - beginSearchInHashSet;
            System.out.println("Поиск в HashSet: номер " + searchResult + ", поиск занял " + timeOfSearch + " нс");
        }
        else {
            String searchResult = "не найден";
            long finishSearchInHashSet = System.nanoTime();
            long timeOfSearch = finishSearchInHashSet - beginSearchInHashSet;
            System.out.println("Поиск в HashSet: номер " + searchResult + ", поиск занял " + timeOfSearch + "нс");
        }

        /////////////////////////////////////////////////////////////////////////

        long beginSearchInTreeSet = System.nanoTime();
        if (CoolNumbers.searchInTreeSet(treeSetNumbers,ee)) {
            String searchResult = "найден";
            long finishSearchInTreeSet = System.nanoTime();
            long timeOfSearch = finishSearchInTreeSet - beginSearchInTreeSet;
            System.out.println("Поиск в TreeSet: номер " + searchResult + ", поиск занял " + timeOfSearch + " нс");
        }
        else {
            String searchResult = "не найден";
            long finishSearchInTreeSet = System.nanoTime();
            long timeOfSearch = finishSearchInTreeSet - beginSearchInTreeSet;
            System.out.println("Поиск в TreeSet: номер " + searchResult + ", поиск занял " + timeOfSearch + "н с");
        }

    }




}
