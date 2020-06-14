package Config;

import Service.NameCardService;
import Service.NameCardServiceImpl;
import SqlService.SqlService;
import com.mysql.cj.jdbc.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"Dao", "Domain", "Service", "SqlService"})
@PropertySource("/Config/database.properties")
public class AppContext {
    @Value("${db.driverClass}") Class<? extends Driver> driverClass;
    @Value("${db.url}") String url;
    @Value("${db.username}") String username;
    @Value("${db.password}") String password;

    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource ds = new SimpleDriverDataSource();

        ds.setDriverClass(this.driverClass);
        ds.setUrl(this.url);
        ds.setUsername(this.username);
        ds.setPassword(this.password);

        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());

        return tm;
    }
}
