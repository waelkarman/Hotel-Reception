package oop2016.contest3.gruppo05.HotelProject;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * La classe SaveLoadData è utilizzata per salvare lo stato corrente dell' applicazione.
 * Implementa due soli metodi SaveData e LoadData ripettivamente per il salvataggio in un 
 * file e il caricamento da file. Le operazioni di salvataggio e caricamento sono realizzate
 * attraverso i metodi writeObject e readObject delle note classi ObjectInputStream ed 
 * ObjectOutputStream
 */
public class SaveLoadData {
    
    File dataPresenze = new File("./src/oop2016/contest3/gruppo05/HotelProject/DataHotel");
    FileOutputStream out;
    FileInputStream in;

    public SaveLoadData() {
    }
    
    /**
     * 
     * Il metodo SaveData prende in ingresso un parametro @param h di tipo Hotel
     * da salvare su file. Il file in questione è DataHotel e si trova nel pakage
     * HotelProject
     *  
     */
    
    public void SaveData(Hotel h) throws IOException{
        out = new FileOutputStream(dataPresenze);
        ObjectOutputStream ogg = new ObjectOutputStream(out);
        ogg.writeObject(h);
        ogg.close();
    }
    
    /**
     * 
     * Il metodo LaveData restituisce un parametro @param h di tipo Hotel
     * caricato da file. Il file in questione è DataHotel e si trova nel pakage
     * HotelProject
     *  
     */
    
    public Hotel LoadData() throws IOException, ClassNotFoundException{
    Hotel k;
    in = new FileInputStream(dataPresenze);
    ObjectInputStream ogg = new ObjectInputStream(in);
    k=(Hotel) ogg.readObject();
    ogg.close();
    return k;
    
    }
    
}
