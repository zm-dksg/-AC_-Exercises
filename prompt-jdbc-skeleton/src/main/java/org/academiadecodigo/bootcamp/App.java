package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.controller.LoginController;
import org.academiadecodigo.bootcamp.controller.MainController;
import org.academiadecodigo.bootcamp.controller.UserDetailsController;
import org.academiadecodigo.bootcamp.controller.UserListController;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.JpaUserService;
import org.academiadecodigo.bootcamp.service.UserService;
import org.academiadecodigo.bootcamp.utils.Security;
import org.academiadecodigo.bootcamp.view.LoginView;
import org.academiadecodigo.bootcamp.view.MainView;
import org.academiadecodigo.bootcamp.view.UserDetailsView;
import org.academiadecodigo.bootcamp.view.UserListView;

public class App {

    public static void main(String[] args) {

        LoginController loginController = new LoginController();
        MainController mainController = new MainController();
        UserListController userListController = new UserListController();
        LoginView loginView = new LoginView();
        MainView mainView = new MainView();
        UserListView userListView = new UserListView();
        UserDetailsController userDetailsController = new UserDetailsController();
        UserDetailsView userDetailsView = new UserDetailsView();
        Prompt prompt = new Prompt(System.in, System.out);

        UserService userService = new JpaUserService();

        User user = new User();
        // adding new user - rui
        user.setUsername("rui");
        user.setEmail("ferrao@academiadecodigo.org");
        user.setPassword(Security.getHash("academiadecodigo"));
        user.setFirstName("Rui");
        user.setLastName("Ferrão");
        user.setPhone("912345678");
        userService.add(user);

        // adding new user - faustino
        user.setUsername("faustino");
        user.setEmail("faustino@academiadecodigo.org");
        user.setPassword(Security.getHash("academiadecodigo"));
        user.setFirstName("João");
        user.setLastName("Faustino");
        user.setPhone("966666666");
        userService.add(user);

        // adding new user - audrey
        user.setUsername("audrey");
        user.setEmail("audrey@academiadecodigo.org");
        user.setPassword(Security.getHash("academiadecodigo"));
        user.setFirstName("Audrey");
        user.setLastName("Lopes");
        user.setPhone("934567890");
        userService.add(user);

        // Wire login controller and view
        loginView.setPrompt(prompt);
        loginView.setController(loginController);
        loginController.setUserService(userService);
        loginController.setView(loginView);
        loginController.setNextController(mainController);

        // Wire main controller and view
        mainView.setPrompt(prompt);
        mainView.setController(mainController);
        mainController.setView(mainView);
        mainController.setUserListController(userListController);
        mainController.setUserDetailsController(userDetailsController);

        // Wire userList controller and view
        userListView.setPrompt(prompt);
        userListView.setController(userListController);
        userListController.setUserService(userService);
        userListController.setView(userListView);

        // Wire userDetails controller and view
        userDetailsView.setPrompt(prompt);
        userDetailsView.setController(userDetailsController);
        userDetailsController.setUserService(userService);
        userDetailsController.setView(userDetailsView);


        // Start APP
        loginController.init();

    }
}
