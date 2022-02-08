package com.example.washingproject.user;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "t_user")
public class  User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;

    public User() {
    }

    public void setUserLogin(){
        this.userName="user";
        this.password="user";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
