package co.edu.uniquindio;

import java.util.Collection;
import java.util.LinkedList;
/**
 *
 * Clase Transporte
 */
public class Transporte extends Vehiculo {
    public int maxPasajeros;
    public Collection<Usuario> listaUsuariosAsociados;

    /**
     * Constructor para crear una instancia de Transporte con la información del vehículo y el máximo de pasajeros.
     * Inicializa la lista de usuarios asociados al vehículo.
     *
     * @param placa                Placa del vehículo.
     * @param modelo               Modelo del vehículo.
     * @param marca                Marca del vehículo.
     * @param color                Color del vehículo.
     * @param propietarioAsociado  Propietario asociado al vehículo.
     * @param maxPasajeros         Número máximo de pasajeros que el vehículo puede transportar.
     */
    public Transporte(String placa, String modelo, String marca, String color, Propietario propietarioAsociado, int maxPasajeros) {
        super(placa, modelo, marca, color, propietarioAsociado);
        this.maxPasajeros = maxPasajeros;
        this.listaUsuariosAsociados = new LinkedList<>();
    }

    /**
     *
     * Getters y setters
     */
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