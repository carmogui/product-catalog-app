package com.personal.productcatalog.handler;

import com.personal.productcatalog.dto.ExceptionErrorDTO;
import com.personal.productcatalog.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class NotFoundHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NotFoundException.class})
    public ExceptionErrorDTO handle(Exception ex) {
        ExceptionErrorDTO exceptionError = new ExceptionErrorDTO();

        List<String> trace = Arrays.stream(ex.getStackTrace())
                .limit(5)
                .map(StackTraceElement::toString)
                .collect(Collectors.toList());

        exceptionError.setCode(HttpStatus.NOT_FOUND.value());
        exceptionError.setDate(LocalDateTime.now());
        exceptionError.setMessage(ex.getMessage());
        exceptionError.setTrace(trace);

        return exceptionError;
    }
}
