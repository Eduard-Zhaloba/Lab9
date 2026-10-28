package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Перевірка єдиного екземпляра (Singleton) ===");

        FlightControlCenter center1 = FlightControlCenter.getInstance();
        FlightControlCenter center2 = FlightControlCenter.getInstance();


        boolean isSameInstance = (center1 == center2);
        System.out.println("Чи використовують модуль 1 і модуль 2 один і той самий об'єкт? -> " + isSameInstance);

        System.out.println("\n=== Демонстрація бізнес-логіки смуг ===");


        center1.bookRunway("Runway-1", "PS-101");
        center2.bookRunway("Runway-1", "PS-202");
        center2.bookRunway("Runway-2", "PS-202");

        center1.printRunwayStatuses();












        System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВДАННЯ 2 (PROTOTYPE) ===\n");


        Flight prototypeWarsaw = new Flight("Чернівці-Варшава", "Boeing 737");
        System.out.println("[11:01] [Система] Еталон 'Чернівці-Варшава' успішно створено.");


        Flight flight1 = prototypeWarsaw.clone();
        flight1.setFlightNumber("PS-101");
        flight1.setDate("15.11.2026");

        Flight flight2 = prototypeWarsaw.clone();
        flight2.setFlightNumber("PS-102");
        flight2.setDate("16.11.2026");

        Flight flight3 = prototypeWarsaw.clone();
        flight3.setFlightNumber("PS-103");
        flight3.setDate("17.11.2026");

        System.out.println("[11:02] [Модуль] З еталона швидко згенеровано 3 рейси (PS-101, PS-102, PS-103).");


        flight1.setMenu("Преміум меню + Вегетаріанське");
        flight1.addPassenger(new Passenger("Іваненко Іван", "12A"));
        flight1.blockSeat("12A");

        System.out.println("[11:03] [Модуль] У рейс PS-101 внесено зміни: змінено меню, додано пасажира, заблоковано місце 12A.");


        prototypeWarsaw.printInfo("ЕТАЛОННИЙ РЕЙС (ПЕРЕВІРКА)");
        flight1.printInfo("ЗМІНЕНИЙ РЕЙС PS-101");
    }
}