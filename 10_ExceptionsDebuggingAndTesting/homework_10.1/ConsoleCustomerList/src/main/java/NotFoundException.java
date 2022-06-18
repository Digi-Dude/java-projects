public class NotFoundException extends IndexOutOfBoundsException {

    private String message;

    public String getMessage() {
        return message;
    }

    public  NotFoundException(String message) {
        this.message = message;
    }
}
