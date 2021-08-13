package manytomany;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer chatID;

    private String chatName;

    @ManyToMany (mappedBy = "chatList", fetch = FetchType.LAZY)
    private List<User> userList;

    public Chat() {
        userList = new LinkedList<>();
    }

    public void addUser(User user) {
        userList.add(user);
        user.addChat(this);
    }

    public Integer getChatID() {
        return chatID;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
