package t4j.app.exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class LoginServerException extends RuntimeException {

    public LoginServerException(String string) {
        super(string);
    }
}
