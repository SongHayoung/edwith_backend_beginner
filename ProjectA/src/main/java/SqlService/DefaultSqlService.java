package SqlService;

public class DefaultSqlService extends BaseSqlService{
    public DefaultSqlService(){
        setSqlReader(new JaxbXmlSqlReader());
        setSqlRegistry(new HashMapSqlRegistry());
    }
}
