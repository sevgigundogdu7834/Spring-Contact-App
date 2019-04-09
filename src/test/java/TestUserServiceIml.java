/*
import config.SpringRootConfiguration;
import domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

public class TestUserServiceIml {

    public static void main(String[] args) {

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringRootConfiguration.class);
       UserService userService= applicationContext.getBean(UserService.class);

        User user=new User();
        user.setName("Nisa");
        user.setAdress("Fatih mah. 209. sokak No:14/14");
        user.setEmail("sevgigundogdu01@gmail.com");
        user.setLoginName("sewgi");
        user.setLoginStatus(1);
        user.setPassword("12345");
        user.setPhone("05539677861");
        user.setRole(1);

       userService.register(user);

        System.out.println("-------- User is registered -----------");
    }
}
*/
