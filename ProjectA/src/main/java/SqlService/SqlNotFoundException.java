package SqlService;

public class SqlNotFoundException extends RuntimeException{
    public SqlNotFoundException() { super(); }
    public SqlNotFoundException(String msg) { super(msg); }
    public SqlNotFoundException(String msg, Throwable cause) { super(msg,cause); }
    public SqlNotFoundException(Throwable cause) { super(cause); }
}
