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
public class Zona {
    private String Nombre;
    private String ipMulticast;
    private String[] coordenadasCentro;
    private float radioZona;

    public Zona(String Nombre, String ipMulticast, String[] coordenadasCentro, float radioZona) {
        this.Nombre = Nombre;
        this.ipMulticast = ipMulticast;
        this.coordenadasCentro = coordenadasCentro;
        this.radioZona = radioZona;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getIpMulticast() {
        return ipMulticast;
    }

    public String[] getCoordenadasCentro() {
        return coordenadasCentro;
    }

    public float getRadioZona() {
        return radioZona;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setIpMulticast(String ipMulticast) {
        this.ipMulticast = ipMulticast;
    }

    public void setCoordenadasCentro(String[] coordenadasCentro) {
        this.coordenadasCentro = coordenadasCentro;
    }

    public void setRadioZona(float radioZona) {
        this.radioZona = radioZona;
    }

    @Override
    public String toString() {
        return "Zona{" + "Nombre=" + Nombre + ", ipMulticast=" + ipMulticast + ", coordenadasCentro=" + coordenadasCentro + ", radioZona=" + radioZona + '}';
    }
    
}
