package org.example;
import java.util.ArrayList;
import java.util.List;

public class Flight implements Cloneable {
    private String flightNumber;
    private String destination;
    private String date;
    private String airplaneType;
    private String menu;
    private List<Passenger> passengers;
    private List<String> blockedSeats;


    public Flight(String destination, String airplaneType) {
        this.destination = destination;
        this.airplaneType = airplaneType;
        this.menu = "Стандартне меню";
        this.passengers = new ArrayList<>();
        this.blockedSeats = new ArrayList<>();


        try {
            System.out.println("[11:00] [Система] Завантаження конфігурації літака для еталона " + destination + "...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    @Override
    public Flight clone() {
        try {
            Flight cloned = (Flight) super.clone();


            cloned.passengers = new ArrayList<>();
            for (Passenger p : this.passengers) {
                cloned.passengers.add(p.clone());
            }

            cloned.blockedSeats = new ArrayList<>(this.blockedSeats);

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Помилка клонування рейсу", e);
        }
    }


    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public void setDate(String date) { this.date = date; }
    public void setMenu(String menu) { this.menu = menu; }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void blockSeat(String seat) {
        this.blockedSeats.add(seat);
    }

    public void printInfo(String label) {
        System.out.println("\n--- " + label + " ---");
        System.out.println("Рейс: " + (flightNumber != null ? flightNumber : "ЕТАЛОН") +
                " | Напрямок: " + destination +
                " | Дата: " + (date != null ? date : "Не вказано"));
        System.out.println("Тип літака: " + airplaneType + " | Меню: " + menu);
        System.out.println("Пасажири: " + passengers);
        System.out.println("Заблоковані місця: " + blockedSeats);
    }
}