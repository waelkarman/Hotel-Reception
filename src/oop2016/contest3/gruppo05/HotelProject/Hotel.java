package oop2016.contest3.gruppo05.HotelProject;


import oop2016.contest3.gruppo05.eccezioni.DataNonValidaException;
import oop2016.contest3.gruppo05.eccezioni.PrenotazioneNonEsistenteException;
import oop2016.contest3.gruppo05.eccezioni.DataNonDisponibileException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wael Karman
 */
public class Hotel implements Serializable {

    private final int numeroCamereSingoleEconomy, numeroCamereDoppieEconomy,
            numeroCamereSingoleStandard, numeroCamereDoppieStandard,
            numeroCamereSingoleLuxurious, numeroCamereDoppieLuxurious;
    private final double prezzoCamereSingoleEconomy, prezzoCamereDoppieEconomy,
            prezzoCamereSingoleStandard, prezzoCamereDoppieStandard,
            prezzoCamereSingoleLuxurious, prezzoCamereDoppieLuxurious;

    HashMap<Integer, Room> tableNC;

    public Hotel(int numeroCamereSingoleEconomy, int numeroCamereDoppieEconomy, int numeroCamereSingoleStandard, int numeroCamereDoppieStandard, int numeroCamereSingoleLuxurious, int numeroCamereDoppieLuxurious, double prezzoCamereSingoleEconomy, double prezzoCamereDoppieEconomy, double prezzoCamereSingoleStandard, double prezzoCamereDoppieStandard, double prezzoCamereSingoleLuxurious, double prezzoCamereDoppieLuxurious) {
        this.numeroCamereSingoleEconomy = numeroCamereSingoleEconomy;
        this.numeroCamereDoppieEconomy = numeroCamereDoppieEconomy;
        this.numeroCamereSingoleStandard = numeroCamereSingoleStandard;
        this.numeroCamereDoppieStandard = numeroCamereDoppieStandard;
        this.numeroCamereSingoleLuxurious = numeroCamereSingoleLuxurious;
        this.numeroCamereDoppieLuxurious = numeroCamereDoppieLuxurious;
        this.prezzoCamereSingoleEconomy = prezzoCamereSingoleEconomy;
        this.prezzoCamereDoppieEconomy = prezzoCamereDoppieEconomy;
        this.prezzoCamereSingoleStandard = prezzoCamereSingoleStandard;
        this.prezzoCamereDoppieStandard = prezzoCamereDoppieStandard;
        this.prezzoCamereSingoleLuxurious = prezzoCamereSingoleLuxurious;
        this.prezzoCamereDoppieLuxurious = prezzoCamereDoppieLuxurious;
        tableNC = new HashMap();

        int k, i = 1;

        for (k = 1; k <= numeroCamereSingoleEconomy; k++) {
            tableNC.put(i, new Room(i, 'E', true, prezzoCamereSingoleEconomy));
            i++;
        }
        for (k = 1; k <= numeroCamereDoppieEconomy; k++) {
            tableNC.put(i, new Room(i, 'E', false, prezzoCamereDoppieEconomy));
            i++;
        }

        for (k = 1; k <= numeroCamereSingoleStandard; k++) {
            tableNC.put(i, new Room(i, 'S', true, prezzoCamereSingoleStandard));
            i++;
        }
        for (k = 1; k <= numeroCamereDoppieStandard; k++) {
            tableNC.put(i, new Room(i, 'S', false, prezzoCamereDoppieStandard));
            i++;
        }

        for (k = 1; k <= numeroCamereSingoleLuxurious; k++) {
            tableNC.put(i, new Room(i, 'L', true, prezzoCamereSingoleLuxurious));
            i++;
        }
        for (k = 1; k <= numeroCamereDoppieLuxurious; k++) {
            tableNC.put(i, new Room(i, 'L', false, prezzoCamereDoppieLuxurious));
            i++;
        }
    }

    public void aggiungiPrenotazioneHotel(int fromYear, int fromMonth, int fromDay, int toYear, int toMonth, int toDay, int numeroCamera,String codiceFiscale) throws DataNonValidaException, DataNonDisponibileException {
         tableNC.get(numeroCamera).aggiungiPrenotazione(fromYear, fromMonth, fromDay, toYear, toMonth, toDay, numeroCamera, codiceFiscale);
    }

    public void rimuoviPrenotazioneHotel(int fromYear, int fromMonth, int fromDay, int toYear, int toMonth, int toDay, int numeroCamera,String codiceFiscale) throws PrenotazioneNonEsistenteException {
        
        tableNC.get(numeroCamera).rimuoviPrenotazione(fromYear, fromMonth, fromDay, toYear, toMonth, toDay, numeroCamera, codiceFiscale);
    }
    
    
    @Override
    public String toString() {
        String S = "";
        for (Map.Entry<Integer, Room> i : tableNC.entrySet()) {
            S = S.concat(i.getValue().toString() + "\n");
        }
        return S;
    }
    
}
