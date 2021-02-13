package t4j.app.exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class ElementoVazioException extends IllegalStateException {

    public ElementoVazioException(String string) {
        super(string);
    }
}
