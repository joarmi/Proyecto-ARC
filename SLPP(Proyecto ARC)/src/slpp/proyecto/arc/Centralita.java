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

        while (true) {
            for (int i = 0; i < 50; i++) {
                Policia p1 = new Policia(i);
                
                    
                p1.start();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Centralita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
