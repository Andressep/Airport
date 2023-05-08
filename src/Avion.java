import java.util.Random;

public class Avion {
    private int ID;
    private int cantidadMaxima;
    private int pasajerosActuales;
    private boolean estado;
    private static int ultimoID = 1;

    // Constructor manual.
    public Avion(int ID, int cantidadMaxima, int pasajerosActuales, boolean estado) {
        this.ID = ID;
        this.cantidadMaxima = cantidadMaxima;
        this.pasajerosActuales = pasajerosActuales;
        this.estado = estado;
    }

    // Constructor Automatico.
    public Avion() {
        Random random = new Random();
        this.ID += ultimoID; // Arroja valores entre 1 - 100.
        this.cantidadMaxima = random.nextInt(101) + 100; // Arroja valores entre 100 - 200.
        this.pasajerosActuales = random.nextInt(this.cantidadMaxima + 1); // Arrojara valores entre 1 - capacity.
        this.estado = random.nextBoolean(); // Arroja true o false aleatoriamente.
        ultimoID++;
    }

    // Metodo para bajar pasajeros del avion.
    public void bajarPasajeros(int pasajerosBajan) {
        if (pasajerosBajan > this.pasajerosActuales) {
            System.out.println("No puedes bajar mas pasajeros de los que posees.");
        } else if (pasajerosBajan <= this.pasajerosActuales) {
            this.pasajerosActuales -= pasajerosBajan;
        }
    }

    // Metodo para subir pasajeros al avion.
    public void subirPasajeros(int pasajerosSuben) {
        if (pasajerosSuben > this.cantidadMaxima || pasajerosSuben > (this.cantidadMaxima - this.pasajerosActuales)) {
            System.out.println("Capacidad maxima de pasajeros sobrepasada.");
        } else if (pasajerosSuben <= this.cantidadMaxima && (pasajerosSuben + this.pasajerosActuales) <= this.cantidadMaxima) {
            this.pasajerosActuales += pasajerosSuben;
        }
    }

    // Metodo que recupera el ID del avion.
    public int getID() {
        return ID;
    }

    // Metodo que retorna la cantidad maxima de pasajeros.
    public int getCantidadMaxima() {
        return cantidadMaxima;
    }


    // Metodo que retorna la cantidad de pasajeros dentro del avion.
    public int getPasajerosActuales() {
        return pasajerosActuales;
    }

    // Metodo que retorna el estado del avion.

    public boolean getEstado() {
        return estado;
    }


    // Metodo toString() Para obtener toda la info de un avion.
    @Override
    public String toString() {
        return "Avion {" +
                " ID = " + ID +
                ", cantidadMaxima = " + cantidadMaxima +
                ", pasajerosActuales = " + pasajerosActuales +
                ", estado = " + estado + " " +
                '}';
    }
}
