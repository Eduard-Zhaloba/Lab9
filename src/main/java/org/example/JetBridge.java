package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JetBridge {

    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    private final String id;
    private String currentFlight;
    private boolean occupied;
    private int usageCount;

    public JetBridge(String id) {
        this.id = id;
        this.currentFlight = null;
        this.occupied = false;
        this.usageCount = 0;

        log("Початкова підготовка " + id + ": підведення, калібрування, перевірка");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log(id + " підготовлено до роботи");
    }

    public void assignToFlight(String flightNumber) {
        if (occupied) {
            throw new IllegalStateException(id + " вже зайнятий");
        }

        currentFlight = flightNumber;
        occupied = true;
        usageCount++;

        log("Телетрап " + id + " → " + flightNumber);
    }

    public void reset() {
        currentFlight = null;
        occupied = false;

        log(id + " повернено, стан скинуто");
    }

    public String getId() {
        return id;
    }

    public String getCurrentFlight() {
        return currentFlight;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getUsageCount() {
        return usageCount;
    }

    private void log(String message) {
        System.out.println("[" + LocalTime.now().format(TIME_FORMAT)
                + "] [JetBridge] " + message);
    }
}