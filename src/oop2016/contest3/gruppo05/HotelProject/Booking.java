package oop2016.contest3.gruppo05.HotelProject;


import java.io.Serializable;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wael Karman
 */
public class Booking implements Comparable<Booking>,Serializable{
    private final LocalDate from;
    private final LocalDate to;
    private final Cliente c;

    public Booking(LocalDate from, LocalDate to, Cliente c) {
        this.from = from;
        this.to = to;
        this.c = c;
    }
    
    

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "booking{" + "from=" + from + ", to=" + to +" dal cliente: "+ c +'}';
    }

    
    @Override
    public int compareTo(Booking b) {
    return this.from.compareTo(b.getFrom());
    }
    
}
