package exception;

public class NoAvailableVehicleException extends RuntimeException {
    public NoAvailableVehicleException(String message) {
        super(message);
    }
}
