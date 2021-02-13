package t4j.app.exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class UsersAPIException extends RuntimeException {

    public UsersAPIException(String string) {
        super(string);
    }
}
