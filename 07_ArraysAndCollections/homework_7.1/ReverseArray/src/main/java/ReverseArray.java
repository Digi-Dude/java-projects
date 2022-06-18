public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){


      String firstWord;
      String lastWord;
      for (int i = 0; i < strings.length / 2; i++) {
          firstWord = strings[i];
          lastWord = strings[strings.length - 1 - i];
          strings[i] = lastWord;
          strings[strings.length - 1 - i] = firstWord;

      }
        return strings;
    }
}
