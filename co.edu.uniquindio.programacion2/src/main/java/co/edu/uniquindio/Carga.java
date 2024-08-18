package co.edu.uniquindio;

public class Carga extends Vehiculo{
    public Double capacidadCarga;
    public int numeroEjes;

    public Carga(String placa, String modelo, String marca, String color, Propietario propietarioAsociado, Double capacidadCarga, int numeroEjes) {
        super(placa, modelo, marca, color, propietarioAsociado);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }

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

