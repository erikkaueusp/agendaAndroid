package com.myapp.agenda.ui.activity.dao;

import com.myapp.agenda.ui.activity.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorId =1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorId);
        this.alunos.add(aluno);
        contadorId++;

    }

    public void editar(Aluno aluno) {
        Aluno alunoEncontrado = null;
        for (Aluno a : alunos) {
            if (a.getId() == aluno.getId()) {
                alunoEncontrado = a;
            }
        } if (alunoEncontrado != null) {
            int posAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posAluno,aluno);
        }
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }


}
