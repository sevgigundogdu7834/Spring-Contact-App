package dao;

import domain.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import rm.UserRowMaper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoIml extends BaseDao implements UserDao {

    public void save(User u) {

        String sql="insert into user(name,phone,email,adress,loginName,password,role,loginStatus) values(:name,:phone,:email,:adress,:loginName,:password,:role,:loginStatus)";

        Map<String,Object> mapList=new HashMap<String, Object>();
        mapList.put("name",u.getName());
        mapList.put("phone",u.getPhone());
        mapList.put("email",u.getEmail());
        mapList.put("adress",u.getAdress());
        mapList.put("loginName",u.getLoginName());
        mapList.put("password",u.getPassword());
        mapList.put("role",u.getRole());
        mapList.put("loginStatus",u.getLoginStatus());

        KeyHolder keyHolder=new GeneratedKeyHolder();
        SqlParameterSource parameterSource=new MapSqlParameterSource(mapList);
        super.getNamedParameterJdbcTemplate().update(sql,parameterSource,keyHolder);
        int userId=keyHolder.getKey().intValue();
        u.setUserId(userId);

    }

    public void update(User u) {

        String sql="update user set name=:name,phone=:phone,email=:email,adress=:adress,loginName=:loginName,password=:password,role=:role,loginStatus=:loginStatus";

        Map<String,Object> mapList=new HashMap<String, Object>();
        mapList.put("name",u.getName());
        mapList.put("phone",u.getPhone());
        mapList.put("email",u.getEmail());
        mapList.put("adress",u.getAdress());
        mapList.put("loginName",u.getLoginName());
        mapList.put("password",u.getPassword());
        mapList.put("role",u.getRole());
        mapList.put("loginStatus",u.getLoginStatus());

        getNamedParameterJdbcTemplate().update(sql,mapList);

    }

    public void delete(User u) {

        this.delete(u.getUserId());

    }

    public void delete(int id) {

        String sql="delete from user where userId=:id";
        getJdbcTemplate().update(sql,id);


    }

    public User findById(int id) {

        String sql="select * from user where userId=?";

        User user=getJdbcTemplate().queryForObject(sql,new UserRowMaper(),id);

        return user;

    }

    public List<User> userAll() {

        String sql="select * from user";

        List<User> userList=getJdbcTemplate().query(sql,new UserRowMaper());

        return userList;
    }

    public List<User> findByProperty(String propName, Object propValue) {

        String sql="select * from user where "+propName+"=?";

       List<User> userList= getJdbcTemplate().query(sql,new UserRowMaper(),propValue);

       return userList;

    }
}
