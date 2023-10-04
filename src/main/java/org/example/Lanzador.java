package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Lanzador {
    public void lanzador(String[] args) {

        Cuenta cuenta = new Cuenta(10000);
        AtomicInteger transaccionesCompletadas = new AtomicInteger(0);

        for (int i = 0; i < 400; i++) {
            new HiloCliente(cuenta, 100, true).start();
            new HiloCliente(cuenta, 100, false).start();
        }

        for (int i = 0; i < 200; i++) {
            new HiloCliente(cuenta, 50, true).start();
            new HiloCliente(cuenta, 50, false).start();
        }

        for (int i = 0; i < 600; i++) {
            new HiloCliente(cuenta, 20, true).start();
            new HiloCliente(cuenta, 20, false).start();
        }

        // Espera a que todos los hilos terminen
        try {
            Thread.sleep(1000); // Este dato es variable, lo he puesto para asegurarme que todos los hilos terminan
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double saldoFinal = cuenta.obtenerSaldo();

        if (saldoFinal == 10000) {
            System.out.println("Fin de todos los hilos y completado, saldo final: " + saldoFinal);
        } else {
            System.out.println("Ha habido algún problema, saldo final: " + saldoFinal);
        }
    }
}
