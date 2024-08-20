package co.edu.uniquindio;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * Clase Empresa
 */
public class Empresa {
    public String nombre;
    public Collection<Propietario> listaPropietarios;
    public Collection<Transporte> listaVehiculosTransporte;
    public Collection<Carga> listaVehiculosCarga;
    public Collection<Usuario> listaUsuarios;

    /**
     * Constructor para crear una instancia de Empresa con un nombre específico.
     * Inicializa las listas de propietarios, vehículos de transporte, vehículos de carga y usuarios.
     *
     * @param nombre Nombre de la empresa.
     */
    public Empresa (String nombre){
        this.nombre = nombre;
        this.listaPropietarios = new LinkedList<>();
        this.listaVehiculosTransporte = new LinkedList<>();
        this.listaVehiculosCarga = new LinkedList<>();
        this.listaUsuarios = new LinkedList<>();
    }

    /**
     *
     * Getters y setters.
     */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Collection<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }
    public void setListaPropietarios(Collection<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }
    public Collection<Transporte> getListaVehiculosTransporte() {
        return listaVehiculosTransporte;
    }
    public void setListaVehiculosTransporte(Collection<Transporte> listaVehiculosTransporte) {
        this.listaVehiculosTransporte = listaVehiculosTransporte;
    }
    public Collection<Carga> getListaVehiculosCarga() {
        return listaVehiculosCarga;
    }
    public void setListaVehiculosCarga(Collection<Carga> listaVehiculosCarga) {
        this.listaVehiculosCarga = listaVehiculosCarga;
    }
    public Collection<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(Collection<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    public void añadirPropietario (Propietario propietario){
        listaPropietarios.add(propietario);
    }
    public void añadirTransporte (Transporte transporte){
        listaVehiculosTransporte.add(transporte);
    }

    public void añadirCarga (Carga carga){
        listaVehiculosCarga.add(carga);
    }
    public void añadirUsuario (Usuario usuario){
        listaUsuarios.add(usuario);
    }
}
