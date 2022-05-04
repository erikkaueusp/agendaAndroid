package com.myapp.agenda.ui.activity.dao;

import com.myapp.agenda.ui.activity.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno aluno) {
        this.alunos.add(aluno);

    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }


}
