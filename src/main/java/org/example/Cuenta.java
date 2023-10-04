package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Cuenta {
    private double saldo;
    private final Lock lock = new ReentrantLock();

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad) {
        lock.lock();
        try {
            saldo += cantidad;
        } finally {
            lock.unlock();
        }
    }
    //El uso del cerrojo garantiza que las operaciones en la cuenta se realicen de manera coherente
    // y que no haya interferencia entre hilos, lo que puede llevar a errores en los cálculos del saldo

    public void retirar(double cantidad) {
        lock.lock();
        try {
            saldo -= cantidad;
        } finally {
            lock.unlock();
        }
    }

    public double obtenerSaldo() {

        return saldo;
    }
}
