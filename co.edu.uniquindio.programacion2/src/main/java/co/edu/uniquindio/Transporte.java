package co.edu.uniquindio;

import java.util.Collection;
import java.util.LinkedList;

public class Transporte extends Vehiculo {
    public int maxPasajeros;
    public Collection<Usuario> listaUsuariosAsociados;

    public Transporte(String placa, String modelo, String marca, String color, Propietario propietarioAsociado, int maxPasajeros) {
        super(placa, modelo, marca, color, propietarioAsociado);
        this.maxPasajeros = maxPasajeros;
        this.listaUsuariosAsociados = new LinkedList<>();
    }

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public void setMaxPasajeros(int maxPasajeros) {
        this.maxPasajeros = maxPasajeros;
    }

    public Collection<Usuario> getListaUsuariosAsociados() {
        return listaUsuariosAsociados;
    }

    public void setListaUsuariosAsociados(Collection<Usuario> listaUsuariosAsociados) {
        this.listaUsuariosAsociados = listaUsuariosAsociados;
    }


}