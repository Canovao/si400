package com.example.pacote2;

import com.example.pacote1.Exemplo;

public class AcessoExterno {
    public static void main(String[] args) {
        Exemplo exemplo = new Exemplo();

        // Tentando acessar variáveis e métodos da classe Exemplo

        // exemplo.privadoInt; // Não é possível acessar - erro de compilação
        // exemplo.metodoPrivado(); // Não é possível acessar - erro de compilação

        // exemplo.protegidoInt; // Não é possível acessar diretamente - erro de compilação
        // exemplo.metodoProtegido(); // Não é possível acessar diretamente - erro de compilação

        // exemplo.padraoInt; // Não é possível acessar diretamente - erro de compilação
        // exemplo.metodoPadrao(); // Não é possível acessar diretamente - erro de compilação

        exemplo.publicoInt = 10; // Acesso público permitido
        exemplo.metodoPublico(); // Acesso público permitido
    }
}
