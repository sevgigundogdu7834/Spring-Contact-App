/*import config.SpringRootConfiguration;
import dao.UserDaoIml;
import domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestUserFindById {

    public static void main(String[] args) {

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringRootConfiguration.class);
        UserDaoIml userDaoIml=applicationContext.getBean(UserDaoIml.class);

     List<User> userList= userDaoIml.findByProperty("userId",20);

      for(User user:userList){

          System.out.println(user);
      }

    }
}*/
