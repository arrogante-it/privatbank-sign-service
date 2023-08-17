package exception;

public class SignServiceException extends RuntimeException {
    public SignServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
