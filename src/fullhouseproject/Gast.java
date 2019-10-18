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
public class Gast {
    private String naam, adres, postcodeWoonplaats, telefoonnummer, email, geslacht, geboortedatum, bekendeSpeler;
    private int rating, gewonnenInleggeld;

    public Gast(String naam, String adres, String postcodeWoonplaats, String telefoonnummer, String email, String geslacht, String geboortedatum, String bekendeSpeler, int rating, int gewonnenInleggeld) {
        this.naam = naam;
        this.adres = adres;
        this.postcodeWoonplaats = postcodeWoonplaats;
        this.telefoonnummer = telefoonnummer;
        this.email = email;
        this.geslacht = geslacht;
        this.geboortedatum = geboortedatum;
        this.bekendeSpeler = bekendeSpeler;
        this.rating = rating;
        this.gewonnenInleggeld = gewonnenInleggeld;
    }

    public String getNaam() {
        return naam;
    }

    public String getAdres() {
        return adres;
    }

    public String getPostcodeWoonplaats() {
        return postcodeWoonplaats;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public String getEmail() {
        return email;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public String getBekendeSpeler() {
        return bekendeSpeler;
    }

    public int getRating() {
        return rating;
    }

    public int getGewonnenInleggeld() {
        return gewonnenInleggeld;
    }
    
}
