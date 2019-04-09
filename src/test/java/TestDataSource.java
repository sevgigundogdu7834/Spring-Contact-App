/*import config.SpringRootConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class TestDataSource {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRootConfiguration.class);
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO user(`name`, `phone`, `email`, `adress`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
        Object[] param = new Object[]{"Sevgi", "05539677861", "sevgigundogdu01@gmail.com", "Esenler/İSTANBUL", "swg", "sevgi199416."};
        jdbcTemplate.update(sql, param);
        System.out.printf("----------- SQL EXECUTED --------");

    }

}*/
