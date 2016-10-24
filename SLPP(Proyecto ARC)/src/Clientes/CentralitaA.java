/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import Grupos.Zona;
import Clientes.Policia;
import java.util.Scanner;

/**
 *
 * @author Ventura
 */
public class CentralitaA {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int numeroZonaA = 0;
        int numeroZonaB = 0;
        
        System.out.println("Introduce el nummero de agentes en Burjassot: ");
        numeroZonaA = sc.nextInt();
       
        System.out.println("Introduce el nummero de agentes en Moncada: ");
        numeroZonaB = sc.nextInt();

        Zona a = new Zona("Burjassot", "225.254.254.20", new String[]{"5", "5"}, 10,5);
        Zona b = new Zona("Moncada", "225.254.254.50", new String[]{"5", "15"}, 10,5);

   
        for(int i = 1; i <= numeroZonaA; i++){
            Policia p = new Policia(i, a);
            
            p.start();
        }
        
        for(int i = 1; i <= numeroZonaB; i++){
            Policia p = new Policia(i + 5, b);
          
            p.start();
        }
    }

}
