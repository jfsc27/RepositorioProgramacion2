package co.edu.uniquindio;

/**
 * Clase Vehiculo de carga.
 */
public class Carga extends Vehiculo {
    public Double capacidadCarga;
    public int numeroEjes;

    /**
     * Constructor para crear un objeto Carga con los detalles específicos del vehículo.
     *
     * @param placa                 Placa del vehículo.
     * @param modelo                Modelo del vehículo.
     * @param marca                 Marca del vehículo.
     * @param color                 Color del vehículo.
     * @param propietarioAsociado   Propietario asociado al vehículo.
     * @param capacidadCarga        Capacidad de carga en toneladas.
     * @param numeroEjes            Número de ejes del vehículo.
     */
    public Carga(String placa, String modelo, String marca, String color, Propietario propietarioAsociado, Double capacidadCarga, int numeroEjes) {
        super(placa, modelo, marca, color, propietarioAsociado);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }

    /**
     *Getters y setters de los atributos: CapacidadCarga, NumerosEjes.
     */
    public Double getCapacidadCarga() {
        return capacidadCarga;
    }
    public void setCapacidadCarga(Double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    public int getNumeroEjes() {
        return numeroEjes;
    }
    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }
}
