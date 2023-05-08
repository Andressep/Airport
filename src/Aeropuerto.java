import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aeropuerto {
    private String nombre;
    private int nAviones;
    private List<Avion> aviones = new ArrayList<>();

    // 1. Constructor con 100 aviones con datos aleatorios.
    public Aeropuerto() {
        this.nombre = "Aeropuerto Internacional Del Congo.";
        this.aviones = aviones;
        for (int i= 0; i < 100; i++) {
            aviones.add(new Avion());
        }
    }

    // Constructor moldeable.
    public Aeropuerto(String nombre, int n) {
        this.nombre = nombre;
        this.aviones = aviones;
        for (int i= 0; i < n; i++) {
            aviones.add(new Avion());
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean procesando = true;

        while(procesando) {
            System.out.println("""
        
        Bienvenido a control y gestion del aeropuerto, seleccione una opcion:
        1. Listar el ID de todos los aviones.
        2. Listar la cantidad de pasajeros actuales en todos los aviones.
        3. Listar la cantidad de asientos disponibles en todos los aviones.
        4. Buscar y Mostrar todos los datos de un avion por su ID.
        5. Subir pasajeros (recibiendo el ID del avion).
        6. Bajar pasajeros (recibiendo el ID del avion).
        7. SALIR.
        """);

            int menu = scanner.nextInt();
            if (menu < 1 || menu > 7) {
                System.out.println("Seleccione una opcion valida.");
            }
            switch(menu) {
                case 1 :
                    mostrarAviones();
                break;
                case 2:
                    mostrarPasajerosTotales();
                break;
                case 3:
                    mostrarAsientosDisponibles();
                break;
                case 4:
                    mostrarAvionPorID();
                break;
                case 5:
                    subirPasajerosAvionPorID();
                break;
                case 6:
                    bajarPasajerosAvionPorID();
                break;
                case 7:
                    System.out.println("Usted a salido del sistema gestor del aeropuerto.");
                    procesando = false;
                break;
            }
        }
        scanner.close();
    }
    // Metodo para mostrar todos los aviones.
    public void mostrarAviones() {
        for (Avion avion : getAviones() ) {
            System.out.println(avion);
        }
    }
    // 2. Metodo que muestra la cantidad de pasajeros en los 100 aviones;
    public void mostrarPasajerosTotales() {
        int pasajeros = 0;
        for (Avion avion : getAviones()) {
            pasajeros += avion.getPasajerosActuales();
        }
        System.out.println("Total de pasajeros: " + pasajeros);
    }

    // 3. Metodo que muestra la cantidad de asientos disponibles en los 100 aviones.
    public void mostrarAsientosDisponibles() {
        int asientos = 0;
        for (Avion avion : getAviones()) {
            asientos += (avion.getCantidadMaxima() - avion.getPasajerosActuales());
        }
        System.out.println("Asientos totales disponibles: " + asientos);
    }
    public void mostrarAvionPorID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cual avion quiere visualizar por su ID, tenemos: " + aviones.size() + " aviones.");
        int IDUsuario = scanner.nextInt();

        for (Avion avion : getAviones()) {
            if (avion.getID() == IDUsuario) {
                System.out.println("Avion { ID: " + avion.getID() + " cantidadMaxima: " + avion.getCantidadMaxima() + " pasajerosActuales: " + avion.getPasajerosActuales() + " estado: " + avion.getEstado() + " }");
            }
        }
    }
    public void subirPasajerosAvionPorID() {
        Scanner scanner = new Scanner(System.in);
        boolean procesando = true;
        System.out.println("Cual avion quiere visualizar por su ID, tenemos: " + aviones.size() + " aviones.");
        int IDUsuario = scanner.nextInt();

        for (Avion avion : getAviones()) {
            if (avion.getID() == IDUsuario) {
                System.out.println("Avion { ID: " + avion.getID() + " cantidadMaxima: " + avion.getCantidadMaxima() + " pasajerosActuales: " + avion.getPasajerosActuales() + " estado: " + avion.getEstado() + " }");

                while(procesando) {
                    System.out.println("Numero de pasajeros a subir: ");
                    int numeroPasajeros = scanner.nextInt();

                    if (numeroPasajeros > avion.getCantidadMaxima()) {
                        System.out.println("Capacidad maxima de pasajeros sobrepasada.");
                    }
                    else if (numeroPasajeros <= avion.getCantidadMaxima() || numeroPasajeros <= (avion.getCantidadMaxima() - avion.getPasajerosActuales())) {
                        avion.subirPasajeros(numeroPasajeros);
                        procesando = false;
                        System.out.println("Avion { ID: " + avion.getID() + " cantidadMaxima: " + avion.getCantidadMaxima() + " pasajerosActuales: " + avion.getPasajerosActuales() + " estado: " + avion.getEstado() + " }");
                    }
                }
            }
        }
    }
    public void bajarPasajerosAvionPorID() {
        Scanner scanner = new Scanner(System.in);
        boolean procesando = true;
        System.out.println("Cual avion quiere visualizar por su ID, tenemos: " + aviones.size() + " aviones.");
        int IDUsuario = scanner.nextInt();

        for (Avion avion : getAviones()) {
            if (avion.getID() == IDUsuario) {
                System.out.println("Avion { ID: " + avion.getID() + " cantidadMaxima: " + avion.getCantidadMaxima() + " pasajerosActuales: " + avion.getPasajerosActuales() + " estado: " + avion.getEstado() + " }");

                while(procesando) {
                    System.out.println("Numero de pasajeros a bajar: ");
                    int numeroPasajeros = scanner.nextInt();

                    if (numeroPasajeros > avion.getPasajerosActuales()) {
                        System.out.println("Capacidad maxima de pasajeros sobrepasada.");
                    }
                    else if (numeroPasajeros <= avion.getPasajerosActuales()) {
                        avion.bajarPasajeros(numeroPasajeros);
                        procesando = false;
                        System.out.println("Avion { ID: " + avion.getID() + " cantidadMaxima: " + avion.getCantidadMaxima() + " pasajerosActuales: " + avion.getPasajerosActuales() + " estado: " + avion.getEstado() + " }");
                    }
                }
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<Avion> getAviones() {
        return aviones;
    }
    // 4. Metodo que reciba un ID y muestre la informacion del avion.
}
