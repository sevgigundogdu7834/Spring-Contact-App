package rm;

import domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMaper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user=new User();
        user.setUserId(resultSet.getInt("userId"));
        user.setName(resultSet.getString("name"));
        user.setPhone(resultSet.getString("phone"));
        user.setEmail(resultSet.getString("email"));
        user.setAdress(resultSet.getString("adress"));
        user.setLoginName(resultSet.getString("loginName"));
        user.setRole(resultSet.getInt("role"));
        user.setLoginStatus(resultSet.getInt("loginStatus"));

        return user;
    }
}
