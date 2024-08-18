package co.edu.uniquindio;

import java.util.Collection;
import java.util.LinkedList;

public class Propietario {
    public String nombre;
    public String cedula;
    public String email;
    public String celular;
    public Vehiculo vehiculoAsociado;
    public Collection<Vehiculo> listaVehiculosAsociado;

    public Propietario(String nombre, String cedula, String email, String celular, Vehiculo vehiculoAsociado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.celular = celular;
        this.vehiculoAsociado = vehiculoAsociado;
        this.listaVehiculosAsociado = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Vehiculo getVehiculoAsociado() {
        return vehiculoAsociado;
    }

    public void setVehiculoAsociado(Vehiculo vehiculoAsociado) {
        this.vehiculoAsociado = vehiculoAsociado;
    }


}

