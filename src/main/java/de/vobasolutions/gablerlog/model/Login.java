package de.vobasolutions.gablerlog.model;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class Login {
    private String userName;
    // von DB alle user durchsuchen nach username
    // password speichern und überprüfen
    private String password;

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
