
package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class JetBridgePool {

    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    private final List<JetBridge> bridges = new ArrayList<>();
    private final Queue<String> waitingFlights = new ArrayDeque<>();

    public JetBridgePool() {
        for (int i = 1; i <= 3; i++) {
            bridges.add(new JetBridge("T-" + i));
        }
    }

    public void requestBridge(String flightNumber) {
        JetBridge available = findAvailableBridge();

        if (available != null && waitingFlights.isEmpty()) {
            available.assignToFlight(flightNumber);
        } else {
            waitingFlights.add(flightNumber);
            log("Рейс " + flightNumber + " очікує в черзі");
            assignWaitingFlights();
        }
    }

    public void releaseBridge(String flightNumber) {
        for (JetBridge bridge : bridges) {
            if (flightNumber.equals(bridge.getCurrentFlight())) {
                bridge.reset();
                assignWaitingFlights();
                return;
            }
        }

        log("Рейс " + flightNumber + " не має призначеного телетрапа");
    }

    private JetBridge findAvailableBridge() {
        for (JetBridge bridge : bridges) {
            if (!bridge.isOccupied()) {
                return bridge;
            }
        }
        return null;
    }

    private void assignWaitingFlights() {
        while (!waitingFlights.isEmpty()) {
            JetBridge available = findAvailableBridge();

            if (available == null) {
                return;
            }

            String nextFlight = waitingFlights.remove();
            available.assignToFlight(nextFlight);
        }
    }

    public void printStatistics() {
        log("Статистика використання телетрапів:");

        for (JetBridge bridge : bridges) {
            log(bridge.getId() + " — кількість видач: "
                    + bridge.getUsageCount());
        }

        log("Загальна кількість створених телетрапів: "
                + bridges.size());
    }

    private void log(String message) {
        System.out.println("[" + LocalTime.now().format(TIME_FORMAT)
                + "] [JetBridgePool] " + message);
    }
}
