/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Grupos.Zona;

/**
 *
 * @author Ventura
 */
public class Policia extends Thread {

    private int id;
    private Zona zonaTrabajo;

    public Policia(int id, Zona zonatrabajo) {
        this.id = id;
        this.zonaTrabajo = zonatrabajo;
    }

    // Los argumentos proporcionan el mensaje y el nombre del servidor
    @Override
    public void run() {
        synchronized (this) {
            try {
                int puertoServidor = 6789;

                MulticastSocket ms = new MulticastSocket(puertoServidor);
                ms.joinGroup(InetAddress.getByName(zonaTrabajo.getIpMulticast()));

                String texto = String.valueOf(id) + " " + zonaTrabajo.getIpMulticast();

                byte[] mensaje = texto.getBytes();
                InetAddress hostServidor = InetAddress.getByName("127.0.0.1");

                // Construimos un datagrama para enviar el mensaje al servidor
                DatagramPacket peticion
                        = new DatagramPacket(mensaje, mensaje.length, hostServidor,
                                puertoServidor);

                // Enviamos el datagrama
                ms.send(peticion);
                
                DatagramPacket dgp = null;
                for(int i = 0; i < zonaTrabajo.getNumeroPolicias(); i++){
                    // Construimos el DatagramPacket que contendrá la respuesta
                    byte[] bufer = new byte[1024];

                    dgp = new DatagramPacket(bufer, bufer.length);
                    ms.receive(dgp);
                    // Enviamos la respuesta del servidor a la salida estandar
                    System.out.println("Respuesta para Hilo " + id + " : " + new String(dgp.getData()));
                }
                // Cerramos el socket
                ms.leaveGroup(InetAddress.getByName(zonaTrabajo.getIpMulticast()));
                ms.close();

            } catch (SocketException e) {
                System.out.println("Socket: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO: " + e.getMessage());
            }
        }
    }

}
