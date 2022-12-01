package acardenas.com.models;

public class ObjectResponse<T> {
    private String path;
    private Integer status;
    private T data;
    private ExceptionResponse apiError;

    public ObjectResponse(String path, Integer status, T data, ExceptionResponse apiError) {
        this.path = path;
        this.status = status;
        this.data = data;
        this.apiError = apiError;
    }

    public ObjectResponse() {

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ExceptionResponse getApiError() {
        return apiError;
    }

    public void setApiError(ExceptionResponse apiError) {
        this.apiError = apiError;
    }
}
