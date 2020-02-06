package exceptions;

public class WrongCoordinatesCountException extends RuntimeException {

    public WrongCoordinatesCountException(String message) {
        super(message);
    }
}
