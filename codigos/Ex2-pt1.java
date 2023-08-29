package com.example.pacote1;

public class Exemplo {
    private int privadoInt;
    protected int protegidoInt;
    int padraoInt;
    public int publicoInt;

    private void metodoPrivado() {
        System.out.println("Método privado");
    }

    protected void metodoProtegido() {
        System.out.println("Método protegido");
    }

    void metodoPadrao() {
        System.out.println("Método padrão");
    }

    public void metodoPublico() {
        System.out.println("Método público");
    }
}
