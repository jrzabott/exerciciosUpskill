package t4j.app.exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class ElementoNaoExistenteException extends RuntimeException {

    public ElementoNaoExistenteException(String string) {
        super(string);
    }
}
