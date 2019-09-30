package com.br.recycleview.model;

public class Alunos {
    private String nome;
    private String telefone;

    public Alunos(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public Alunos() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
