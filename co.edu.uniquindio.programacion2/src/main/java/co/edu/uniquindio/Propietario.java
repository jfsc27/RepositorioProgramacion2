
package co.edu.uniquindio;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Clase Propietario
 */
public class Propietario {
    public String nombre;
    public String cedula;
    public String email;
    public String celular;
    public int edad;
    public Vehiculo vehiculoAsociado;
    public Collection<Vehiculo> listaVehiculosAsociado;


    /**
     * Constructor para crear una instancia de Propietario con la información personal y el vehículo asociado.
     * Inicializa la lista de vehículos asociados.
     *
     * @param nombre             Nombre completo del propietario.
     * @param cedula             Cédula de ciudadanía del propietario.
     * @param email              Dirección de correo electrónico del propietario.
     * @param celular            Número de celular del propietario.
     * @param edad               Edad del propietario.
     * @param vehiculoAsociado   Vehículo asociado inicialmente al propietario.
     */
    public Propietario(String nombre, String cedula, String email, String celular, int edad, Vehiculo vehiculoAsociado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.celular = celular;
        this.edad = edad;
        this.vehiculoAsociado = vehiculoAsociado;
        this.listaVehiculosAsociado = new LinkedList<>();
    }

    /**
     *
     * Getters y setters
     */
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
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
