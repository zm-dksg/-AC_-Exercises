package manytomany;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer userID;

    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Chat> chatList;

    public User() {
        chatList = new LinkedList<>();
    }

    public void addChat(Chat chat) {
        chatList.add(chat);
    }

    public Integer getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

}
