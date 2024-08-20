package co.edu.uniquindio;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Font;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MainTransporte {

    private static Empresa empresa = new Empresa("Transporte Ejemplo");

    public static void main(String[] args) {
        // Mostrar el menú principal
        mostrarMenu();
    }

    private static void mostrarMenu() {
        while (true) {
            // Crear el panel personalizado con la imagen de fondo
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Cargar la imagen de fondo
                    ImageIcon icon = new ImageIcon("ruta/a/tu/imagen/fondo.jpg"); // Asegúrate de ajustar la ruta
                    Image img = icon.getImage();
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                    // Personalizar el texto del menú
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setColor(java.awt.Color.WHITE);
                    g2d.setFont(new Font("Arial", Font.BOLD, 18));
                    g2d.drawString("Menú Principal", 50, 50);
                }
            };

            // Opciones del menú
            String[] opciones = {
                    "Inicializar Datos de Prueba",
                    "Capturar Total de Pasajeros",
                    "Obtener Usuarios por Peso",
                    "Contar Propietarios Mayores de 40",
                    "Contar Usuarios por Rango de Edad",
                    "Salir"
            };

            // Mostrar el menú
            int opcion = JOptionPane.showOptionDialog(null,
                    panel,
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (opcion) {
                case 0:
                    inicializarDatos();
                    break;
                case 1:
                    capturarTotalPasajeros();
                    break;
                case 2:
                    obtenerUsuariosPorPeso();
                    break;
                case 3:
                    contarPropietariosMayoresDe40();
                    break;
                case 4:
                    contarUsuariosPorRangoDeEdad();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private static void inicializarDatos() {
        // Crear y agregar propietarios
        LinkedList<Propietario> propietarios = new LinkedList<>();
        propietarios.add(new Propietario("Juan Pérez", "123456789", "juan.perez@ejemplo.com", "3001234567", 45, null));
        propietarios.add(new Propietario("Ana Gómez", "987654321", "ana.gomez@ejemplo.com", "3009876543", 50, null));

        // Crear y agregar vehículos de carga
        LinkedList<Carga> vehiculosCarga = new LinkedList<>();
        vehiculosCarga.add(new Carga("C1", "ModeloC1", "MarcaC1", "Rojo", propietarios.get(0), 2000.0, 4));
        vehiculosCarga.add(new Carga("C2", "ModeloC2", "MarcaC2", "Azul", propietarios.get(1), 3000.0, 6));

        // Crear y agregar vehículos de transporte
        LinkedList<Transporte> vehiculosTransporte = new LinkedList<>();
        vehiculosTransporte.add(new Transporte("T1", "ModeloT1", "MarcaT1", "Verde", null, 20));
        vehiculosTransporte.add(new Transporte("T2", "ModeloT2", "MarcaT2", "Amarillo", null, 25));
        vehiculosTransporte.add(new Transporte("T3", "ModeloT3", "MarcaT3", "Blanco", null, 30));

        // Crear y agregar usuarios
        LinkedList<Usuario> usuarios = new LinkedList<>();
        usuarios.add(new Usuario("Carlos Martínez", "30", 70.0, vehiculosTransporte.get(0)));
        usuarios.add(new Usuario("Laura Ruiz", "40", 80.0, vehiculosTransporte.get(1)));
        usuarios.add(new Usuario("Pedro López", "35", 90.0, vehiculosTransporte.get(2)));
        usuarios.add(new Usuario("Marta Fernández", "25", 60.0, vehiculosTransporte.get(0)));
        usuarios.add(new Usuario("Sofía Morales", "28", 65.0, vehiculosTransporte.get(1)));

        // Asignar vehículos a propietarios
        for (int i = 0; i < propietarios.size(); i++) {
            propietarios.get(i).setVehiculoAsociado(vehiculosCarga.get(i));
            empresa.añadirPropietario(propietarios.get(i));
            empresa.añadirCarga(vehiculosCarga.get(i));
        }

        // Asignar vehículos de transporte a usuarios
        for (Usuario usuario : usuarios) {
            empresa.añadirUsuario(usuario);
            Transporte vehiculoTransporte = usuario.getVehiculoAsociado();
            if (vehiculoTransporte != null) {
                vehiculoTransporte.getListaUsuariosAsociados().add(usuario);
            }
        }

        for (Transporte transporte : vehiculosTransporte) {
            empresa.añadirTransporte(transporte);
        }

        JOptionPane.showMessageDialog(null, "Datos inicializados con éxito!");
    }

    private static void capturarTotalPasajeros() {
        LinkedList<Transporte> vehiculosTransporte = empresa.getListaVehiculosTransporte().stream().limit(3).collect(Collectors.toCollection(LinkedList::new));

        if (vehiculosTransporte.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehículos de transporte disponibles.");
            return;
        }

        int totalPasajeros = 0;
        for (Transporte transporte : vehiculosTransporte) {
            int pasajeros = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de pasajeros transportados por el vehículo con placa " + transporte.getPlaca() + ":"));
            totalPasajeros += pasajeros;
        }

        JOptionPane.showMessageDialog(null, "Total de pasajeros transportados en un día: " + totalPasajeros);
    }

    private static void obtenerUsuariosPorPeso() {
        double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de peso para filtrar usuarios:"));

        LinkedList<Usuario> usuarios = empresa.getListaUsuarios().stream()
                .filter(usuario -> usuario.getPeso() > peso)
                .collect(Collectors.toCollection(LinkedList::new));

        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios con un peso superior al valor dado.");
            return;
        }

        StringBuilder mensaje = new StringBuilder("Usuarios que superan el peso de " + peso + ":\n");
        for (Usuario usuario : usuarios) {
            mensaje.append("Nombre: ").append(usuario.getNombre()).append(", Peso: ").append(usuario.getPeso()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private static void contarPropietariosMayoresDe40() {
        long count = empresa.getListaPropietarios().stream()
                .filter(propietario -> propietario.getEdad() > 40)
                .count();

        JOptionPane.showMessageDialog(null, "Número de propietarios mayores de 40 años: " + count);
    }

    private static void contarUsuariosPorRangoDeEdad() {
        int edadMin = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad mínima:"));
        int edadMax = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad máxima:"));

        long count = empresa.getListaUsuarios().stream()
                .filter(usuario -> {
                    int edadUsuario = Integer.parseInt(usuario.getEdad());
                    return edadUsuario >= edadMin && edadUsuario <= edadMax;
                })
                .count();

        JOptionPane.showMessageDialog(null, "Número de usuarios en el rango de edad de " + edadMin + " a " + edadMax + ": " + count);
    }
}
