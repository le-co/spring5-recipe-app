package guru.springframework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
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
