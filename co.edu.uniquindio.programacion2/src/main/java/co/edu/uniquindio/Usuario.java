package co.edu.uniquindio;

public class Usuario {
    public String nombre;
    public String edad;
    public Transporte vehiculoAsociado;

    public Usuario(String nombre, String edad, Transporte vehiculoAsociado) {
        this.nombre = nombre;
        this.edad = edad;
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

    public Transporte getVehiculoAsociado() {
        return vehiculoAsociado;
    }

    public void setVehiculoAsociado(Transporte vehiculoAsociado) {
        this.vehiculoAsociado = vehiculoAsociado;
    }
}
