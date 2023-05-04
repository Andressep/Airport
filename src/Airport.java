import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String name;
    private List<Airplane> airplanes = new ArrayList();

    // 1. Constructor con 100 aviones con datos aleatorios.
    public Airport(String name) {
        this.name = name;
        this.airplanes = airplanes;
        for (int i= 0; i < 100; i++) {
            airplanes.add(new Airplane());
        }
    }

    public String getName() {
        return name;
    }

    public List<Airplane> getPlanes() {
        return airplanes;
    }

    public void showPlanes() {
        for (Airplane airplane : getPlanes() ) {
            System.out.println(airplane);
        }
        //System.out.println(getAviones());
    }

    // 2. Metodo que muestra la cantidad de pasajeros en los 100 aviones;
    public void showPassengers() {
        int passengers = 0;
        for (Airplane airplane : getPlanes()) {
            passengers += airplane.getPassengersOnBoard();
        }
        System.out.println("Total Passengers: " + passengers);
    }

    // 3. Metodo que muestra la cantidad de asientos disponibles en los 100 aviones.
    public void availableSeats() {
        int seats = 0;
        for (Airplane airplane : getPlanes()) {
            seats += (airplane.getCapacity() - airplane.getPassengersOnBoard());
        }
        System.out.println("Seats Available In Total: " + seats);
    }
    public void getAirplaneById(int id) {
        for (Airplane airplanes : getPlanes()) {
            if (airplanes.getId() == id) {
                System.out.println(airplanes);
            }
        }
    }


    // 4. Metodo que reciba un ID y muestre la informacion del avion.
}
