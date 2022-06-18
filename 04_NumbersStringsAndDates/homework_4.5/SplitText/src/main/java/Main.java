import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    System.out.println(splitTextIntoWords("I’m friends with a giant now. He tosses spears taller than me a thousand yards off towards a white birch. He wants to keep it safe from cursed villagers, and I can respect that. From up here the tree is a speck of brilliant white in sickly olive and grey. We stand together in silence for a while. The whole village is visible from atop his tower, all its ramshackle buildings and tortured denizens whose worship of a rotten greatwood has clearly gone awry. I can almost smell the mold. My job is to bring the ashes of the treasonous Lords of Cinder back to their thrones to prevent the apocalypse. Maybe it’d be better off that way. This world isn’t my friend.\n" +
            "\n" +
            "But this giant is, and if he cares about a little white tree, then I should too. That might be reason enough to keep this rotten place together.\n" +
            "\n" +
            "This is what makes Dark Souls 3 so profound. Sure, the thrilling, punishing combat and notoriously difficult boss battles are its titanium skeleton, but the language and ambiguity of the world are its flesh and blood—the beating heart that imbues an excellent third-person action RPG with mythic authenticity. Marred only by few performance hiccups, Dark Souls 3 is one of the most engrossing, cohesive games I’ve ever played, and the most focused, potent game in the series."));;

  }

  public static String splitTextIntoWords(String text) {
    //TODO реализуйте метод
    StringBuilder resultBuilder = new StringBuilder("");
    String[] words = text.split("[^A-z’]+");
    for(int i = 0; i < words.length; i++) {
      if (i == words.length - 1) {
        resultBuilder.append(words[i]);
      }
      else {
        resultBuilder.append(words[i] + "\n");
      }
    }
    String result = resultBuilder.toString();

    return result;
  }

}