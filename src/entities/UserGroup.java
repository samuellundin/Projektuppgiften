package entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userGroupId;
    private String name;


    @OneToMany(targetEntity = User.class)
    private List userList;

    @Override
    public String toString(){
        return name;
    }

    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGrouId(int userGroupId) { //Primary Key
        this.userGroupId = userGroupId;
    }

    public String getUser() {
        return name;
    }

    public void setUser(String name) {
        this.name = name;
    }

    public List getUserList() {
        return userList;
    }

    public void setUserList(List userList) {
        this.userList = userList;
    }
}


