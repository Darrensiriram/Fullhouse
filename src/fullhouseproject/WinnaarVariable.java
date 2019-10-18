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
public class WinnaarVariable {
    private String gnaam, tnaam, tafel, ronde;

    public WinnaarVariable(String gnaam, String tnaam, String tafel, String ronde) {
        this.gnaam = gnaam;
        this.tnaam = tnaam;
        this.tafel = tafel;
        this.ronde = ronde;
    }

    public String getGnaam() {
        return gnaam;
    }

    public String getTnaam() {
        return tnaam;
    }

    public String getTafel() {
        return tafel;
    }

    public String getRonde() {
        return ronde;
    }
    
    
}
