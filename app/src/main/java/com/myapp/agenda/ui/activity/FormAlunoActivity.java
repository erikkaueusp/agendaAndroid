package com.myapp.agenda.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myapp.agenda.R;
import com.myapp.agenda.ui.activity.dao.AlunoDAO;
import com.myapp.agenda.ui.activity.model.Aluno;

public class FormAlunoActivity extends AppCompatActivity {

    public static final String TITLE = "Novo aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_aluno);

        setTitle(TITLE);

        AlunoDAO alunoDAO = new AlunoDAO();

        inicializarCampos();

        Button botaoSalvar = getButton();


        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno aluno = criaAluno(alunoDAO);

                Toast.makeText(FormAlunoActivity.this, "" +
                        "Aluno: " + aluno.getNome() +
                        " Telefone: " + aluno.getTelefone() +
                        " Email: " + aluno.getEmail() +
                        " - Salvo com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private Button getButton() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        return botaoSalvar;
    }

    private void inicializarCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    @NonNull
    private Aluno criaAluno(AlunoDAO alunoDAO) {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        Aluno aluno = new Aluno(nome, telefone, email);
        alunoDAO.salva(aluno);
        return aluno;
    }
}