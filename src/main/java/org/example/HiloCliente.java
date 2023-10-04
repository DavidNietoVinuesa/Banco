package org.example;

class HiloCliente extends Thread {
    private Cuenta cuenta;
    private double cantidad;
    private boolean deposito;

    public HiloCliente(Cuenta cuenta, double cantidad, boolean deposito) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.deposito = deposito;
    }

    @Override
    public void run() {
        if (deposito) {
            cuenta.depositar(cantidad);
        } else {
            cuenta.retirar(cantidad);
        }
    }
}
