package de.klsssolution.gablerlog.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ManagedBean
@ViewScoped
public class ZeitFormat {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static LocalDateTime zeitstempelErzeugen(String s){
        LocalDateTime ldt = LocalDateTime.parse(s, formatter);
        return ldt;
    }
}
