package by.epamtc.poliukov.task02.exception;

public class OverWeightCapacityException extends Exception {

    public OverWeightCapacityException() {
        super();
    }

    public OverWeightCapacityException(String message) {
        super(message);
    }

    public OverWeightCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverWeightCapacityException(Throwable cause) {
        super(cause);
    }
}
