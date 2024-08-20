package co.edu.uniquindio;

/**
 * Clase Usuario
 */
public class Usuario {
    public String nombre;
    public String edad;
    public Double peso;
    public Transporte vehiculoAsociado;

    /**
     * Constructor para crear una instancia de Usuario con la información personal y el vehículo de transporte asociado.
     *
     * @param nombre             Nombre del usuario.
     * @param edad               Edad del usuario.
     * @param peso               Peso del usuario en kilogramos.
     * @param vehiculoAsociado   Vehículo de transporte asociado al usuario.
     */
    public Usuario(String nombre, String edad,double peso, Transporte vehiculoAsociado) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.vehiculoAsociado = vehiculoAsociado;
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
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public Transporte getVehiculoAsociado() {
        return vehiculoAsociado;
    }

    public void setVehiculoAsociado(Transporte vehiculoAsociado) {
        this.vehiculoAsociado = vehiculoAsociado;
    }
}
