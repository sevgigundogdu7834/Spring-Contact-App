/*import config.SpringRootConfiguration;
import dao.UserDaoIml;
import domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserDaoIml {

    public static void main(String[] args) {

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringRootConfiguration.class);
        UserDaoIml userDaoIml=applicationContext.getBean(UserDaoIml.class);

        User user1=new User();
        user1.setName("Yusuf Aktaş Öztürk");
        user1.setAdress("Fatih mah. 209. sokak No:14/14 Esenler/İSTANBUL");
        user1.setEmail("sevgigundogdu01@gmail.com");
        user1.setLoginName("ysfaktsert123");
        user1.setLoginStatus(1);
        user1.setPassword("1234");
        user1.setPhone("05389329361");
        user1.setRole(1);

        User user2=new User();
        user2.setName("AytenGündoğdu");
        user2.setAdress("Fatih mah. 209. sokak No:14/14 Esenler/İSTANBUL");
        user2.setEmail("aytengundogdu01@gmail.com");
        user2.setLoginName("aytengndgdu123");
        user2.setLoginStatus(1);
        user2.setPassword("123456789");
        user2.setPhone("05389329361");
        user2.setRole(1);

       userDaoIml.save(user1);
       userDaoIml.save(user2);





        System.out.println("------- Data save---------");

    }
}*/
