package acardenas.com.models;

public class ExceptionResponse {
    private String typeClass;
    private String message;
    private StackTraceElement errorTrack;

    public ExceptionResponse(String typeClass, String message, StackTraceElement errorTrack) {
        this.typeClass = typeClass;
        this.message = message;
        this.errorTrack = errorTrack;
    }

    public ExceptionResponse() {

    }

    public String getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(String typeClass) {
        this.typeClass = typeClass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StackTraceElement getErrorTrack() {
        return errorTrack;
    }

    public void setErrorTrack(StackTraceElement errorTrack) {
        this.errorTrack = errorTrack;
    }
}
