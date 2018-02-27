package de.klsssolution.gablerlog.model;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Login {
    private String benutzername;
    private String passwort;

    public boolean login() {
        String un = "test";
        String pw = "test";
        return (un.equals(benutzername) && pw.equals(passwort));
    }

    public String getBenutzername() {
        return benutzername;
    }

    public String getPasswort() {
        return benutzername;
    }

    public void setBenutzername(String username) {
        this.benutzername = username;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }


}
