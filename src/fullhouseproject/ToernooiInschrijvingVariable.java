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
public class ToernooiInschrijvingVariable {
    private String gnaam, tnaam, betaling;

    public ToernooiInschrijvingVariable(String gnaam, String tnaam, String betaling) {
        this.gnaam = gnaam;
        this.tnaam = tnaam;
        this.betaling = betaling;
    }

    public String getGnaam() {
        return gnaam;
    }

    public String getTnaam() {
        return tnaam;
    }

    public String getBetaling() {
        return betaling;
    }
    
}
