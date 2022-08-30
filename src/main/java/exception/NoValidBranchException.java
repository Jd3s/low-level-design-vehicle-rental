package exception;

public class NoValidBranchException extends RuntimeException {
    public NoValidBranchException(String message) {
        super(message);
    }
}
