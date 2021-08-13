package manytomany;

public class Main {

    public static void main(String[] args) {

        JpaUserService userService = new JpaUserService();

        User user1 = new User();
        user1.setUsername("ze");
        User user2 = new User();
        user2.setUsername("policarpo");
        User user3 = new User();
        user3.setUsername("mego");
        User user4 = new User();
        user4.setUsername("diana");

        Chat chat1 = new Chat();
        chat1.setChatName("O Ze E Fixe");
        chat1.addUser(user1);

        Chat chat2 = new Chat();
        chat2.setChatName("Mesa Mais Fixe de Sempre");
        chat2.addUser(user1);
        chat2.addUser(user2);
        chat2.addUser(user3);
        chat2.addUser(user4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        System.out.println("----------");
        for (User user : chat1.getUserList()) {
            System.out.println(user.getUsername());
        }

        System.out.println("----------");
        for (User user : chat2.getUserList()) {
            System.out.println(user.getUsername());
        }

        userService.close();
    }

}
