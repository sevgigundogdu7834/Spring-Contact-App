package service;
import domain.User;
import exception.UserBlockedException;

import java.util.List;

public interface UserService {

    public static final int LOGIN_STATUS_ACTİVE=1;
    public static final int LOGIN_STATUS_BLOCKED=2;

    public static final int ROLE_ADMİN=1;
    public static final int ROLE_USER=2;

    public void register(User user);
    public User login(String loginName,String password) throws UserBlockedException;
    public List<User> getUserList();
    public void changeLoginStatus(int userId,int loginStatus);
}
