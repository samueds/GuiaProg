package com.example.guia.guiaapp.activities;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guia.guiaapp.R;
import com.example.guia.guiaapp.dao.UsuarioDAO;
import com.example.guia.guiaapp.model.Usuario;

import java.util.ArrayList;

public class Act_cad extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private EditText edtConfirmSenha;
    private Button registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cad);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        edtConfirmSenha = (EditText) findViewById(R.id.edtConfirmSenha);

        registrar = (Button) findViewById(R.id.bto_registrar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = edtNome.getText().toString();
                String email = edtEmail.getText().toString();
                String senha = edtSenha.getText().toString();
                String confSenha = edtConfirmSenha.getText().toString();

                Boolean camposPreenchidos = true;
                Boolean emailexiste = false;

                if(nome.equals("") || email.equals("") || senha.equals("") || confSenha.equals(""))
                    camposPreenchidos = false;

                UsuarioDAO dao = new UsuarioDAO();
                ArrayList<Usuario> lista = dao.buscarTodosUsuarios();

                for(Usuario u : lista)
                {
                    if(u.getEmail_usu().equals(email))
                    {
                        emailexiste = true;
                        break;
                    }
                }
                if(!camposPreenchidos)
                    Toast.makeText(Act_cad.this, "Complete todos os campos por favor!!", Toast.LENGTH_LONG).show();
                else if(emailexiste)
                    Toast.makeText(Act_cad.this, "Email ja está em uso! Tente outro!", Toast.LENGTH_SHORT).show();
                else if(!senha.equals(confSenha))
                    Toast.makeText(Act_cad.this, "Senhas não conferem! Tente novamente!", Toast.LENGTH_SHORT).show();
                else if(!isValidEmail(email))
                    Toast.makeText(Act_cad.this, "Email inválido! Tente novamente!", Toast.LENGTH_SHORT).show();
                else
                {
                    Usuario u = new Usuario();

                    u.setID_usu(0);
                    u.setNome_usu(nome);
                    u.setEmail_usu(email);
                    u.setSenha_usu(senha);

                    try {
                        dao.inserirUsuario(u);

                        Toast.makeText(Act_cad.this, "Sucesso!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Act_cad.this, Act_log.class);
                        startActivity(i);

                    } catch (Exception e) {

                        Toast.makeText(Act_cad.this, "Falha ao cadastrar! Tente novamente...", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                }
            }
        });

    }
    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}