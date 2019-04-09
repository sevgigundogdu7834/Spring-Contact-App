package config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"dao","service"})
public class SpringRootConfiguration {

    @Bean
    public BasicDataSource getDataSource(){

        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/capp_db");
        dataSource.setUsername("root");
        dataSource.setPassword("123456789");
        dataSource.setMaxTotal(2);
        dataSource.setInitialSize(1);
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setDefaultAutoCommit(true);
        return dataSource;

    }
}
