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
    }
}