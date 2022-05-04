package com.myapp.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.myapp.agenda.R;
import com.myapp.agenda.ui.activity.dao.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {


    public static final String LISTA_DE_ALUNOS = "Lista De Alunos";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);


        setTitle(LISTA_DE_ALUNOS);

        configuraFabNovoAluno();

//        List<String> alunos = new ArrayList<>(Arrays.asList("Erik","Bob","Alana","Maria","Ana"));




    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);

        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreForm();
            }
        });
    }

    private void abreForm() {
        startActivity(new Intent(ListaAlunosActivity.this,FormAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        AlunoDAO alunoDAO = new AlunoDAO();
        ListView listaAlunos = findViewById(R.id.activity_lista_de_alunos_list_view);
        listaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunoDAO.todos()));
    }


}
