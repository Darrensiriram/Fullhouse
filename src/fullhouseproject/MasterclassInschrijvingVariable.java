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
public class MasterclassInschrijvingVariable {
    private String gnaam, mnaam, betaling;
    private int rating;

    public MasterclassInschrijvingVariable(String gnaam, String mnaam, int rating, String betaling) {
        this.gnaam = gnaam;
        this.mnaam = mnaam;
        this.betaling = betaling;
        this.rating = rating;
    }

    public String getGnaam() {
        return gnaam;
    }

    public String getMnaam() {
        return mnaam;
    }

    public String getBetaling() {
        return betaling;
    }

    public int getRating() {
        return rating;
    }
    
}
