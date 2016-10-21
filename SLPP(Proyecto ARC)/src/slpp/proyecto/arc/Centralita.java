/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slpp.proyecto.arc;

/**
 *
 * @author Ventura
 */
public class Centralita {

    public static void main(String[] args) {

        Zona a = new Zona("Burjassot", "225.254.254.0", new String[]{"5", "5"}, 10);
        Zona b = new Zona("Moncada", "225.254.254.1", new String[]{"5", "15"}, 10);

        Policia p1 = new Policia(1, a);
        Policia p2 = new Policia(2, a);
        Policia p3 = new Policia(3, b);
        Policia p4 = new Policia(4, b);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }

}
