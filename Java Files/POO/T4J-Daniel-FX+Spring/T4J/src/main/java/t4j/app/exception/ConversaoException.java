package t4j.app.exception;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class ConversaoException extends RuntimeException {

    public ConversaoException(String classe) {
        super("Erro a converter a classe:" + classe);
    }
}
