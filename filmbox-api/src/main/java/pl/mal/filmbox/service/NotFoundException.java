package pl.mal.filmbox.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException {
     NotFoundException() {
        super();
    }

     NotFoundException(String message) {
        super(message);
    }

     NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

     NotFoundException(Throwable cause) {
        super(cause);
    }

     NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
