package SqlService;

import org.springframework.stereotype.Component;

@Component
public class DefaultSqlService extends BaseSqlService{
    public DefaultSqlService(){
        setSqlReader(new JaxbXmlSqlReader());
        setSqlRegistry(new HashMapSqlRegistry());
    }
}
