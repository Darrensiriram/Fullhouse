/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fullhouseproject;

/**
 *
 * @author Nour al Zahraa
 */
public class ToernooiVariable {
    private String naam, locatie, datum, beginEindTijd, beschrijving, condities, Uiterste_inschrijfdatum;
    private int maxInschrijving, inleggeld, ronde;

    public ToernooiVariable(String naam, String locatie, String datum, String beginEindTijd, String beschrijving, String condities, int maxInschrijving, int inleggeld, String Uiterste_inschrijfdatum, int ronde) {
        this.naam = naam;
        this.locatie = locatie;
        this.datum = datum;
        this.beginEindTijd = beginEindTijd;
        this.beschrijving = beschrijving;
        this.condities = condities;
        this.Uiterste_inschrijfdatum = Uiterste_inschrijfdatum;
        this.maxInschrijving = maxInschrijving;
        this.inleggeld = inleggeld;
        this.ronde = ronde;
    }

    public String getNaam() {
        return naam;
    }

    public String getLocatie() {
        return locatie;
    }

    public String getDatum() {
        return datum;
    }

    public String getBeginEindTijd() {
        return beginEindTijd;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public String getCondities() {
        return condities;
    }

    public String getUiterste_inschrijfdatum() {
        return Uiterste_inschrijfdatum;
    }

    public int getMaxInschrijving() {
        return maxInschrijving;
    }

    public int getInleggeld() {
        return inleggeld;
    }

    public int getRonde() {
        return ronde;
    }
    
}
