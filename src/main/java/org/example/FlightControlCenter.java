package org.example;
import java.util.HashMap;
import java.util.Map;

public class FlightControlCenter {
    private static FlightControlCenter instance;


    private final Map<String, String> runwayStatuses;

    private FlightControlCenter() {
        System.out.println("Ініціалізація Центру керування польотами аеропорту «Буковина»...");

        runwayStatuses = new HashMap<>();
        runwayStatuses.put("Runway-1", null); // null означає, що смуга вільна
        runwayStatuses.put("Runway-2", null);
    }


    public static synchronized FlightControlCenter getInstance() {
        if (instance == null) {
            instance = new FlightControlCenter();
        }
        return instance;
    }


    public synchronized boolean bookRunway(String runwayName, String flightNumber) {
        if (!runwayStatuses.containsKey(runwayName)) {
            System.out.println("Помилка: Смуга " + runwayName + " не існує в системі!");
            return false;
        }

        String currentOccupant = runwayStatuses.get(runwayName);

        if (currentOccupant == null) {
            runwayStatuses.put(runwayName, flightNumber);
            System.out.println("[Бронювання успішне] Рейс " + flightNumber + " зайняв смугу " + runwayName + ".");
            return true;
        } else {
            System.out.println("[Відмова] Рейс " + flightNumber + " не може зайняти смугу " + runwayName + ", оскільки вона вже зайнята рейсом " + currentOccupant + "!");
            return false;
        }
    }


    public void printRunwayStatuses() {
        System.out.println("\n--- Поточний стан злітно-посадкових смуг ---");
        runwayStatuses.forEach((runway, flight) -> {
            String status = (flight == null) ? "Вільна" : "Зайнята рейсом " + flight;
            System.out.println("• " + runway + " -> " + status);
        });
        System.out.println("-------------------------------------------\n");
    }
}