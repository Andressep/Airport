public class Main {
    public static void main(String[] args) {

        Airport airport = new Airport("Main Airport");
        airport.showPlanes();
        //airport.showPassengers();
        //airport.availableSeats();
        airport.getAirplaneById(98);
    }
}