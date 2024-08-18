package co.edu.uniquindio;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        inicializarDatosPrueba();
    }

    private static void inicializarDatosPrueba() {

        // Crear la empresa
        String nombreEmpresa = JOptionPane.showInputDialog("Ingrese el nombre de la empresa:");
        Empresa empresa = new Empresa(nombreEmpresa);

        // Crear propietarios
        for (int i = 0; i < 2; i++) {
            String nombrePropietario = JOptionPane.showInputDialog("Ingrese el nombre del propietario " + (i + 1) + ":");
            String cedulaPropietario = JOptionPane.showInputDialog("Ingrese la cédula del propietario " + (i + 1) + ":");
            String emailPropietario = JOptionPane.showInputDialog("Ingrese el email del propietario " + (i + 1) + ":");
            String celularPropietario = JOptionPane.showInputDialog("Ingrese el celular del propietario " + (i + 1) + ":");

            // Crear el objeto Propietario
            Propietario propietario = new Propietario(nombrePropietario, cedulaPropietario, emailPropietario, celularPropietario, null);
            empresa.añadirPropietario(propietario);
        }

        // Crear transportes
        for (int i = 0; i < 1; i++) {
            String placaTransporte = JOptionPane.showInputDialog("Ingrese la placa del transporte " + (i + 1) + ":");
            String modeloTransporte = JOptionPane.showInputDialog("Ingrese el modelo del transporte " + (i + 1) + ":");
            String marcaTransporte = JOptionPane.showInputDialog("Ingrese la marca del transporte " + (i + 1) + ":");
            String colorTransporte = JOptionPane.showInputDialog("Ingrese el color del transporte " + (i + 1) + ":");
            String nombrePropietario = JOptionPane.showInputDialog("Ingrese el nombre del propietario asociado del transporte " + (i + 1) + ":");

            // Encontrar propietario
            Propietario propietarioAsociado = empresa.getListaPropietarios().stream()
                    .filter(p -> p.getNombre().equals(nombrePropietario))
                    .findFirst()
                    .orElse(null);
            if (propietarioAsociado == null) {
                JOptionPane.showMessageDialog(null, "No se encontró el propietario con nombre: " + nombrePropietario);
                continue;
            }

            int maxPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número máximo de pasajeros del transporte " + (i + 1) + ":"));

            // Crear el objeto transporte
            Transporte transporte = new Transporte(placaTransporte, modeloTransporte, marcaTransporte, colorTransporte, propietarioAsociado, maxPasajeros);
            empresa.añadirTransporte(transporte);
        }

        // Crear usuarios
        for (int i = 0; i < 2; i++) { // Crear 2 usuarios como ejemplo
            String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre del usuario " + (i + 1) + ":");
            String edadUsuario = JOptionPane.showInputDialog("Ingrese la edad del usuario " + (i + 1) + ":");
            String placaTransporteAsociado = JOptionPane.showInputDialog("Ingrese la placa del transporte asociado al usuario " + (i + 1) + ":");

            // Encontrar transporte real
            Transporte transporteAsociado = empresa.getListaVehiculosTransporte().stream()
                    .filter(t -> t.getPlaca().equals(placaTransporteAsociado))
                    .findFirst()
                    .orElse(null);
            if (transporteAsociado == null) {
                JOptionPane.showMessageDialog(null, "No se encontró el transporte con placa: " + placaTransporteAsociado);
                continue;
            }

            // Crear el objeto Usuario
            Usuario usuario = new Usuario(nombreUsuario, edadUsuario, transporteAsociado);
            empresa.añadirUsuario(usuario);
            // Asociar el usuario al transporte
            transporteAsociado.getListaUsuariosAsociados().add(usuario);
        }

        // Crear vehículos de carga
        for (int i = 0; i < 1; i++) { // Crear 2 vehículos de carga como ejemplo
            String nombrePropietarioCarga = JOptionPane.showInputDialog("Ingrese el nombre del propietario para el vehículo de carga " + (i + 1) + ":");
            Propietario propietarioParaCarga = empresa.getListaPropietarios().stream()
                    .filter(p -> p.getNombre().equals(nombrePropietarioCarga))
                    .findFirst()
                    .orElse(null);
            if (propietarioParaCarga == null) {
                JOptionPane.showMessageDialog(null, "No se encontró el propietario con nombre: " + nombrePropietarioCarga);
                continue;
            }

            String placaCarga = JOptionPane.showInputDialog("Ingrese la placa del vehículo de carga " + (i + 1) + ":");
            String modeloCarga = JOptionPane.showInputDialog("Ingrese el modelo del vehículo de carga " + (i + 1) + ":");
            String marcaCarga = JOptionPane.showInputDialog("Ingrese la marca del vehículo de carga " + (i + 1) + ":");
            String colorCarga = JOptionPane.showInputDialog("Ingrese el color del vehículo de carga " + (i + 1) + ":");
            double capacidadCarga = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad de carga del vehículo en toneladas " + (i + 1) + ":"));
            int numeroEjes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de ejes del vehículo de carga " + (i + 1) + ":"));

            // Crear el objeto Carga y añadirlo a la empresa
            Carga carga = new Carga(placaCarga, modeloCarga, marcaCarga, colorCarga, propietarioParaCarga, capacidadCarga, numeroEjes);
            empresa.añadirCarga(carga);
        }

        // Calcular y mostrar el número de pasajeros transportados
        StringBuilder infoPasajeros = new StringBuilder("Número de pasajeros transportados por vehículo:\n");
        for (Transporte transporte : empresa.getListaVehiculosTransporte()) {
            int cantidadPasajeros = transporte.getListaUsuariosAsociados().size();
            infoPasajeros.append("Placa: ").append(transporte.getPlaca())
                    .append(", Pasajeros Transportados: ").append(cantidadPasajeros)
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, infoPasajeros.toString());

        // Mostrar datos de la empresa (solo como ejemplo)
        String mensaje = "Empresa: " + empresa.getNombre() +
                "\nPropietarios: " + empresa.getListaPropietarios().size() +
                "\nTransportes: " + empresa.getListaVehiculosTransporte().size() +
                "\nUsuarios: " + empresa.getListaUsuarios().size() +
                "\nCargas: " + empresa.getListaVehiculosCarga().size();
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
