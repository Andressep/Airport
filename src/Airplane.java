import java.util.Random;
import java.util.UUID;

public class Airplane {
    private UUID id;
    private int capacity;
    private int passengersOnBoard;
    private boolean state;
    private static int lastId = 0;
    public Airplane(UUID id, int capacity, int passengersOnBoard, boolean state) {
        this.id = id;
        this.capacity = capacity;
        this.passengersOnBoard = passengersOnBoard;
        this.state = state;
    }
    /*
    public Airplane() {
        Random random = new Random();
        this.id = lastId + 1; // Arroja valores entre 1 - 100.
        this.capacity = random.nextInt(101) + 100; // Arroja valores entre 100 - 200.
        this.occupiedSeats = random.nextInt(this.capacity + 1); // Arrojara valores entre 1 - capacity.
        this.state = random.nextBoolean(); // Arroja true o false aleatoriamente.
        lastId = id;
    }
    */
    public Airplane() {
        Random random = new Random();
        this.id = UUID.randomUUID(); // Arroja valores entre 1 - 100.
        this.capacity = random.nextInt(101) + 100; // Arroja valores entre 100 - 200.
        this.passengersOnBoard = random.nextInt(this.capacity + 1); // Arrojara valores entre 1 - capacity.
        this.state = random.nextBoolean(); // Arroja true o false aleatoriamente.
    }

    public UUID getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPassengersOnBoard() {
        return passengersOnBoard;
    }

    public boolean isState() {
        return state;
    }

    // M<etodo para bajar pasajeros del avion.
    public void getOffPassengers(int currentPassengers) {
        if (currentPassengers > getPassengersOnBoard()) {
            System.out.println("It is not possible to lower more passengers than we have.");
        }
        else if (currentPassengers <= getPassengersOnBoard()) {
            passengersOnBoard -= currentPassengers;
        }
    }

    // Subir pasajeros al avion.
    public void boardingPassengers(int passengersToBoard) {
        if (passengersToBoard > getCapacity() || passengersToBoard > (getCapacity() - getPassengersOnBoard())) {
            System.out.println("passenger capacity is exceeded.");
        }
        else if (passengersToBoard <= getCapacity() && (passengersToBoard + getPassengersOnBoard()) <= getCapacity()) {
            passengersOnBoard += passengersToBoard;
        }
    }

    @Override
    public String toString() {
        return "Airplane {" +
                " id = " + id +
                ", capacity = " + capacity +
                ", passengersOnBoard = " + passengersOnBoard +
                ", state = " + state + " " +
                '}';
    }
}
