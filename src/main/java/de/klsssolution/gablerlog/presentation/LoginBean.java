package de.klsssolution.gablerlog.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class LoginBean {
    private String userName = "";
    private String password = "";
    private Boolean loginErfolgreich = false;

    /*
        public boolean login() {
            String un = "test";
            String pw = "test";
            if (un.equals(userName) && pw.equals(password)) {
                loginErfolgreich = true;
                return true;
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Anmelden fehlgeschlagen", "Anmeldedaten falsch"));
                return false;
            }
        }
        */
    public String login() {
        String un = "test";
        String pw = "test";
        if (un.equals(userName) && pw.equals(password)) {
            loginErfolgreich = true;
            return "/auftragsuebersicht.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Anmelden fehlgeschlagen", "Anmeldedaten falsch"));
            return "";
        }
    }

    public Boolean getLoginErfolgreich() {
        return loginErfolgreich;
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