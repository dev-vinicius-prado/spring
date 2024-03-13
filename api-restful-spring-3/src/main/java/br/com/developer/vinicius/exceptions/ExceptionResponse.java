package br.com.developer.vinicius.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ExceptionResponse(
        LocalDateTime timestamp, String message, String details
) implements Serializable {
}
