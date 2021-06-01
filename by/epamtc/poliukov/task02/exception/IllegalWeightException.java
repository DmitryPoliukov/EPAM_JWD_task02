package by.epamtc.poliukov.task02.exception;

public class IllegalWeightException extends Exception {
    public IllegalWeightException() {
        super();
    }

    public IllegalWeightException(String message) {
        super(message);
    }

    public IllegalWeightException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalWeightException(Throwable cause) {
        super(cause);
    }
}
