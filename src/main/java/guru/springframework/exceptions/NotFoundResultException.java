package guru.springframework.exceptions;

public class NotFoundResultException extends RuntimeException {

    public NotFoundResultException() {
    }

    public NotFoundResultException(String message) {
        super(message);
    }

    public NotFoundResultException(String message, Throwable cause) {
        super(message, cause);
    }
}
