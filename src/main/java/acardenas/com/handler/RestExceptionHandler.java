package acardenas.com.handler;


import acardenas.com.exception.ValidationException;
import acardenas.com.models.ExceptionResponse;
import acardenas.com.models.ObjectResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Stream;

@ControllerAdvice
public class RestExceptionHandler {
    //exceptions a tratar
    @ExceptionHandler({ Throwable.class})
    public ResponseEntity<?> exceptionCatcher(HttpServletRequest request, Exception ex) {
        //armado de respuesta de una exception
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StackTraceElement traceElement = Stream.of(ex.getStackTrace()).findFirst().get();

        if (ex instanceof ValidationException) {
            status = HttpStatus.BAD_REQUEST;
        }

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTypeClass(ex.getClass().getName());
        exceptionResponse.setMessage(ex.getMessage());
        exceptionResponse.setErrorTrack(traceElement);

        ObjectResponse<?> body = new ObjectResponse<>();
        body.setPath(request.getRequestURI());
        body.setApiError(exceptionResponse);
        body.setStatus(status.value());

        return new ResponseEntity<>(body, status);
    }

}
