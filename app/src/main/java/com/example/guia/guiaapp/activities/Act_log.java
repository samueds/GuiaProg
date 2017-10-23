package com.example.guia.guiaapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guia.guiaapp.R;
import com.example.guia.guiaapp.dao.UsuarioDAO;
import com.example.guia.guiaapp.model.Usuario;
import com.example.guia.guiaapp.utils.Utils;
import com.wafflecopter.charcounttextview.CharCountTextView;

import java.util.ArrayList;

public class Act_log extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_log);


        final EditText Cemail = (EditText) findViewById(R.id.edtEmail_logar);
        EditText Csenha = (EditText) findViewById(R.id.edtSenha_logar);

        CharCountTextView charCountTextView = (CharCountTextView) findViewById(R.id.tvTextCounter);

        Csenha = (EditText) findViewById(R.id.edtSenha_logar);
        charCountTextView.setEditText(Csenha);
        charCountTextView.setCharCountChangedListener(new CharCountTextView.CharCountChangedListener() {
            @Override
            public void onCountChanged(int i, boolean b) {

            }
        });

        Button botaologar = (Button) findViewById(R.id.bto_logar);
        botaologar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                //Apagar esse call intent depois.
                Intent itlogar = new Intent(Act_log.this, Act_navigation.class);
                Toast.makeText(Act_log.this, "Usuario logado!", Toast.LENGTH_LONG).show();
                startActivity(itlogar);

                /*String email = Cemail.getText().toString();
                String senha = Csenha.getText().toString();

                UsuarioDAO dao = new UsuarioDAO();

                ArrayList<Usuario> lista = dao.buscarTodosUsuarios();
                Boolean tem = false;
                Boolean senhainvalida = false;
                for(Usuario u : lista)
                {
                    if(u.getSenha_usu().equals(Utils.toMD5(senha)) && u.getEmail_usu().equals(email))
                    {
                        Intent itlogar = new Intent(Act_log.this, Act_navigation.class);
                        Toast.makeText(Act_log.this, "Usuario logado!", Toast.LENGTH_LONG).show();
                        startActivity(itlogar);
                        tem = true;
                        Cemail.setText("");
                        Csenha.setText("");
                        break;
                    }
                    else if(!u.getSenha_usu().equals(Utils.toMD5(senha)) && u.getEmail_usu().equals(email))
                    {
                        senhainvalida = true;
                    }
                }
                if(senhainvalida)
                    Toast.makeText(Act_log.this, "Senha inválida!", Toast.LENGTH_LONG).show();
                else if(!tem)
                    Toast.makeText(Act_log.this, "Usuario nao existe!", Toast.LENGTH_LONG).show();*/

            }
        });
    }
}