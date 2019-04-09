package dao;
import domain.User;
import domain.Contact;
import java.util.List;


public interface UserDao {

    public void save(User u);
    public void update(User u);
    public void delete(User u);
    public void delete(int id);
    public User findById(int id);
    public List<User> userAll();
    public List<User> findByProperty(String propName,Object propValue);


}
