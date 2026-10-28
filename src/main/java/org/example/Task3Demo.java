
package org.example;

public class Task3Demo {

    public static void run() {
        System.out.println("\n=== Завдання 3. Object Pool: розподіл телетрапів ===");

        JetBridgePool pool = new JetBridgePool();

        // П'ять рейсів прибувають майже одночасно
        pool.requestBridge("PS-101");
        pool.requestBridge("PS-205");
        pool.requestBridge("PS-303");
        pool.requestBridge("PS-404");
        pool.requestBridge("PS-505");

        // PS-101 завершує обслуговування та звільняє T-1
        pool.releaseBridge("PS-101");

        // Наступний рейс із черги отримує звільнений телетрап
        pool.releaseBridge("PS-205");

        // Підсумкова статистика
        pool.printStatistics();
    }

    public static void main(String[] args) {
        run();
    }
}
