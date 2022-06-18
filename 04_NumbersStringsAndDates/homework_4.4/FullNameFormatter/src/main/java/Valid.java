public class Valid {

  static final String ALPHABET = " абвгдеёжзийклмнопрстуфхцчшщыьъэюяАБВГДЕЁЖЗИЁКЛМНОПРСТУФХЦЧШЩЦЭЮЯ-";

  static boolean isCyrillic (char currentWord) {
    int result = 0;
    for (int c = 0; c < ALPHABET.length(); c++) {
      if (currentWord == ALPHABET.charAt(c))
      result++;
      }
    
    if (result == 0) {
      return false;
    }
    else {
      return true;
    }
  }

  static boolean isThreeWords (String phrase)
  {
    int spaces = 0;
    char space = ' ';
    for(int i = 0; i < phrase.length(); i++)
    {
      if (phrase.charAt(i) == space)
      {
        spaces++;
      }
    }
    if (spaces == 2) {
      return true;
    }
    else {
      return false;
    }
  }

  public static boolean isValid (String text)
  {
    if (!isThreeWords(text))
    return false;

    for (int i = 0; i < text.length(); i++)
    {
      if (!isCyrillic(text.charAt(i)))
      return false;
    }
    return true;


  }

}
