package co.edu.uniquindio;

/**
 *
 * Clase Vehiculo
 */
public abstract class Vehiculo {
    public String placa;
    public String modelo;
    public String marca;
    public String color;
    public Propietario propietarioAsociado;

    /**
     * Constructor para crear una instancia de Vehiculo con la información básica del vehículo y su propietario asociado.
     *
     * @param placa                Placa del vehículo.
     * @param modelo               Modelo del vehículo.
     * @param marca                Marca del vehículo.
     * @param color                Color del vehículo.
     * @param propietarioAsociado  Propietario asociado al vehículo.
     */
    public Vehiculo(String placa, String modelo, String marca, String color, Propietario propietarioAsociado) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.propietarioAsociado = propietarioAsociado;
    }

    /**
     *
     * Getters y setters
     */
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Propietario getPropietarioAsociado() {
        return propietarioAsociado;
    }
    public void setPropietarioAsociado(Propietario propietarioAsociado) {
        this.propietarioAsociado = propietarioAsociado;
    }
}

