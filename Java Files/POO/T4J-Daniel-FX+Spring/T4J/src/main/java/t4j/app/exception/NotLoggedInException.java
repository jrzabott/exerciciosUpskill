package t4j.app.exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class NotLoggedInException extends RuntimeException {

    public NotLoggedInException(String string) {
        super(string);
    }
}
