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
public class MasterclassVariable {
    private String naam, datum, beginEindTijd, bekendeSpeler;
    private double kosten;
    private int minimaleRating;

    public MasterclassVariable(String naam, String datum, String beginEindTijd, String bekendeSpeler, double kosten, int minimaleRating) {
        this.naam = naam;
        this.datum = datum;
        this.beginEindTijd = beginEindTijd;
        this.bekendeSpeler = bekendeSpeler;
        this.kosten = kosten;
        this.minimaleRating = minimaleRating;
    }

    public String getNaam() {
        return naam;
    }

    public String getDatum() {
        return datum;
    }

    public String getBeginEindTijd() {
        return beginEindTijd;
    }

    public String getBekendeSpeler() {
        return bekendeSpeler;
    }

    public double getKosten() {
        return kosten;
    }

    public int getMinimaleRating() {
        return minimaleRating;
    }   
}
