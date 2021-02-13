package t4j.app.exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class ElementoInvalidoException extends RuntimeException {

    public ElementoInvalidoException(String string) {
        super(string);
    }
}
