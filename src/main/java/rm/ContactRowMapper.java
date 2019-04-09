package rm;

import domain.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ContactRowMapper implements RowMapper<Contact> {

    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {

        Contact contact=new Contact();
        contact.setUserId(resultSet.getInt("userId"));
        contact.setName(resultSet.getString("name"));
        contact.setPhone(resultSet.getString("phone"));
        contact.setEmail(resultSet.getString("email"));
        contact.setAdress(resultSet.getString("adress"));
        contact.setRemark(resultSet.getString("remark"));

        return contact;


    }
}
