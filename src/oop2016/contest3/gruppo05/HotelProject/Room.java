package oop2016.contest3.gruppo05.HotelProject;


import oop2016.contest3.gruppo05.eccezioni.DataNonValidaException;
import oop2016.contest3.gruppo05.eccezioni.PrenotazioneNonEsistenteException;
import oop2016.contest3.gruppo05.eccezioni.DataNonDisponibileException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * La classe Room definisce ciascuna camera dell' Hotel con i propri attributi
 * quali il numero identificativo della stanza, il prezzo di prenotazione, il 
 * tipo : Economy,Standard,Luxurious e la capienza. Possiede inoltre una collezione
 * di oggetti di tipo booking, implementata attraverso la classe TreeSet
 * scelta funzionalmente all' uso in quanto l' intento è quello di rappresentare
 * una collezione di prenotazioni ordinata secondo la data di inizio alloggio.
 * 
 */
public class Room implements Serializable{

    private final int numero;
    private final char ESL;
    private final boolean singola;
    private final double prezzo;
    private TreeSet<Booking> listaPrenotazioni; 
    
    public Room(int numero, char ESL, boolean singola, double prezzo) {
        this.numero = numero;
        this.ESL = ESL;
        this.singola = singola;
        this.prezzo = prezzo;
        listaPrenotazioni = new TreeSet();
    }

    /**
     * 
     * Il metodo accavallamentoPrenotazioni prende in ingresso un oggetto di tipo 
     * Booking che rappresenta la prenotazione che si vorrebbe effettuare, verifica
     * la disponibilità della stanza e ritorna un booleano di controllo.
     * 
     */
    public boolean accavallamentoPrenotazioni(Booking b) {
        for (Booking i : listaPrenotazioni) {
            if(  (b.getFrom().compareTo(i.getFrom())>=0 && b.getFrom().compareTo(i.getTo())<0) || ((b.getTo().compareTo(i.getFrom())>0 && b.getTo().compareTo(i.getTo())<=0)) ){
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * Il metodo aggiungiPrenotazione è pensato funzionalmente alla presenza di 
     * un interfaccia grafica, prende in ingresso i dati letti dalla GUI e ne 
     * elabora il contenuto svolgendo alcuni controlli sulla data (es: prenotazioni 
     * per un tempo passato.), formulando una prenotazione da aggiungere alla lista
     * prenotazioni relativa alla stanza desiderata.
     */
    
    public void aggiungiPrenotazione(int fromYear, int fromMonth, int fromDay, int toYear, int toMonth, int toDay, int numeroCamera,String codiceFiscale) throws DataNonValidaException, DataNonDisponibileException{
        Cliente c = new Cliente(codiceFiscale);
        Booking b = new Booking(LocalDate.of(fromYear, fromMonth, fromDay), LocalDate.of(toYear, toMonth, toDay),c);
        if (b.getFrom().isBefore(LocalDate.now()) || b.getFrom().isAfter(b.getTo())) {
            throw new DataNonValidaException("Data Non Valida");
        }
        if (accavallamentoPrenotazioni(b) == true) {
           throw new DataNonDisponibileException("Data Non Disponibile");
        } else {
            listaPrenotazioni.add(b);
        }
    }
    
    public void rimuoviPrenotazione(int fromYear, int fromMonth, int fromDay, int toYear, int toMonth, int toDay, int numeroCamera,String codiceFiscale)throws PrenotazioneNonEsistenteException {
        Cliente c = new Cliente(codiceFiscale);
        Booking b = new Booking(LocalDate.of(fromYear, fromMonth, fromDay), LocalDate.of(toYear, toMonth, toDay),c);
        if(!listaPrenotazioni.remove(b))
            throw new PrenotazioneNonEsistenteException("Prenotazione Non Esistente");
    }

    public char getESL() {
        return ESL;
    }

    public double getPrezzo() {
        return prezzo;
    }
    
    
    
    @Override
    public String toString() {
        String S = "";
        for (Booking i : listaPrenotazioni) {
            S = S.concat(i.toString())+" \n";
        }
        return "Camera " + "numero: " + numero + ", Tipo: " + ESL + ", " + singola + ". Prezzo: " + prezzo +"€ \n" + S;
    }
    

}
