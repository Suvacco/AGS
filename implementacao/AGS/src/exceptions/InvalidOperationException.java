package exceptions;

public class InvalidOperationException extends Exception {

    public InvalidOperationException(String argument) {
        super("Operação invalida: " + argument);
    }
}
