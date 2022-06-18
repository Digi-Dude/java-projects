public class IsValid {

    public static boolean isValid(String text)
    {
        text.trim();
        if (text.matches("[А-Я][А-я-]+\\s+[А-Я][а-я]+\\s+[А-Я][а-я]+")) {
            return true;
        }
        else {
            return false;
        }
    }
}
