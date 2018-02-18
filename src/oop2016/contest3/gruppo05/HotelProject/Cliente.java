package oop2016.contest3.gruppo05.HotelProject;


import java.io.Serializable;

/**
 *
 * La classe Cliente identifica ciascun cliente tramite il suo Codice Fiscale
 * possiede solo un attributo e implementa il solo metodo "toString()"  
 */
public class Cliente implements Serializable{
    private final String codiceFiscale;

    
    

    public Cliente(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    @Override
    public String toString() {
        return "Cliente:" + codiceFiscale;
    }
    
    
}
