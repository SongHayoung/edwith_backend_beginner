package SqlService;

public class SqlRetrievalFailureException extends RuntimeException{
    public SqlRetrievalFailureException() { super(); }
    public SqlRetrievalFailureException(String msg) { super(msg); }
    public SqlRetrievalFailureException(String msg, Throwable cause) { super(msg,cause); }
    public SqlRetrievalFailureException(Throwable cause) { super(cause); }
}
