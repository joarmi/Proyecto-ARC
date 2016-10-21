/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slpp.proyecto.arc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ventura
 */
public class Centralita {

    public static void main(String[] args) {
        
        
        Zona a = new Zona("Burjassot", "225.254.254.0", new String[]{"5","5"}, 10);
        Zona b = new Zona("Moncada", "225.254.254.1", new String[]{"5","15"}, 10);
        
        while (true) {
            
            for (int i = 0; i < 25; i++) {
                Policia p1 = new Policia(i, a); 
                Policia p2 = new Policia(i, b);
                    
                p1.start();
                p2.start();
            }
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Centralita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
