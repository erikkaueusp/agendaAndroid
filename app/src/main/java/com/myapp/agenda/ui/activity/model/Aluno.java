package com.myapp.agenda.ui.activity.model;


import androidx.annotation.NonNull;

import java.io.Serializable;


public class Aluno implements Serializable {

    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Aluno() {

    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() {
        return getNome();
    }

    public void setId(int contadorId) {
        this.id = contadorId;
    }

    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean hasIdValid() {
        return id >0;
    }
}
