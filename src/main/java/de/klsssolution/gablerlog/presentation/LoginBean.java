package de.klsssolution.gablerlog.presentation;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {
    private String userName = "test";
    // von DB alle user durchsuchen nach username
    // password speichern und überprüfen
    private String password= "test";

    public boolean login() {
        String un = "test";
        String pw = "test";
        return (un.equals(userName) && pw.equals(password));
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
