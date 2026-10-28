package org.example;
import java.util.HashMap;
import java.util.Map;

public class FlightControlCenter {
    private static volatile FlightControlCenter instance;

    private final Map<Integer, String> runways = new HashMap<>();

    private FlightControlCenter() {
        System.out.println("[10:00] [Система] Центр управління польотами ініціалізовано");
    }

    public static FlightControlCenter getInstance() {
        if (instance == null) {
            synchronized (FlightControlCenter.class) {
                if (instance == null) {
                    instance = new FlightControlCenter();
                }
            }
        }
        return instance;
    }

    public boolean bookRunway(int runwayNumber, String flightCode, String moduleName) {
        runways.putIfAbsent(runwayNumber, null);

        if (runways.get(runwayNumber) == null) {
            runways.put(runwayNumber, flightCode);
            System.out.println("[10:01] [" + moduleName + "] Смугу " + runwayNumber + " успішно заброньовано для рейсу " + flightCode);
            return true;
        } else {
            String busyBy = runways.get(runwayNumber);
            System.out.println("[10:01] [" + moduleName + "] Відмова: Смуга " + runwayNumber + " зайнята рейсом " + busyBy + " (спроба рейсу " + flightCode + ")");
            return false;
        }
    }
}