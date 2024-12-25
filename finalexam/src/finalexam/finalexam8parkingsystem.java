package finalexam;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class finalexam8parkingsystem {

    private static final int TOTAL_SPACES = 200;
    private int occupiedSpaces;
    private int availableSpaces;

    public static void main(String[] args) {
        finalexam8parkingsystem app = new finalexam8parkingsystem();
        app.simulateParking();
        app.displayParkingStatus();
    }

    public finalexam8parkingsystem() {
        simulateParking();
    }

    private void simulateParking() {
        Random random = new Random();
        this.occupiedSpaces = random.nextInt(TOTAL_SPACES + 1);
        this.availableSpaces = TOTAL_SPACES - occupiedSpaces;
    }
    private void displayParkingStatus() {
        Map<Integer, String> parkingSpaces = new HashMap<>();
        for (int i = 1; i <= TOTAL_SPACES; i++) {
            parkingSpaces.put(i, i <= occupiedSpaces ? "Occupied" : "Available");
        }

        System.out.println("Total Spaces: " + TOTAL_SPACES);
        System.out.println("Occupied Spaces: " + occupiedSpaces);
        System.out.println("Available Spaces: " + availableSpaces);
        System.out.println("Parking Space Status:");
        for (Map.Entry<Integer, String> entry : parkingSpaces.entrySet()) {
            System.out.println("Space " + entry.getKey() + ": " + entry.getValue());
        }
    }
}