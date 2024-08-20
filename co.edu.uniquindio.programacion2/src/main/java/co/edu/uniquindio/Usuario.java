package co.edu.uniquindio;

public class Usuario {
    public String nombre;
    public String edad;
    public Double peso;
    public Transporte vehiculoAsociado;

    public Usuario(String nombre, String edad,double peso, Transporte vehiculoAsociado) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.vehiculoAsociado = vehiculoAsociado;
    }

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
