package org.academiadecodigo.shellmurais;

import java.util.HashMap;

public class Verifier {

    private final HashMap<String,String> userList; // holds the "registered" users and their passwords
    private final int userNumber;

    public Verifier(int userNumber) {
        userList = new HashMap<>();
        this.userNumber = userNumber;
        init();

    }

    // generates and adds the usernames and their passwords to the hash map
    private void init() {
        for (int i = 0; i < userNumber; i++) {
            userList.put("user"+(i+1),"pass"+(i+1));
        }

    }

    // the username must exist and the password must correspond to it's value
    public boolean verifyCredentials(String username, String password) {
        return userList.containsKey(username) && password.equals(userList.get(username));

    }

}
