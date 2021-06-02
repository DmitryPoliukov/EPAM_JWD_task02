package by.epamtc.poliukov.task02.exception;

public class OverVolumeCapacityException extends Exception {

    public OverVolumeCapacityException() {
        super();
    }

    public OverVolumeCapacityException(String message) {
        super(message);
    }

    public OverVolumeCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverVolumeCapacityException(Throwable cause) {
        super(cause);
    }
}
