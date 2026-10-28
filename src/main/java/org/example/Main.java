package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВДАННЯ 1 (SINGLETON) ===\n");

        FlightControlCenter arrivalsModule = FlightControlCenter.getInstance();
        arrivalsModule.bookRunway(1, "PS-101", "Модуль прильотів");

        FlightControlCenter departuresModule = FlightControlCenter.getInstance();
        departuresModule.bookRunway(1, "PS-202", "Модуль вильотів");

        System.out.println("\n--- Перевірка єдиного екземпляра ---");
        boolean isSameInstance = (arrivalsModule == departuresModule);
        System.out.println("[10:02] [Перевірка] Чи це один і той самий об'єкт? " + isSameInstance);
        System.out.println("[10:02] [Перевірка] Геш-код центру з прильотів: " + arrivalsModule.hashCode());
        System.out.println("[10:02] [Перевірка] Геш-код центру з вильотів: " + departuresModule.hashCode());





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