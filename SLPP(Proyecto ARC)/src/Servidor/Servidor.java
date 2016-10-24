/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ventura
 */
public class Servidor extends Thread {

    public static void main(String args[]) {

        try {
            System.out.println("Servidor en escucha: ");
            MulticastSocket socketUDP = new MulticastSocket(6789);
            byte[] bufer = new byte[1024];

            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion
                        = new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);

                String multicastZona = new String(peticion.getData());
                
                String delimiter = " ";
                String[] substrings = multicastZona.split(delimiter);

                System.out.print("Datagrama recibido del host: "
                        + peticion.getAddress() + " con id " + substrings[0]);
                System.out.println(" desde el puerto remoto: "
                        + peticion.getPort());
                
                // Construimos el DatagramPacket para enviar la respuesta
                byte[] bufer2 = new byte[1024];
                String texto = "Soy hilo " + new String(substrings[0]);
                bufer2 = texto.getBytes();
                DatagramPacket respuesta
                        = new DatagramPacket(bufer2, bufer2.length, InetAddress.getByName(substrings[1]), peticion.getPort());

                // Enviamos la respuesta, que es un eco
                socketUDP.send(respuesta);
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}
