public class Main {
    public static void main(String[] args) {
        
        String alphabet = "abcdifghijklmnopqrstuvwxyzABCDIFGHIJKLMNOPQRSTUYVWXYZ";
        String quote = "Код буквы ";

        for (int i = 0; i <= alphabet.length(); i++) 
        {
            System.out.println(quote + alphabet.charAt(i) + ": " + (int) alphabet.charAt(i));
        }
        
    }
}
