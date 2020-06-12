package SqlService;

import Dao.NameCardDao;
import SqlService.Jaxb.SqlType;
import SqlService.Jaxb.Sqlmap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class JaxbXmlSqlReader implements SqlReader{
    private final String DEFAULT_SQLMAP_FILE = "sqlmap.xml";
    private String sqlmapFile = DEFAULT_SQLMAP_FILE;

    public void setSqlmapFile(String sqlmapFile) { this.sqlmapFile = sqlmapFile; }

    public void read(SqlRegistry sqlRegistry){
        String contextpath = Sqlmap.class.getPackage().getName();
        try{
            JAXBContext context = JAXBContext.newInstance(contextpath);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InputStream is = NameCardDao.class.getResourceAsStream(sqlmapFile);
            Sqlmap sqlmap = (Sqlmap)unmarshaller.unmarshal(is);
            for(SqlType sql : sqlmap.getSql()) {
                sqlRegistry.registerSql(sql.getKey(), sql.getValue());
            }
        } catch (JAXBException e) { throw new RuntimeException(e); }
    }
}
