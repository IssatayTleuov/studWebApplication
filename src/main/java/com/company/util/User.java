package com.company.util;

import java.util.ArrayList;

public class User {
    private int id;
    private String login;
    private String password;
    private String sessionId;

    public User() {

    }

    public User(String login, String password, String sessionId) {
        this.login = login;
        this.password = password;
        this.sessionId = sessionId;
    }

    public int getUserId(ArrayList<User> userList, User user) {
        int result = 0;
        for (User u : userList) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                result = u.getId();
            }
        }
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
