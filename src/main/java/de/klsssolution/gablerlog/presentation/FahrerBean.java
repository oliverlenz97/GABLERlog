package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.Fahrer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class FahrerBean {
    private List<Fahrer> fahrer;

    public List<Fahrer> getFahrer() {
        return fahrer;
    }

    @PostConstruct
    public void setup() {
        fahrer = Fahrer.alleFahrer;

    }
}