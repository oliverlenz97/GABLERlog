package de.vobasolutions.gablerlog.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LoginBean {
    public String userName;
    // von DB alle user durchsuchen nach username
    // password speichern und überprüfen
    public String password;

    public boolean login() {

        return false;
    }
}
