package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

@ManagedBean
@SessionScoped
public class AuftragsallokationBean {

    private List<Auftrag> nichtZugeordneteAuftraege = findeAlleNichtZugeordnetenAuftraege();

    private List<Auftrag> findeAlleNichtZugeordnetenAuftraege() {
        List<Auftrag> alleAuftraege = Auftrag.getAlleAuftraege();
        for (Auftrag auftrag : alleAuftraege) {
            //alle Touren durchsuchen nach Auftrag
            auftrag.getAuftragsnummer();
        }
        return alleAuftraege;
    }

    public void auftragAuswaehlen() {

    }

    public void auftragEntfernen() {

    }
}
