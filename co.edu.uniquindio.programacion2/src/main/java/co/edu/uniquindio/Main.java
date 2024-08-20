package co.edu.uniquindio;

import java.util.Collection;
import java.util.LinkedList;

import javax.swing.*;

public class Main {
    private static Empresa empresa;

    public static void main(String[] args) {
        inicializarDatosPrueba();
        mostrarMenu();
    }

    private static void inicializarDatosPrueba() {
        empresa = new Empresa("Transporte Uniquindio");

        // Crear propietario de ejemplo
        Propietario propietarioX = new Propietario("Juan", "123456789", "juan@mail.com", "3002727277", null);
        empresa.añadirPropietario(propietarioX);

        // Crear vehículos de carga
        Carga vehiculoCarga1X = new Carga("JUJ427", "2020", "AWM", "Azul", propietarioX, 100.0, 4);
        Carga vehiculoCarga2X = new Carga("GTL720", "2021", "Nissan", "Blanco", propietarioX, 150.0, 6);
        empresa.añadirCarga(vehiculoCarga1X);
        empresa.añadirCarga(vehiculoCarga2X);

        // Crear vehículos de transporte y asociar usuarios
        Transporte vehiculoTransporte1X = new Transporte("SDL100", "2019", "Suzuki", "Blanco", propietarioX, 20);
        Transporte vehiculoTransporte2X = new Transporte("AAA000", "2010", "Marcopolo", "Negro", propietarioX, 22);
        empresa.añadirTransporte(vehiculoTransporte1X);
        empresa.añadirTransporte(vehiculoTransporte2X);

        // Crear y asociar usuarios a los vehículos de transporte
        Usuario usuario1 = new Usuario("Yulieth Guitierrez", "00", vehiculoTransporte1X);
        Usuario usuario2 = new Usuario("Yesenia Sofia", "25", vehiculoTransporte1X);
        vehiculoTransporte1X.getListaUsuariosAsociados().add(usuario1);
        vehiculoTransporte1X.getListaUsuariosAsociados().add(usuario2);

        Usuario usuario3X = new Usuario("Juan Smith", "48", vehiculoTransporte2X);
        Usuario usuario4X = new Usuario("Josefina María", "32", vehiculoTransporte2X);
        vehiculoTransporte2X.getListaUsuariosAsociados().add(usuario3X);
        vehiculoTransporte2X.getListaUsuariosAsociados().add(usuario4X);

        // Crear propietarios adicionales
        for (int i = 0; i < 1; i++) {
            String nombrePropietario = JOptionPane.showInputDialog("Ingrese el nombre del propietario " + (i + 1) + ":");
            String cedulaPropietario = JOptionPane.showInputDialog("Ingrese la cédula del propietario " + (i + 1) + ":");
            String emailPropietario = JOptionPane.showInputDialog("Ingrese el email del propietario " + (i + 1) + ":");
            String celularPropietario = JOptionPane.showInputDialog("Ingrese el celular del propietario " + (i + 1) + ":");

            // Crear el objeto Propietario
            Propietario propietario = new Propietario(nombrePropietario, cedulaPropietario, emailPropietario, celularPropietario, null);
            empresa.añadirPropietario(propietario);
        }

        // Crear transportes adicionales
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

            // Crear el objeto Transporte
            Transporte transporte = new Transporte(placaTransporte, modeloTransporte, marcaTransporte, colorTransporte, propietarioAsociado, maxPasajeros);
            empresa.añadirTransporte(transporte);
        }

        // Crear usuarios adicionales
        for (int i = 0; i < 1; i++) { // Crear 2 usuarios como ejemplo
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

        // Crear vehículos de carga adicionales
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
    }

    private static void mostrarMenu() {
        String[] opciones = {"Buscar número de pasajeros según placa", "Mostrar información general", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]

            );

            switch (opcion) {
                case 0:
                    buscarPasajerosPorPlaca();
                    break;
                case 1:
                    mostrarInformacionGeneral();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        } while (opcion != 2);
    }

    private static void buscarPasajerosPorPlaca() {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
        Transporte transporte = empresa.getListaVehiculosTransporte().stream()
                .filter(t -> t.getPlaca().equals(placa))
                .findFirst()
                .orElse(null);

        if (transporte != null) {
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
        Collection<Propietario> propietarios = new LinkedList<>();

        // Solicita la información de los propietarios
        int cantidadPropietarios = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de propietarios:"));{

        for (int i = 0; i < cantidadPropietarios; i++) {
            String nombre = JOptionPane.showInputDialog("Propietario " + (i + 1) + "\nNombre:");
            String cedula = JOptionPane.showInputDialog("Propietario " + (i + 1) + "\nCédula:");
            String email = JOptionPane.showInputDialog("Propietario " + (i + 1) + "\nEmail:");
            String celular = JOptionPane.showInputDialog("Propietario " + (i + 1) + "\nCelular:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Propietario " + (i + 1) + "\nEdad:"));

            // Crea un objeto Propietario y agregarlo a la colección
            Propietario propietario = new Propietario(nombre, cedula, email, celular, null, edad);
            propietarios.add(propietario);
        }

        // Calcula el número de propietarios mayores de 40 años
        int mayoresDe40 = 0;
        for (Propietario propietario : propietarios) {
            if (propietario.getEdad() > 40) {
                mayoresDe40++;
            }
        }

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, "Propietarios mayores de 40 años: " + mayoresDe40);
    }

    Collection <Usuario> usuarios= new LinkedLis<>();

// solicitar cantidad de usuarios
    int cantidadUsuarios = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de usuarios:"));{

    for (int i = 0; i < cantidadUsuarios; i++){
        String nombre = JOptionPane.showInputDialog("Usuario " + (i + 1) + "\nNombre:");
        String edad = JOptionPane.showInputDialog(" Usuario" + (i + 1) + "\nEdad:");
        String vehiculoAsociado = JOptionPane.showInputDialog("Usuario " + (i + 1) + "\nVehiculoAsociado:");   


              // Crear un objeto usuario y agregarlo a la colección
              Usuario usuario = new Usuario(nombre, edad, null);
          }

        // Pedir los valores de edad al usuario
        int edadMinima = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad mínima:"));
        int edadMaxima = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad máxima:"));

        // Contador para almacenar la cantidad de usuarios en el rango
        int usuariosEnRango = 0;

        // Verificar si cada usuario está en el rango
        if (Integer.parseInt(usuario1.getEdad()) >= edadMinima && Integer.parseInt(usuario1.getEdad()) <= edadMaxima) {
            usuariosEnRango++;
        }
        if (Integer.parseInt(usuario2.getEdad()) >= edadMinima && Integer.parseInt(usuario2.getEdad()) <= edadMaxima) {
            usuariosEnRango++;
        }
        if (Integer.parseInt(usuario3.getEdad()) >= edadMinima && Integer.parseInt(usuario3.getEdad()) <= edadMaxima) {
            usuariosEnRango++;
        }
        // ... Verifica los demás usuarios ...

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, "Usuarios en el rango de edad: " + usuariosEnRango);
    }
     }

    

