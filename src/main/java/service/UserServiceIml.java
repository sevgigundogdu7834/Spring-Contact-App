package service;

import dao.BaseDao;
import dao.UserDao;
import domain.User;
import exception.UserBlockedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import rm.UserRowMaper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceIml extends BaseDao implements UserService {

    @Autowired
    private UserDao userDao;

    public void register(User user) {

        userDao.save(user);
    }

    public User login(String loginName, String password) throws UserBlockedException{

        String sql="SELECT * FROM user WHERE loginName=:ln AND password=:pass";
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("ln",loginName);
        map.put("pass",password);

        try {

            User user=getNamedParameterJdbcTemplate().queryForObject(sql,map,new UserRowMaper());

            if(user.getLoginStatus()==UserService.LOGIN_STATUS_BLOCKED){

                throw new UserBlockedException("Your account has been blocked");
            }
            return user;

        }

        catch (EmptyResultDataAccessException expection){

            return null;

        }




    }

    public List<User> getUserList() {
        return null;
    }

    public void changeLoginStatus(int userId, int loginStatus) {

    }
}
