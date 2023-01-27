package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      User user1 =new User("User1", "Lastname1", "user1@mail.ru");
      Car car1 = new Car("Car1", 1);
      user1.setUserCar(car1);

      User user2 =new User("User2", "Lastname2", "user2@mail.ru");
      Car car2 = new Car("Car2", 2);
      user2.setUserCar(car2);

      User user3 =new User("User3", "Lastname3", "user3@mail.ru");
      Car car3 = new Car("Car3", 3);
      user3.setUserCar(car3);

      User user4 =new User("User4", "Lastname4", "user4@mail.ru");
      Car car4 = new Car("Car3", 3);
      user4.setUserCar(car4);

      UserService userService = context.getBean(UserService.class);
         userService.add(user1);
         userService.add(user2);
         userService.add(user3);
         userService.add(user4);

//      List<User> users = userService.listUsers();
      List<User> users = userService.getUserFromCar("Car3", 3);
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
